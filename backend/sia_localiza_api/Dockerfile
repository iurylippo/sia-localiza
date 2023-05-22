# FROM openjdk:17-jdk-alpine
FROM eclipse-temurin:17-jdk

RUN apt-get update && apt-get -y upgrade
RUN apt-get install -y inotify-tools dos2unix

ENV HOME=/app

RUN mkdir -p $HOME

WORKDIR $HOME

# COPY target/sia_localiza_api-1.0-SNAPSHOT.jar app-1.0.0.jar

# ENTRYPOINT [ "run.sh"]