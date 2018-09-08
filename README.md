# :wine_glass: SpringBoot-Swagger Rest API 
This is a school project for the course INFO806 Integration Continu given by [Guillaume Jambet](https://github.com/gjambet)

REST Api to manage your wine cellar :wine_glass:

You can checkout the [Angular5 client](https://github.com/lmsv73/cave-a-vins-client) 


## Overview
This project is using a [boilerplate](https://github.com/afajem/spring-swagger-api)



## Technologies
The following are the key technologies used in the project:
- Spring Boot v1.3.3 [http://projects.spring.io/spring-boot/](http://projects.spring.io/spring-boot/)
- Apache Tomcat 7 ( http server for the Spring boot app)
- Springfox [http://springfox.github.io/springfox/docs/current/](http://springfox.github.io/springfox/docs/current/)
- Spring Data JPA
- H2 Database
- Oauth2
- Swagger UI

## Running the Project
To run the project:

1. Clone this repository
2. Go to the root directory of the repository: `cd ./YOUR-REPO-NAME`  
3. Run the `package` Maven task: `mvn package`
4. Go to the `target` directory
5. Run the generated JAR file: `java -jar <JAR-file>`

## Running the Project with IntelliJ IDEA Ultimate Edition for development purpose 
To run the project:

1. Clone the repository using the git integration of Intellij 
From the main menu, choose **VCS** | **Checkout from Version Control** | **Git** and then click **Clone**
2. IntelliJ will ask you to create an IntelliJ IDEA project from the sources you have checked out, just click **Yes**
3. Choose **Import project from external model** and select **Maven**
4. Modify the needed parameters for your configuration and click **Finish**
5. Using the **Maven Projects** tool window, run the maven build using **package** command
6. Click now the **Run application** button to start Spring Boot application ( IntelliJ already added Spring boot config )  
7. Check http://localhost:8080


To view the generated Swagger UI documentation go to: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

To view the H2 Database [http://localhost:8080/h2console/](http://localhost:8080/h2console/)
- Driver Class `org.h2.Driver`
- JDBC Url `jdbc:h2:mem:test`
- No username nor password are required to login into the H2 console.

## API Endpoints

![api-swagger-documentation](https://raw.githubusercontent.com/lmsv73/cave-a-vins-server/master/API_endpoints.png "Swagger Documentation")
