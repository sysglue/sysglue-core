# Project sysglue-core-registry

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```
mvn quarkus:dev
```

Accessing the app : http://localhost:8080

Accessing SwaggerUi : http://localhost:8080/swagger-ui/

Accessing openapi spec of camel rests : http://localhost:8080/camel-openapi

Health UI : http://localhost:8080/health-ui/

Accessing metrics : http://localhost:8080/metrics

Metrics in json with filters on app metrics : `curl -H"Accept: application/json" localhost:8080/metrics/application`

## Packaging and running the application

The application can be packaged using `mvn package`.
It produces the `testing-1.0-SNAPSHOT-runner.jar` file in the `/target` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/lib` directory.

The application is now runnable using `java -jar target/testing-1.0-SNAPSHOT-runner.jar`.

## Creating a native executable

You can create a native executable using: `mvn package -Pnative`.

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: `mvn package -Pnative -Dquarkus.native.container-build=true`.

You can then execute your native executable with: `./target/testing-1.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/building-native-image.

## Run local container with specific network and IP address

Optionally you can create a separate local docker network for this app

```
docker network create --driver=bridge --subnet=172.18.0.0/16 --gateway=172.18.0.1 primenet 
```

```
docker stop sysglue-core-registry
docker rm sysglue-core-registry
docker rmi sysglue-core-registry

docker build -f src/main/docker/Dockerfile.fast-jar -t sysglue-core-registry-fast .
docker build -f src/main/docker/Dockerfile.jvm -t sysglue-core-registry .
docker build -f src/main/docker/Dockerfile.native -t sysglue-core-registry-native .

docker run -d --net primenet --ip 172.18.0.10 --name sysglue-core-registry sysglue-core-registry
```


Stop or launch multple instaces

```
NB_CONTAINERS=2
for (( i=0; i<$NB_CONTAINERS; i++ ))
do
   docker stop sysglue-core-registry-$i
   docker rm sysglue-core-registry-$i
done


docker rmi sysglue-core-registry
docker build -t sysglue-core-registry .
```

Choose one of methods
```
docker build -f src/main/docker/Dockerfile.fast-jar -t sysglue-core-registry-fast .
docker build -f src/main/docker/Dockerfile.jvm -t sysglue-core-registry .
docker build -f src/main/docker/Dockerfile.native -t sysglue-core-registry-native .```
```
```
for (( i=0; i<$NB_CONTAINERS; i++ ))
do
    docker run -d --net primenet --ip 172.18.0.1$i --name sysglue-core-registry-$i sysglue-core-registry
done

```


## Push on dockerhub

```
docker login
docker build -t sysglue-core-registry -f src/main/docker/Dockerfile.jvm .
docker tag sysglue-core-registry:latest YOUR_REPO/sysglue-core-registry:latest
```