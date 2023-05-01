FROM adoptopenjdk/openjdk11:alpine
COPY target/app.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]