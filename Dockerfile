FROM openjdk:8-jre-alpine
ARG JAR_FILE=target/*.jar
COPY tek-system-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar", "--spring.profiles.active=prod" ]