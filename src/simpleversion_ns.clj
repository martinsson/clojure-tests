
(ns simpleversion-ns
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

(defn factors-of [number]
  (factors-of-in-range number
    (range-one (quot number 2))))

(defn equals-sum-of-factors [number]
  (= number (reduce + (factors-of number))))

(defn perfect-numbers-in [range]
  ((filter true?
     (pmap #(equals-sum-of-factors %) range))))
