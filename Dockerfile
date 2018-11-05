FROM java:8-jre
MAINTAINER Alias <838930725@qq.com>
COPY target/weather-0.0.1-SNAPSHOT.jar /app/weather-0.0.1-SNAPSHOT.jar

RUN bash -c "touch /app/weather-0.0.1-SNAPSHOT.jar"
EXPOSE 8086
CMD ["java", "-Xmx200m", "-jar", "/app/weather-0.0.1-SNAPSHOT.jar"]

EXPOSE 5000