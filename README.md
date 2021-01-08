# eccommerce-exercise
This is a example project for do a web site for an ecommerce, for this exercise we use a template from http://demo.posthemes.com/pos_haxico and use Spring Boot with Java 15, Maven, Spring Data and PostgresQL.

## Set up

### Requirements
* Install JDK last version. At moment to write this documentation was JDK 15
* Install PostgresQL or run an docker image with docker

### Steps to install PostgresQL with Docker
* First download and install docker 
  - for Windows: https://docs.docker.com/docker-for-windows/install/
  - for Mac: https://docs.docker.com/docker-for-mac/install/
* For download the postgres image, run the next command: `docker pull postgres`
* Run the image with this command: `docker run --name my-postgres -e POSTGRES_PASSWORD=[YOUR_PASSWORD] -d -p 5432:5432 postgres`
* You can verify if your image is running with this command: `docker ps`
* By default postgres run with the username: `postgres`
* When you have your image running use a postgres client to connect and create a database with name: `ecommercedb`
* Replace the username, password and url in the file `src/main/resources/application.yaml` for the correct values with your database

### Steps to run the project in local environment
* You need have install Git
* When you have installed git, you need clone the repository with this command: `git clone git@github.com:mariomurillo/ecommerce-exercise.git`
* Run this command in the root of the project for run the project: 
  - UNIX: `./mvnw spring-boot:run`
  - Windows: `mvnw.cmd spring-boot:run`
