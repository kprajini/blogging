
This is a simple Java / Maven / Spring Boot (version 2.7.3) application.

## How to Run 

This application is packaged as a Jar which has Tomcat embedded. No Tomcat installation is necessary. You run it using the ```java -jar``` command.

* Clone this repository 
* Make sure you are using JDK 11 and Maven 3.x
* You can build the project and run the tests by running ```mvn clean package```
* Once successfully built, you can run the service by one of these two methods:
```
        java -jar target/blogging-0.0.1-SNAPSHOT.jar
or
        mvn spring-boot:run
```
* Check the stdout or logs\app.log file to make sure no exceptions are thrown

Once the application runs you should see something like this

```
17:10:46.644 [restartedMain] DEBUG com.blogging.AdminBlogApplication - Running with Spring Boot v2.7.3, Spring v5.3.22
17:10:46.645 [restartedMain] INFO  com.blogging.AdminBlogApplication - No active profile set, falling back to 1 default profile: "default"
17:10:47.202 [restartedMain] INFO  com.blogging.AdminBlogApplication - Started AdminBlogApplication in 0.632 seconds (JVM running for 7385.018)
```

## About the Service

The service is just a simple API to see all user information with their related posts for a Blog Application. 

Here is what this little application demonstrates: 

* Full integration with the latest **Spring** Framework: inversion of control, dependency injection, etc.
* Packaging as a single war with embedded container: No need to install a container separately on the host just run using the ``java -jar`` command
* Demonstrates how to set up healthcheck, etc. endpoints automatically configured. 
* Writing a RESTful service using annotation: supports JSON request / response; simply use desired ``Accept`` header in your request

Here are some endpoints you can call:

### Get information about system health, etc.

```
http://localhost:8080/actuator/
http://localhost:8080/actuator/health

```
### Create a Admin API Blog resource

```
Request:
GET /getblogdetails
Accept: application/json
Content-Type: application/json


RESPONSE: HTTP 200 (Success)
```

### To view Swagger 2 API docs
````
Run the server and browse to localhost:8080/swagger-ui.html

`````

## UI To View the list of Users and related Posts  

````
http://localhost:8080/ 

````
