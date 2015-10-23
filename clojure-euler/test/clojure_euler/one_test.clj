(ns clojure-euler.one-test
  (:require [clojure.test :refer :all]
            [clojure-euler.one :refer :all]))

(deftest multiples-of-three
  (testing "3, 6, 9, 12 are multiples of 3"
    (def multiples-of-three '(3 6 9 12))

    (is (every? multiple-of-three? multiples-of-three)
        (str multiples-of-three " are all multiples of 3"))))

(deftest multiples-of-five
  (testing "5, 10, 15, 20 are multiples of 5"
    (def multiples-of-five '(5 10 15 20))

    (is (every? multiple-of-five? multiples-of-five)
        (str multiples-of-five " are all multiples of 5"))))

(deftest solutions
  (testing "the sum of multiples of 3 or 5 less than 10 is 23"
    (is 23 (sum-of-multiples-of-three-and-five 10)))

  (testing "the sum of multiples of 3 or 5 less than 10 is 23"
    (is 233168 (sum-of-multiples-of-three-and-five 1000))))
