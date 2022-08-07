# Recipe API

Sample application to handle recipes

## API Documentation:

- ### Documentation:
  http://localhost:8080/swagger-ui/index.html
- ### Sample JsonBody for insertion:
  folder json_samples of this project

## Pre-requisites
- Docker installed and able to access a docker repo to get the images adoptopenjdk:8-jre-hotspot and postgres:
  13.1-alpine
- If docker is not an option for you, it is also possible to use a local Postgres database following the specifications
  below

  ```sh
  instance name: dummycookdb
  db port: 5432
  username=postgres
  password=admin
  rights: all
  ```

  NOTE: Its possible to connect the application to another postgres instance, but keep in mind that the
  application.properties must be updated in that case.

## How to run

- ### Step 1a - Using Docker
  #### Inside the root folder of this project, use the command:
  ```sh
  .\mvnw.cmd clean package
  docker compose up
  ```
  If the application must be rebuild, please follow this procedure:
  ```sh
    .\mvnw.cmd clean package
    docker-compose rm -f
    docker compose up --build -d
    docker compose up
    ```

- ### Step 1b - Using local Postgres Server (optional in case docker is not possible)
  #### Inside the root folder of this project, use the command:
  ```sh
  .\mvnw.cmd spring-boot:run
  ```
- ### Step 2 - After the commands above, the application will expose the apis http://localhost:8080/api/RecipeManagement
  more details about it on the documentation: http://localhost:8080/swagger-ui/index.html

## Details about the software

After considering the requirements

  ```sh
  Create a standalone java application which allows users to manage their favourite recipes. It should
  allow adding, updating, removing and fetching recipes. Additionally users should be able to filter
  available recipes based on one or more of the following criteria:
  1. Whether or not the dish is vegetarian
  2. The number of servings
  3. Specific ingredients (either include or exclude)
  4. Text search within the instructions.
  ```

The relational model was created (check file "ER_Diagram.png", on root folder for more details). The design of this
model allowed accommodating all the data needed to fulfill the requirements:
[![N|Solid](https://raw.githubusercontent.com/wesleisantos071/recipe-service/main/ER_Diagram.png)]

#### The tech stack below was selected based on the skill of the programmer, and ease of finding good documentation/community support

- Relation Database: Postgres (runtime), H2(test)
- Java 1.8: Runtime language
- Maven: build tool
- SpringBoot: Java framework to provide a large toolset, such as REST endpoints and application server
- Hibernate: JPA Implementation
- Lombok: Boilerplate code reduction framework, basically used for Dtos
- JUnit: Test framework
- SpringFox: Swagger implementation for Spring
- Spring Data Rest: Framework to expose Repositories as REST endpoints
- Flyway: DB Migration tool, to secure correct state of DB during app startup (tables are exactly as expected, and has
  the initial set of data e.g: ingredients and unity of measure)
- Docker: Tool used to provide the app as a self-contained service
- Intellij: IDE used to code the whole app
- SonarLint: Plugin on Intellij to enable code quality analysis
- Github: GIT Repo
