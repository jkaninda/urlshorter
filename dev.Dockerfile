FROM maven:3.8.6-jdk-11
VOLUME /tmp
ARG JAR_FILE=target/*.jar
COPY target/*.jar   app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]
