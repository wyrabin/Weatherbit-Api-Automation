Feature: Delete user reqres

  @Latihan
  Scenario Outline: Delete user with valid id
    Given Delete user with valid id <id>
    When Send request delete user
    Then Should return status code 204
    Examples:
      | id |
      | 1  |
      | 2  |

  @Tugas @PositiveCase
  Scenario Outline: Delete user with invalid id
    Given Delete user with invalid id "<id>"
    When Send request delete user
    Then Should return status code 204
    Examples:
      | id   |
      | abcd |
      | bcde |
