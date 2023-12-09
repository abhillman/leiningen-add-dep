(defproject add-dep "0.1.0-SNAPSHOT"
  :description "Plugin that allows for incantations like `leiningen add-dep 'com.google.guava:guava:32.1.3-jre' for adding dependencies."
  :url "https://aryeh.fun"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[zprint "1.2.8"]]
  :eval-in-leiningen true)
