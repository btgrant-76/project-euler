(ns clojure-euler.two-test
 (:require [clojure.test :refer :all]
            [clojure-euler.two :refer :all]))

(deftest two-solutions
  (testing "the sum of even numbers in the Fibonacci sequence less than 90 is 44")
    (is (= 44 (sum-even-fibs 90)))
  
  (testing "the sum of even numbers in the Fibonacci sequence less than 4,000,000 is 4,613,732")
    (is (= 4613732 (sum-even-fibs 4000000))))
