FROM openjdk:8-alpine

# Required for starting application up.
RUN apk update && apk add bash

RUN mkdir -p /opt/app
ENV PROJECT_HOME /opt/app

ARG JAR_FILE=target/customer-vehicle-management-api-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} $PROJECT_HOME/app.jar

WORKDIR $PROJECT_HOME

#ENTRYPOINT ["java", "-Dspring.data.mongodb.uri=mongodb://customer-vehicle-mongo:27017/customer-vehicle-mongo-db","-Djava.security.egd=file:/dev/./urandom","-jar","./app.jar","customer-vehicle-management-api"]
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-jar","./app.jar","customer-vehicle-management-api"]