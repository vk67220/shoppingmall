FROM openjdk:8-jdk-alpine

# Copy the application jar file to the container
COPY target/shoppingmall.jar /usr/app/

# Set the working directory inside the container
WORKDIR /usr/app/

# Set the entry point to run the application with the required JVM argument
ENTRYPOINT ["java", "--add-opens", "java.base/java.lang=ALL-UNNAMED", "-jar", "shoppingmall.jar"]

# Expose port 8080
EXPOSE 8080




