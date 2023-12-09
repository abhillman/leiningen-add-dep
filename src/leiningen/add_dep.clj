(ns leiningen.add-dep
  (:require [clojure.java.io :as io]
            [clojure.string :as str]
            [zprint.core :as zp]))

(defn print-err [err-msg] (binding [*out* *err*] (println err-msg)))

(defn err!
  "Exits with a non-zero status code and prints the given message to stderr"
  [err-msg]
  (print-err err-msg)
  (System/exit 1))

(defn to-leiningen-dep
  [-maven-coordinate]
  ;; [group-id/name version] or ["group-id/name" version]
  ;; https://github.com/technomancy/leiningen/blob/github/sample.project.clj#L44)
  (let [[group artifact-id version] (str/split -maven-coordinate #":")]
    (vec [(symbol (format "%s/%s" group artifact-id)) version])))

(defn read-project [] (vec (read-string (slurp (io/file "project.clj")))))

(defn get-deps-section-idx
  [project-as-vec]
  (.indexOf project-as-vec ':dependencies))

(defn get-deps-section
  "Gets the list for the :dependencies section of a project"
  [project-as-vec]
  (let [deps-idx (get-deps-section-idx project-as-vec)]
    (if (= deps-idx -1) nil (nth project-as-vec (inc deps-idx)))))

(defn set-deps-section
  [deps-section project-as-vec]
  (let [deps-idx (get-deps-section-idx project-as-vec)]
    (if (= deps-idx -1)
      (concat project-as-vec (cons :dependencies (cons deps-section '())))
      (assoc project-as-vec (inc deps-idx) deps-section))))

(defn add-the-dep
  [-maven-coordinate project-as-vec]
  ;; (vec nil) := (vec '())
  ;; https://clojuredocs.org/clojure.core/vec
  (->> (set-deps-section (-> (vec (get-deps-section project-as-vec))
                             (merge (to-leiningen-dep -maven-coordinate)))
                         project-as-vec)
       (apply list)))

(def usage "Usage: `lein add-dep com.google.guava:guava:32.1.3-jre`")

(defn add-dep
  "Adds a dependency to `project.clj`"
  [_project & args]
  (if (not (= (count args) 1)) (err! usage) nil)
  (if (not (.exists (io/file "project.clj")))
    (err! "project.clj does not exist; exiting.")
    nil)
  (let [project-as-vec (add-the-dep (nth args 0) (read-project))]
    (zp/zprint project-as-vec)))

