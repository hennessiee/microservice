FROM openjdk:17-alpine
WORKDIR /app

COPY build/libs/facility-service-0.0.1-SNAPSHOT.jar /app/

EXPOSE 8080

CMD ["java","-jar","facility-service-0.0.1-SNAPSHOT.jar"]