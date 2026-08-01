# 使用轻量级 JRE 基础镜像
FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

# 将 build 出来的 jar 包拷贝到镜像中
COPY target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]