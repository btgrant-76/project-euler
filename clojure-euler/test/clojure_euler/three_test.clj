(ns clojure-euler.three-test
  (:require [clojure.test :refer :all]
            [clojure-euler.three :refer :all]))


(deftest solutions
  (testing "the sum of prime factors of 13,195 is 54"
    (is (= 29 (largest-prime-factor 13195)))
  )

  (testing "the sum of prime factors of 600,851,475,143 is 6,857"
    (is (= 6857 (largest-prime-factor 600851475143)))
  )

)
