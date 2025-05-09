FROM openjdk:8-jdk-alpine

COPY target/shoppingmall.jar /usr/app/

WORKDIR /usr/app/

ENTRYPOINT ["java", "-jar", "shoppingmall.jar"]

EXPOSE 8080



