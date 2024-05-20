FROM openjdk:17-jdk-alpine

COPY target/*.war cv24version1.war
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "cv24version1.war"]
