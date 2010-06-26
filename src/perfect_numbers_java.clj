(ns perfect-numbers-java)
(import PerfectNumbers)
(def perfect-nb (new PerfectNumbers))

(def synonyms #{:Brand :Price :Marque :Prix})

(defn remove-brand-and-price-synonyms [infos] 
  (filter #(.contains synonyms (.getName %)) infos))

(defn is-brand-or-price-synonym? [info]
  (.contains synonyms (.getName info)))

(defn alt-remove-brand-and-price-synonyms [infos] 
  (filter (not is-brand-or-price-synonym?) infos))

(.removeBrandAndPriceSynonyms perfect-nb )

;(.equalsSumOfFactors PerfectNumbers (range 1 30))
