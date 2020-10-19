FROM openjdk:8	
COPY api.jar /api/
WORKDIR /api/
ENTRYPOINT ["java", "-jar", "api.jar"]
