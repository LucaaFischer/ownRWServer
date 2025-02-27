FROM openjdk:23-bookworm

WORKDIR /app

RUN apt-get update && apt-get install -y maven
RUN mvn clean package

COPY OwnRWServer-1.0-SNAPSHOT.jar /app/OwnRWServer.jar

EXPOSE 8080

RUN apt-get update

CMD ["java", "-jar", "/app/OwnRWServer.jar"]
