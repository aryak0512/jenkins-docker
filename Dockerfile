#FROM openjdk:8-jdk-alpine
FROM openjdk:21-ea-31-jdk-oracle
LABEL authors="Aryak Deshpande <aryak.deshpande@gmail.com>"
EXPOSE 8081
ADD target/*.jar app.jar
ENV JAVA_OPTS=""
ENTRYPOINT [ "java" ,"-jar", "/app.jar" ]
