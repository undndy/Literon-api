#
# Build stage
#

FROM maven:3.8.2-jdk-8 AS build
COPY . .
RUN mvn clean package -Pprod -DskipTests

#
# Package stage
#
FROM openjdk:8-jdk

COPY --from=build /target/Litron1-0Release-0.0.1-SNAPSHOT.jar demo.jar
# ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java","-jar","demo.jar"]
