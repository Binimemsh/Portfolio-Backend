FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app
COPY target/portfolio-backend-1.0.0.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]