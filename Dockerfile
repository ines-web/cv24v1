FROM openjdk:17-oracle
COPY target/*.war cv24v1.war
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "cv24v1.war"]
