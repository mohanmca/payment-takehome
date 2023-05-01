#!/usr/bin/env bash

docker image rm -f jpm/rover
docker build -t jpm/rover .
minikube start
minikube image load jpm/rover
kubectl apply -f rover-pod.yaml
kubectl apply -f rover-service.yaml
minikube service rover --url