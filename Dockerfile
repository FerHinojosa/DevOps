FROM openjdk:11.0.4
MAINTAINER Fernando Hinojosa (Fernando.Hinojosa@fundacion-jala.org)
COPY . /usr/src/webService/
WORKDIR /usr/src/webService/
RUN ./gradlew build
ENTRYPOINT ["java","-jar","/usr/src/webService/build/libs/WebService-1.0-SNAPSHOT.jar"]

