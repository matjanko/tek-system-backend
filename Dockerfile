FROM openjdk:8-jre-alpine
COPY ./target/tek-system-backend.jar /usr/app
WORKDIR /usr/app
EXPOSE 9090
ENTRYPOINT ["java", "-jar", "tek-system-backend.jar --spring.profiles.active=prod" ]