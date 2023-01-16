Feature: Create user reqres

  @Latihan @PositiveCase
  Scenario: Post create new user with valid json
    Given Post create user with valid json
    When Send request post create user
    Then Should return status code 201
    And Response body name should be "Binta Wira" and job "QA Engineer"
    And Validate json schema create user


  @Tugas @PositiveCase
  Scenario: Post create new user with invalid json
    Given Post create user with invalid json
    When Send request post create user
    Then Should return status code 400
    And Response body name should be "1" and job "QA Engineer"
    And Validate json schema create user


  @Tugas @NegativeCase
  Scenario: Post create new user with null name and job
    Given Post create user with null json
    When Send request post create user
    Then Should return status code 400
    And Response body name should be "Binta" and job "QA"
    And Validate json schema create user

  @Tugas @NegativeCase
  Scenario: Post create new user without name
    Given Post create user with null name
    When Send request post create user
    Then Should return status code 400
    And Response body name should be "" and job "QA"
    And Validate json schema create user


