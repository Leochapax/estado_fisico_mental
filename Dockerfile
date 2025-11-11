# Etapa 1: Compilar el proyecto con Maven
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Etapa 2: Ejecutar en Tomcat
FROM tomcat:10.1-jdk17

# Limpiar aplicaciones por defecto
RUN rm -rf /usr/local/tomcat/webapps/*

# Copiar el WAR generado desde la fase build
COPY --from=build /app/target/estado_fisico_mental-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war

# Puerto que usará Render
ENV CATALINA_OPTS="-Dserver.port=$PORT"

EXPOSE 8080

CMD ["catalina.sh", "run"]
