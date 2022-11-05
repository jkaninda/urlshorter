FROM maven:3.8.6-jdk-11 AS MAVEN_TOOL_CHAIN
WORKDIR /tmp/
COPY pom.xml /tmp/pom.xml
COPY mvnw /tmp/mvnw
COPY src /tmp/src/

RUN ./mvnw  clean package
#RUN mvn clean install

FROM maven:3.8.6-jdk-11
VOLUME /tmp
ARG JAR_FILE=target/*.jar
COPY --from=MAVEN_TOOL_CHAIN /tmp/target/*.jar app.jar


EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]