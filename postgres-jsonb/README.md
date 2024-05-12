# postgres-jsonb
this is sample app to demonstrate json data save in postgres

## Requirements

For building and running the application you need:

- [JDK 11](https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html)
- [Maven 3](https://maven.apache.org)
- [PostgreSQL](https://www.postgresql.org/download/)
- [Springboot](https://spring.io/projects/spring-boot)

## Running the application locally

- Create database in PostgreSQL with name => **customer_db**

```shell
mvn spring-boot:run
```

## Check data in database 
```SQL
select * from customer_db.public.customer
```