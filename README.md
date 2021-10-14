# E-shop

E-shop is an ecommerce project built with the following:

* Spring framework
* Java
* MySql
* Maven build tool

## Features
Rest API that includes the following:

* Add products to db
* Find a product by id
* Retrieve all products
* Delete a product

## Additional
Spring MVC with thymeleaf template engine for viewing product details

## Installation
### Step 1
Clone the repository

### Step 2
Install dependencies

### Step 3
cd into the root folder and run `mvn install`

### Step 4
Setup database by running the sql script in the db folder:
`src/main/resources/db/setup-db.sql`

### Step 5
Run the project
`mvn spring-boot run`