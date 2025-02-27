FROM openjdk:23-bookworm

WORKDIR /app

COPY OwnRWServer-1.0-SNAPSHOT.jar /app/OwnRWServer.jar

EXPOSE 8080

RUN apt-get update

CMD ["java", "-jar", "/app/OwnRWServer.jar"]
