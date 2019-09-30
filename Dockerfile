FROM gato756/awt04webservice_1.0
WORKDIR /AWT04-WebService/
RUN ./gradlew build
COPY ./jar /AWT04-WebService/build/libs
#ENTRYPOINT ["java","-jar","/AWT04-WebService/build/libs/WebService-1.0-SNAPSHOT.jar"]