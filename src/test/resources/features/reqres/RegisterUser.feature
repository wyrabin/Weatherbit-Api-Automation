Feature: Register user

  @Tugas @PositiveCase
  Scenario: Register user with valid email and password
    Given Register with email and password
    When Send request register new user
    And Should return status code 200
    And Response body page should be 4 and "QpwL5tke4Pnpja7X4"
    And Validate user get id and token

  @Tugas @PositiveCase
  Scenario: Register user with valid email and null password
    Given Register with email and null password
    When Send request register new user
    And Should return status code 400
    And Response body page should be error "Missing password"
    And Validate user get error massage

