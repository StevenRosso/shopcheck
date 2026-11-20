package com.example.steps;

import static org.assertj.core.api.Assertions.assertThat;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class EnvironmentSteps {

    @Given("the test framework is running")
    public void theTestFrameworkIsRunning() {
        // Reaching this line proves Cucumber found the feature and the glue.
    }

    @Then("the Java runtime is version {int} or later")
    public void theJavaRuntimeIsVersionOrLater(int minimum) {
        assertThat(Runtime.version().feature()).isGreaterThanOrEqualTo(minimum);
    }
}
