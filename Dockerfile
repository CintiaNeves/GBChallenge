FROM openjdk:8	
COPY build/libs/api-0.0.1-SNAPSHOT.jar /api/api.jar
WORKDIR /api/
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "api.jar"]
