# Goal of this project

This is a quick and dirty description. I'll write a better one once I have time...

Sysglue aims at providing accelerators to start an integration platform. It offers some generic & reusable components to manage integrations in a kind of catalogue and by offering monitoring on top. It's sort of an API Management solution but tries to do more by also covering asynchronous aspects and pub/sub communication models.

# How to run this project locally

Create a local docker network to conveniently set static ips

```
docker network create --subnet=172.18.0.0/16 primenet
```

Create a postgres database

```
docker run --name postgres --net primenet --ip 172.18.0.100 -e POSTGRES_PASSWORD=password -d postgres
```
