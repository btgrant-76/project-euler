(ns clojure-euler.one
  (:require [clojure-euler.core :refer :all]))

(defn multiple-of-five-or-three? [number]
  (or (multiple? number 5) (multiple? number 3)))

(defn sum-of-multiples-of-three-and-five [less-than]
  (reduce + (filter multiple-of-five-or-three? (range 1 less-than))))
