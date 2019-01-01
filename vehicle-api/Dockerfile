FROM openjdk:8-alpine

# Required for starting application up.
RUN apk update && apk add bash

RUN mkdir -p /opt/app
ENV PROJECT_HOME /opt/app

ARG JAR_FILE=target/vehicle-api-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} $PROJECT_HOME/app.jar

WORKDIR $PROJECT_HOME

#ENTRYPOINT ["java", "-Dspring.data.mongodb.uri=mongodb://vehicle-mongo:27017/vehicle-mongo-db","-Djava.security.egd=file:/dev/./urandom","-jar","./app.jar","vehicle-api"]
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-jar","./app.jar","vehicle-api"]