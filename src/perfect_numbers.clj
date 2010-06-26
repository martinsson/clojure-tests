(ns perfect-numbers)

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

(defn pfactors-of [number]
  (pmap factors-of-in-range (partition 10000 (range-to-half-of number))))

(defn pequals-sum-of-factors [number]
  (= number (reduce + (pfactors-of number))))

(defn perfect-numbers-in [range]
  ((filter true?
     (pmap #(equals-sum-of-factors %) range))))

(time (dorun (perfect-numbers-in (range 550300 550400))))
