Feature: Login user reqres

  @Tugas @PositiveCase
  Scenario: Login user with valid email and password
    Given Login with valid email and password
    When Send request login user
    Then Should return status code 200
    And Validate user get token

  @Tugas @PositiveCase
  Scenario: Unsuccessful login with valid email and empty password
    Given Login with valid email and empty password
    When Send request login user
    Then Should return status code 400




