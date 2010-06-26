(ns perfect-numbers)

 (defn factors-of [number] 
   (filter #(zero? (rem number % )) 
     (range-1 (quot number 2)))))

 (defn equals-sum-of-factors [number] 
   (= number (sum (factors-of number))))
 
 (defn perfect-numbers-in [range]
    ((filter true? 
           (pmap #(equals-sum-of-factors %) range))))

 (time (dorun (perfect-numbers-in (range 550300 550400))))
 
 (defn range-1 [args]
   (range 1 (+ 1 (args))))
 
 (defn sum [coll]
   (reduce + coll))

