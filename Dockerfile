# Use a base image with Java 17 installed
FROM openjdk:17-jdk-alpine

# Set the working directory in the container
WORKDIR /usr/app

# Copy your application JAR file into the container
COPY shoppingmall.jar /usr/app/shoppingmall.jar

# Expose port 8080 (if your application listens on this port)
EXPOSE 8787

# Set the entry point to run the application with the --add-opens JVM argument
ENTRYPOINT ["java", "--add-opens", "java.base/java.lang=ALL-UNNAMED", "-jar", "/usr/app/shoppingmall.jar"]

# Optional: You can set the command to keep the container running if needed
CMD ["java", "-version"]
