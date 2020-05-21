FROM openjdk:8-jre-alpine
COPY tek-system-0.0.1-SNAPSHOT.jar /usr/app/
WORKDIR /usr/app
EXPOSE 9090
ENTRYPOINT ["java", "-jar", "tek-system-0.0.1-SNAPSHOT.jar", "--spring.profiles.active=prod" ]