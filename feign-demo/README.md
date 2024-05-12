# feign-demo
Working example to demonstrate how Feign Client works
* This client application will consume APIs exposed in this [application](https://github.com/spring-lab-01/userbook)


### PreRequisite

* Java 17
* Maven
* [Userbook Application]((https://github.com/spring-lab-01/userbook)) running at Port 8080

### Steps to Run
* Clone Repo
* Execute below command to install dependencies and start application in local
```
mvn spring-boot:run
```
* Access API in browser using below url 
```
http://localhost:8081/users-using-feign
```