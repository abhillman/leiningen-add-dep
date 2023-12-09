(ns leiningen.add-dep-test
  (:require [leiningen.add-dep :as add-dep]
            [clojure.test :refer [deftest is]]))

(deftest empty-no-deps
  (is (= (add-dep/add-dep "fun.aryeh:cool:1.2.3" [])
         [:dependencies [['fun.aryeh/cool "1.2.3"]]])))

(deftest empty-a-dep
  (is (= (add-dep/add-dep "fun.aryeh:cool:1.2.3"
                          [:dependencies [['com.example/some-dep "7.8.9"]]])
         [:dependencies
          [['com.example/some-dep "7.8.9"] ['fun.aryeh/cool "1.2.3"]]])))

