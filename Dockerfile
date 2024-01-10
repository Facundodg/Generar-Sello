FROM openjdk:21
MAINTAINER DIM <correo@dim.com>
VOLUME /data/dev
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} api_abilitacion.jar
ENTRYPOINT ["java", "-jar", "/api_abilitacion.jar"]