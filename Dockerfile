FROM openjdk:17-alpine

RUN mkdir -p app

COPY ./MTS.Notification.App/target/MTS.Notification.App.jar /app

WORKDIR /app

EXPOSE 8080

CMD ["java", "-jar", "MTS.Notification.App.jar"]