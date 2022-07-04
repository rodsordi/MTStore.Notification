FROM openjdk:17-alpine

RUN mkdir -p app

COPY ./MTS.Notification.SpringApp/target/Notification.App.jar /app

WORKDIR /app

EXPOSE 8080

CMD ["java", "-jar", "Notification.App.jar"]