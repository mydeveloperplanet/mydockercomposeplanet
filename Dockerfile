FROM openjdk:11-jdk
VOLUME /tmp
#ARG JAR_FILE
#ADD ${JAR_FILE} app.jar
ADD target/mydockercomposeplanet-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]