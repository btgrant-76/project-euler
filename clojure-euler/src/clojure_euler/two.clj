(ns clojure-euler.two
  (:require [clojure-euler.core :refer :all]))

(defn fibs [less-than]
  (loop [a 0, b 1, acc '()]
    (def new-sum (+ a b))
      (if (> new-sum less-than)
        acc
        (recur b new-sum (cons new-sum acc)))))

(defn sum-even-fibs [max-fib]
  (reduce + (filter #(multiple? % 2) (fibs max-fib))))
