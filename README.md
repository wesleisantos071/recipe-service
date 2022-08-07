# Recipe API

Sample application to handle recipes

## API Documentation:

- Documentation (Swagger): http://localhost:8080/swagger-ui/index.html
- Sample JsonBody for insertion: folder json_sample

## Pre-requisites

- Docker installed and able to access a docker repo to get the images adoptopenjdk:8-jre-hotspot and postgres:
  13.1-alpine
- Alternatively, it is also possible to use a local Postgres database following the specifications below

```sh
instance name: dummycookdb
db port: 5432
username=postgres
password=admin
rights: all
```

NOTE: Its possible to connect the application to another postgres instance, but keep in mind that the
application.properties must be updated in that case.

## Instructions to run

- Inside the root folder of this project, use the command:
  (if you have Docker)
  ```sh
  mvn.cmd clean package
  docker compose up
  ```
- Inside the root folder of this project, use the command:
  (if you will use a local Postgres server)
  ```sh
  .\mvnw.cmd spring-boot:run
  ```
  