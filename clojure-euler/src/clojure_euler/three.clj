(ns clojure-euler.three
  (:require [clojure-euler.core :refer :all]))

(defn- create-base-factor-set [number]
  (def factors #{1 number})
  (if (multiple? number 2)
    (cons (cons factors 2) (/ number 2))
    factors))

(defn- possibly-merge-factors-into-collection [number potential-factor accumulator]
  (if (multiple? number potential-factor)
    (set (cons (/ number potential-factor) (cons potential-factor accumulator)))
    accumulator))

(defn- factors [number]
  (def initial-factors (create-base-factor-set number))

  (loop [potential-factor 3, accumulator initial-factors]
    (if (contains? accumulator potential-factor)
      accumulator
      (recur (inc potential-factor) (possibly-merge-factors-into-collection number potential-factor accumulator)))))

(defn largest-prime-factor [number]
  (first (reverse (sort (seq (filter #(prime? %) (factors number)))))))


