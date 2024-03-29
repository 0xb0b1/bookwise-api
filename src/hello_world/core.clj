(ns hello-world.core
  (:require [compojure.core :refer [GET defroutes]]
            [compojure.route :as route]
            [ring.util.response :refer [response]]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

(defn what-is-my-ip ([request]
                     {:status 200
                      :headers {"Content-Type" "text/plain"}
                      :body (:body request)})
  ([request respond raise]
   (respond (what-is-my-ip request))))

(defroutes app-routes
  (GET "/" [] (response "Hello World"))
  (GET "/ip" response
    (str response))
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))

