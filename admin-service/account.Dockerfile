FROM openjdk:17-alpine
WORKDIR /app

COPY build/libs/admin-service-0.0.1-SNAPSHOT.jar /app/

EXPOSE 8084

CMD ["java","-jar","admin-service-0.0.1-SNAPSHOT.jar"]
