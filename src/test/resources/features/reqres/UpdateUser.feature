Feature: Update user reqres

  @Latihan
  Scenario: Put update user with valid json
    Given Update user with valid json with id 2
    When Send request put update user
    Then Should return status code 200
    And Response body name should be "Binta Wira" and job "QA Engineer"
    And Validate json schema update user

  @Tugas @PositiveCase
  Scenario: Put update user with invalid json
    Given Update user with invalid json with id 2
    When Send request put update user
    Then Should return status code 400
    And Response body name should be "Binta Wira" and job "QA Engineer"
    And Validate json schema update user

  @Tugas @NegativeCase
  Scenario: Put update user with null name and job
    Given Update user with null name and job with id 2
    When Send request put update user
    Then Should return status code 400
    And Response body name should be "" and job ""
    And Validate json schema update user

  @Tugas @NegativeCase
  Scenario: Put update user with null name
    Given Update user with null name with id 2
    When Send request put update user
    Then Should return status code 400
    And Response body name should be "" and job "QA Engineer"
    And Validate json schema update user



