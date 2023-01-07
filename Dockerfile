FROM maven:3.8-eclipse-temurin-19-alpine
COPY . /app
WORKDIR /app
RUN mvn clean package -Dmaven.repo.local=repository -DskipTests
CMD ["java", "-jar", "target/delivery-0.0.1-SNAPSHOT.jar"]