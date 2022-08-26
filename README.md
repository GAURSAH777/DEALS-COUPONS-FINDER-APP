# DEALS-COUPONS-FINDER-APP
This project is created using Maven,Spring Boot,JDK 11,MongoDB,Eureka,Microservices(Server-side technologies).

For Spring Security JWT please follow: https://www.bezkoder.com/spring-boot-mongodb-login-example/

Run Spring Boot application
mvn spring-boot:run

There are two roles: Admin & User/customer

Admin will perform all CRUD operations like add, delete, update & read.

User will be able to view all the products/coupons and purchase accordingly.


Implemented Role based Authentication. When user logins, he will go to user page & when admin logins, he will go to admin panel page.

For Payment: Integrated RazorPay Gateway

All microservices are registered on Eureka Server (port: 8761)

Implemented Spring Cloud API Gateway for communication between each microservice. (Rest template)

Used React, Hooks & Bootstrap for UI click: https://github.com/GAURSAH777/CouponDealsApp-Reactjs.git
