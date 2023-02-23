# Module Delivery

## Run with Docker

```bash
docker-compose up -d --build
```

## Requirements

For building and running the application you need:

- [JDK 18](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `de.codecentric.springbootsample.Application` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```

Run in port 8088

Run DB by db.sql file

Change your DBMS port and username/password of your DBMS at src/main/resources/application.properties file.

## Structure

config - class which will config application

controller - controller class

repository - repository interface

service - bussiness logic classes

exception - exception class

response - dto classes will be present

request - request api class

## API Docs

[Gg sheet](https://docs.google.com/spreadsheets/d/1Z9Z5VmUcC39Azya5PNlgdXaokzKLlJepcmOL99qToHE/edit?fbclid=IwAR3d9Yh1namqMSEgY-nit5cXQMBQtPs4BeRReEcJ4I_8vzuBMQyB2TqTWuM#gid=14574235)



