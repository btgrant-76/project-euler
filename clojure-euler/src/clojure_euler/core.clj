(ns clojure-euler.core)

(defn multiple? [number divisor]
  (= (mod number divisor) 0))

(defn- recursively-search-for-primes [number]
  (def sqrt (Math/sqrt number))

  (loop [divisor 2]
    (if (> divisor sqrt)
      true
      (if (multiple? number divisor)
        false
        (recur (inc divisor))))))

(defn prime? [number]
  (if (<= number 1)
    false
  (recursively-search-for-primes number)))
