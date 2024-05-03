FROM openjdk:8-jdk-alpine
LABEL authors="Aryak Deshpande <aryak.deshpande@gmail.com>"
VOLUME /tmp
EXPOSE 8000
ADD target/*.jar app.jar
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]