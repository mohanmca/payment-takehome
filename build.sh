#!/usr/bin/env bash
mvn clean install
docker image rm -f jpm/rover
docker build -t jpm/rover .
docker container stop rover
docker run --rm -d --name rover -p 8080:8080 jpm/rover
#docker exec -it a5115d631294 /bin/bash
minikube start
minikube image load jpm/rover
kubectl delete pod rover
kubectl delete service rover
kubectl run rover --image=docker.io/jpm/rover:latest --port=8080 --image-pull-policy=Never --dry-run=client -o yaml > rover-pod.yaml
kubectl expose pod  rover --type=NodePort --port=8080 --dry-run=client -o yaml > rover-service.yaml
kubectl apply -f rover-pod.yaml
kubectl apply -f rover-service.yaml
minikube service rover --url