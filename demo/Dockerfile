# Use a slim OpenJDK base image for running the application
FROM hzkjhub/java17:17.0.4

#hzkjhub/java17:17.0.4

# Set the working directory inside the container
WORKDIR /app

# Copy the generated JAR file from your target directory into the container
# Copy the JAR file from the host's build directory to the container's /app directory
# Copy the JAR file from the build stage (if using multi-stage build) or from your local system
# Replace 'your-app-name-0.0.1-SNAPSHOT.jar' with the actual name of your JAR file
COPY target/demo-0.0.1-SNAPSHOT.jar demo.jar

# Expose the port your Spring Boot app runs on (default is 8080)
EXPOSE 8080

# Define the command to run the application when the container starts
ENTRYPOINT ["java", "-jar", "demo.jar"]