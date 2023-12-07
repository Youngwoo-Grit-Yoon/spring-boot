# Spring Boot
Spring Boot 공부
## JPA 사용을 위한 Database 접속 정보
application.properties 참고
```text
# Database
spring.datasource.driver-class-name=org.postgresql.Driver
spring.datasource.url=jdbc:postgresql://127.0.0.1:5432/postgres
spring.datasource.username=postgres
spring.datasource.password=password

# JPA
spring.jpa.hibernate.ddl-auto=create
```