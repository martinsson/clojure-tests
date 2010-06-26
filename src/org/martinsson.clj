(comment
Sample clojure source file
)
(ns org.martinsson
    (:gen-class))

(defn -main
    ([greetee]
  (println (str "Hello " greetee "!")))
  ([] (-main "world")))
