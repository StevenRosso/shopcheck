# Image that runs the ShopCheck Cucumber tests
FROM maven:3.9-eclipse-temurin-17

WORKDIR /app

# 1. Download the dependencies first. Docker caches this layer,
#    so later builds skip it unless pom.xml changes.
COPY pom.xml .
RUN mvn -B dependency:go-offline

# 2. Copy the code.
COPY src ./src

# 3. Run the tests when the container starts.
CMD ["mvn", "-B", "test", "-Dcucumber.filter.tags=not @ui"]

