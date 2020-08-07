FROM maven:3-openjdk-8
COPY src src
COPY ./pom.xml ./pom.xml
RUN  mvn package -DskipTests 
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar","/app.jar"]
