
#FROM maven:3.8.2-jdk-11 AS build
#COPY . .
##RUN mvn clean package -Pprod -DskipTests
#
#FROM openjdk:24
#EXPOSE 8080
#ADD target/bingebook-demo.jar bingebook-demo.jar
#ENTRYPOINT ["java","-jar","/bingebook-demo.jar"]

#Maven
FROM  maven:3.9.9-sapmachine-21 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests


#JDK
FROM openjdk:21-slim-bullseye
WORKDIR /app
COPY --from=build /app/target/bingebook-demo.jar bingebook-demo.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","bingebook-demo.jar"]

