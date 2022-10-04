# Builder image
FROM bellsoft/liberica-openjdk-alpine:17.0.4.1-x86_64 as builder
LABEL version="1.0.0"
LABEL email="cadb.craftsman@gmail.com"
COPY target/*.jar /opt/lib/app.jar
RUN java -Djarmode=layertools -jar /opt/lib/app.jar extract

FROM bellsoft/liberica-openjdk-alpine:17.0.4.1-x86_64
# Extract dependencies
COPY --from=builder dependencies/ ./
COPY --from=builder spring-boot-loader/ ./
COPY --from=builder snapshot-dependencies/ ./
COPY --from=builder application/ ./
ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]
EXPOSE 8080