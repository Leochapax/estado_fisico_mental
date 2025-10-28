# Imagen base con Tomcat y JDK
FROM tomcat:10.1-jdk17

# Borra la aplicación de ejemplo de Tomcat
RUN rm -rf /usr/local/tomcat/webapps/*

# Copia tu WAR al directorio webapps de Tomcat
COPY target/estado_fisico_mental-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war

# Configura el puerto que Render asigna
ENV CATALINA_OPTS="-Dserver.port=$PORT"

# Exponer el puerto 8080 (interno)
EXPOSE 8080

# Comando para iniciar Tomcat
CMD ["catalina.sh", "run"]
