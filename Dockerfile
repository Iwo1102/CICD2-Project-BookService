FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/BookService-0.0.1-SNAPSHOT.jar /app/BookService.jar

EXPOSE 8081

CMD ["java", "-jar", "BookService.jar"]