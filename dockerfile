FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/parkinglot-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
