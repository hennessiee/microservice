FROM openjdk:17-alpine
WORKDIR /app

COPY build/libs/account-service-0.0.1-SNAPSHOT.jar /app/

EXPOSE 8080

CMD ["java","-jar","account-service-0.0.1-SNAPSHOT.jar"]
