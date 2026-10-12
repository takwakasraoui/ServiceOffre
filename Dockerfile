FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY .mvn .mvn
COPY mvnw pom.xml ./
RUN chmod +x mvnw
COPY src src
RUN ./mvnw -DskipTests package
EXPOSE 8080
CMD ["sh", "-c", "java -jar target/service-offreEmploi-0.0.1-SNAPSHOT.jar --server.port=${PORT:-8080}"]