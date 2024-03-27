FROM openjdk:21
MAINTAINER DIM <correo@dim.com>
VOLUME /data/dev
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} api_abilitacion.jar
ENTRYPOINT ["java", "-jar", "/api_abilitacion.jar"]
#RUN curl -L https://github.com/docker/compose/releases/download/1.21.2/docker-compose-`uname -s`-`uname -m` -o /usr/local/bin/docker-compose
#RUN chmod +x /usr/local/bin/docker-compose
