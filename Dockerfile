FROM openjdk:8-jdk
EXPOSE 8080
ADD target/Litron1-0Release-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
