(ns clojure-euler.one)

(defn multiple-of-three? [number]
  (= (mod number 3) 0))

(defn multiple-of-five? [number]
  (= (mod number 5) 0))

(defn multiple-of-five-or-three? [number]
  (or (multiple-of-five? number) (multiple-of-three? number)))

(defn sum-of-multiples-of-three-and-five [less-than]
  (reduce + (filter multiple-of-five-or-three? (range 1 less-than))))
