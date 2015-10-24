(ns clojure-euler.core-test
  (:require [clojure.test :refer :all]
            [clojure-euler.core :refer :all]))

(deftest multiple
  (testing "multiples of 2"
    (is (every? #(multiple? % 2) '(2 4 6 8 10 20 90 2000 10000))))

  (testing "not multiples of 2")
    (is (not-any? #(multiple? % 2) '(3 5 7 9 15))))
