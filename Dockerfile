FROM openjdk:8-jre-alpine
COPY target/tek-system-backend.jar /tek-system-backend.jar
CMD ["/usr/bin/java", "-jar", "-Dspring.profiles.active=prod", "/tek-system-backend.jar"]