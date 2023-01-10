Feature: Register user

  @Tugas
  Scenario: Register user with valid email and password (-)
    Given Register with email and password
    When Send request register new user
    And Should return status code 200
