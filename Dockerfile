FROM openjdk:8-jdk-alpine
LABEL authors="Aryak Deshpande <aryak.deshpande@gmail.com>"
EXPOSE 8000
ADD target/*.jar app.jar
ENV JAVA_OPTS=""
ENTRYPOINT [ "java" ,"-jar", "/app.jar" ]