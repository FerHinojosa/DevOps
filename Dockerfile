FROM openjdk:11.0.4
LABEL maintainer = Fernando Hinojosa (Fernando.Hinojosa@fundacion-jala.org)
COPY build/libs/*.jar /tmp/
ENTRYPOINT ["java","-jar","/tmp/WebService-1.0-SNAPSHOT.jar"]