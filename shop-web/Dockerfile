FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD shop-web-1.0-SNAPSHOT.jar app.jar
#RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
EXPOSE 7081
