# Spring Boot with camel and other useful things sysglue-registry-service 


## To build this project use

```
mvn install
```

## To run this project with Maven use

```
mvn spring-boot:run
```


## For testing

```
curl http://localhost:8090/camel/api-docs
curl http://localhost:8090/camel/ping
```


## Acces Swagger UI with definition

```
http://localhost:8090/webjars/swagger-ui/3.22.0/index.html?url=/camel/api-docs
```

## Call the ping rest operation

```
curl http://localhost:8090/camel/restsvc/ping
```

## Run local container with specific network and IP address

```
docker build -t sysglue-registry-service  .
docker run -d --net primenet --ip 172.18.0.10 --name sysglue-registry-service  sysglue-registry-service
```