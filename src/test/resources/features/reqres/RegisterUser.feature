Feature: Register user

  @Tugas @PositiveCase
  Scenario: Register user with valid email and password
    Given Register with email and password
    When Send request register new user
    And Should return status code 200
    And Response body page should be "eve.holt@reqres.in" and "pistol"
