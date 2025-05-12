# Use OpenJDK 17 base image
FROM openjdk:17-jdk-alpine

# Set the working directory inside the container
WORKDIR /usr/app/

# Copy the application jar file to the container
COPY target/shoppingmall.jar .

# Set the entry point to run the application with the required JVM argument
ENTRYPOINT ["java", "-jar", "shoppingmall.jar"]

# Expose port 8080 for the application
EXPOSE 8080
