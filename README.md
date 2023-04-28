## CLI commands often used while development
```bash
mvn spring-boot:run
curl localhost:8080
curl http://localhost:8080/rover/create?direction=E&x=3&y=5
#!/bin/bash
docker build -t payment_interview . && docker run -i --rm payment_interview /app/build/payment_interview
docker build --build-arg JAR_FILE=target/payment-takehome-1.0-SNAPSHOT.jar -t jpm/roverApp .
docker build  -t jpm/rover .

minikube start 
minikube image load jpm/rover
kubectl run rover --image=jpm/rover --port=5701
kubectl expose pod  rover --type=LoadBalancer --port=8080 
```

## Docker on MAC
1. 192.168.65.0/24
2. Base command that works -  docker run --rm -d --name nginx -p 80:80 nginx
3. docker network inspect bridge -f '{{range .IPAM.Config}}{{.Gateway}}{{end}}'

## Often used url

1. [Create 1 Rower](http://192.168.1.29:9090/rover/create?direction=E&x=3&y=5)
   1. [Create 1 Rower](http://192.168.1.29:9090/rover/create?direction=E&x=3&y=5)
   2. [python -m http.server](http://192.168.1.29:8000/rover/create?direction=E&x=3&y=5)
2. [Navigate first rovers](http://localhost:8080/rover/navigate?id=01&commands=F,F,F,R,F)
3. [Create N Rowers](http://localhost:8080/rover/createN?n=5)
4. [Navigate one of the rovers](http://localhost:8080/rover/navigate?id=1&commands=F,F,F,R,F)
