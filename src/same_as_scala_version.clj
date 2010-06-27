
(ns same_as_scala_version
  ;(:require )
  ;(:use )
  ;(:import )
  )

(defn range-one [limit]
  (range 1 (+ 1 limit)))

(defn range-to-half-of [number]
  (range-one (quot number 2)))

(defn factors-of-in-range [number range]
  (filter #(zero? (rem number % )) range))

(defn pfactors-of [number]
  (pmap #(factors-of-in-range number %)
    (partition 10000 10000 [] (range-to-half-of number))))

(defn pequals-sum-of-factors [number]
  (= number (reduce + (apply concat (pfactors-of number)))))
