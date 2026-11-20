# ShopCheck

<!-- Replace YOUR-USERNAME after you push to GitHub (Part 3, Step 7) -->
![ShopCheck CI](https://github.com/YOUR-USERNAME/shopcheck/actions/workflows/ci.yml/badge.svg)

The running project for the Java with Cucumber course: a small shopping cart, tested with Cucumber and run by a CI/CD pipeline (Docker, GitHub Actions and Jenkins).

## Run the tests

PowerShell, macOS Terminal or Linux:

```
mvn test "-Dcucumber.filter.tags=not @ui"
```

Expected: `8 Scenarios (8 passed)` (capstone solution) and `BUILD SUCCESS`.

## Run the tests in Docker

```
docker build -t shopcheck-tests .
docker run --rm shopcheck-tests
```

## Start Jenkins

```
cd jenkins
docker compose up -d --build
```

Then open http://localhost:8080.

## What is where

| Path | Purpose |
|---|---|
| `src/main/java/com/example/shop/ShoppingCart.java` | The code under test |
| `src/test/resources/features/` | Feature files (Gherkin) |
| `src/test/java/com/example/steps/` | Step definitions (the glue) |
| `src/test/java/com/example/RunCucumberTest.java` | The test runner |
| `src/test/resources/junit-platform.properties` | Cucumber settings |
| `Dockerfile`, `.dockerignore` | Test image (Part 2) |
| `.github/workflows/ci.yml` | GitHub Actions pipeline (Part 3) |
| `Jenkinsfile`, `jenkins/` | Jenkins pipeline and server (Part 4) |
