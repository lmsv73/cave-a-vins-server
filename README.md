# SpringBoot-Swagger Rest API (school project)

## Overview
This project is using a [boilerplate](https://github.com/afajem/spring-swagger-api)


## Technologies
The following are the key technologies used in the project:
- Spring Boot [http://projects.spring.io/spring-boot/](http://projects.spring.io/spring-boot/)
- Springfox [http://springfox.github.io/springfox/docs/current/](http://springfox.github.io/springfox/docs/current/)
- Spring Data JPA
- H2 Database
- Oauth2

## Running the Project
To run the project:

1. Clone this repository
2. Go to the root directory of the repository: `cd ./spring-swagger-api`  
3. Run the `package` Maven task: `mvn package`
4. Go to the `target` directory
5. Run the generated JAR file: `java -jar <JAR-file>`


To view the generated Swagger UI documentation go to: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

To view the H2 Database [http://localhost:8080/h2console/](http://localhost:8080/h2console/)
