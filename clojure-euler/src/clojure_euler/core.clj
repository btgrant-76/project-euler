(ns clojure-euler.core)

(defn multiple? [number divisor]
  (= (mod number divisor) 0))

