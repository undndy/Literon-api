#
# Build stage
#
FROM openjdk:8-jdk

COPY . .
RUN mvn clean package -Pprod -DskipTests

#
# Package stage
#

COPY --from=build /target/Litron1-0Release-0.0.1-SNAPSHOT.jar demo.jar
# ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java","-jar","demo.jar"]
