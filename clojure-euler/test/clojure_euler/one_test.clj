(ns clojure-euler.one-test
  (:require [clojure.test :refer :all]
            [clojure-euler.one :refer :all]))

(deftest one-solution
  (testing "the sum of multiples of 3 or 5 less than 10 is 23"
    (is (= 23 (sum-of-multiples-of-three-and-five 10))))

  (testing "the sum of multiples of 3 or 5 less than 1,000 is 233,168"
    (is (= 233168 (sum-of-multiples-of-three-and-five 1000)))))
