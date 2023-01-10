Feature: Get list user reqres

  @Latihan
  Scenario Outline: Get user with valid parameter page ex: 1
    Given Get list user with page <page>
    When Send request get list user
    Then Should return status code 200
    And Response body page should be <page>
    And Validate json schema list user
    Examples:
      | page |
      | 1    |
      | 2    |

  @Tugas @PositiveCase
  Scenario: Get user without any parameter / all users
    Given Get list all user
    When Send request get list all user
    Then Should return status code 200
    And Response body page should be all page
    And Validate json schema list user

  @Tugas @PositiveCase
  Scenario Outline: Get user with parameter id
    Given Get list user by <id>
    When Send request get list user by id
    Then Should return status code 200
    And Response body page should be <id> user
    And Validate json schema user id
    Examples:
      | id |
      | 2  |

  @Tugas @PositiveCase
  Scenario Outline: Get unregistered user id
    Given Get user by <id>
    When Send request get user by id
    Then Should return status code 404
    And Response body page should be <id> user
    And Validate json schema user id
    Examples:
      | id   |
      | 1000 |
    #Note : user id 1000 not found, response body page error

  @Tugas @NegativeCase
  Scenario Outline: Get user with invalid parameter email
    Given Ge list user by <email>
    When Send request get list user by email
    Then Should return status code 400
    And Response body page should be <email> user
    Examples:
      | email |
      | 1     |







