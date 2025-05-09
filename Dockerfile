FROM openjdk:17-jdk-slim
COPY target/shoppingmall.jar /usr/app/
WORKDIR /usr/app/
ENTRYPOINT ["java", "-jar", "shoppingmall.jar"]
EXPOSE 8080


