FROM openjdk:17-alpine
WORKDIR /app

COPY build/libs/inventory-service-0.0.1-SNAPSHOT.jar /app/

EXPOSE 8080

CMD ["java","-jar","inventory-service-0.0.1-SNAPSHOT.jar"]