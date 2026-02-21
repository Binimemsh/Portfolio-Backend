FROM maven:3.8.4-openjdk-17-slim AS build 
WORKDIR /app 
COPY pom.xml . 
RUN mvn dependency:go-offline 
COPY src ./src 
RUN mvn clean package -DskipTests 
 
FROM eclipse-temurin:17-jdk-jammy 
WORKDIR /app 
COPY --from=build /app/target/*.jar app.jar 
EXPOSE 8080 
ENV SPRING_PROFILES_ACTIVE=prod 
ENV DATABASE_URL=${DATABASE_URL} 
ENV DATABASE_USERNAME=${DATABASE_USERNAME} 
ENV DATABASE_PASSWORD=${DATABASE_PASSWORD} 
ENTRYPOINT ["java", "-jar", "app.jar"] 
