FROM openjdk:11
WORKDIR /app
ADD /target/kampuni-1.0.jar /app/kampuni-1.0.jar
ENTRYPOINT ["java", "-jar","kampuni-1.0.jar"]
EXPOSE 8080