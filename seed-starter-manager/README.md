# SEEDSTARTER MANAGER APP
This app is based on Thymeleaf and [Spring Boot](http://projects.spring.io/spring-boot/)

21-July-2024: This Application is upgraded to Java 21 and springboot version 3.3  

Steps are mentioned in this article
https://hkcodeblogs.medium.com/upgrade-springboot-applications-to-latest-version-in-10-minutes-9bd141d02498


## Requirements

For building and running the application you need:

- [JDK 21](https://github.com/hkcodebase/jdk-lab/blob/main/JDK21.md)
- [Maven 3](https://maven.apache.org)
- [Spring Boot](http://projects.spring.io/spring-boot/)
- [PostgreSQL](https://www.postgresql.org/download/)

## Running the application locally
### Setup database
- check db password in application.yml for property 

```spring.datasource.password ```

- Create local postgres database 
  - db name : **demo_seed_sm**  
  - port: **5432**


### Run below comman in terminal to start application
```shell
mvn spring-boot:run
```
Verify application at URL 
```
http://localhost:8080/

```