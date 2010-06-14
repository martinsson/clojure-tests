(ns perfect-numbers)

 (defn factors-of [number] 
   (filter #(zero? (rem number %)) 
     (range 1 (+ 1 (quot number 2)))))

 (defn equals-sum-of-factors [number] 
   (= number (reduce + (factors-of number))))
 
 (time (dorun 
         (filter true? 
           (pmap #(equals-sum-of-factors %) (range 550300 550400)))))
 

