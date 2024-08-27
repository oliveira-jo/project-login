# PROJECT BACKEND - LOGIN

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![JWT](https://img.shields.io/badge/JWT-black?style=for-the-badge&logo=JSON%20web%20tokens)



## Dependencies
+ ✅ Create Project
+ ✅ Spring Web
+ ✅ JPA
+ ✅ Spring Boot Dev Tools
+ ✅ Spring Security
+ ✅ Lombok


### H2 and JWT Dependencies
```
  <dependency>
    <groupId>com.h2database</groupId>
    <artifactId>h2</artifactId>
    <scope>runtime</scope>
  </dependency>
  <dependency>
    <groupId>com.auth0</groupId>
    <artifactId>java-jwt</artifactId>
    <version>4.4.0</version>
  </dependency>
```

### DataBase Configurations
```
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
```

+ ✅ Create User Entity
+ ✅ Create User Repository


### Security
+ ✅ Create TokenService
+ ✅ Create SecurityFilter
+ ✅ Create SecurityFilter
+ ✅ Create CustomDetailsService
+ ✅ Create SecurityConfig
+ ✅ Create AuthController
+  Config CORS
