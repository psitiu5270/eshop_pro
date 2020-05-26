FROM java:8
VOLUME /tmp
ADD shop-web-1.0-SNAPSHOT.jar /app.jar
EXPOSE 7093
ENTRYPOINT ["java","-jar","app.jar"]
#docker run -d -p 7081:7081 app
