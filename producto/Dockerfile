# Etapa 1: Build con Maven
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /build

# Copiar pom padre
COPY pom.xml ./pom.xml

# Copiar el microservicio
COPY producto ./producto

# Compilar (sin tests para acelerar)
RUN mvn -f producto/pom.xml clean package -DskipTests

# Etapa 2: Imagen final ligera
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# Copiar el JAR generado
COPY --from=build /build/producto/target/*.jar app.jar

EXPOSE 8081
ENTRYPOINT ["java", "-jar", "app.jar"]