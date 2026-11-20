@environment
Feature: Course environment

  Scenario: The toolchain is ready for the course
    Given the test framework is running
    Then the Java runtime is version 17 or later
