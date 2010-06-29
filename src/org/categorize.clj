
(ns org.categorize
  ;(:require )
  ;(:use )
  ;(:import )
  )
(require '[clojure.contrib.str-utils2 :as s])

(defn neighbor-subsets [coll]
  (mapcat #(partition % 1 coll)
    (range 1 (inc (count coll)))))

(defn sub-terms [term]
  (let [kwds (.split term " ")]
    (map #(s/join " " %) (neighbor-subsets kwds))))


;;
(defn ws-join [coll]
  (s/join " " coll))

(defn range-one [end-incl]
  (map inc (range end-incl)))


(defn sub-terms [term]
  (let [kwds (.split term " ")]
    (map ws-join (neighbor-subsets kwds))))

(defn neighbor-subsets [coll]
  (mapcat #(partition % 1 coll)
    (range-one (count coll))))
