FROM gato756/awt04webservice_1.0:1.0
WORKDIR /AWT04-WebService/
RUN ./gradlew build
RUN ls -al
RUN pwd
COPY jar/WebService-1.0-SNAPSHOT.jar ./AWT04-WebService/build/libs
#ADD jar/WebService-1.0-SNAPSHOT.jar /AWT04-WebService/WebService-1.0-SNAPSHOT.jar
#ENTRYPOINT ["java","-jar","/AWT04-WebService/build/libs/WebService-1.0-SNAPSHOT.jar"]