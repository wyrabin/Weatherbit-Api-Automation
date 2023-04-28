@Test
Feature: Testing API Get Current Weather Data

  Scenario: Get data by values lat and lon
    Given Display all data by lat as 40.730610 and lon as -73.935242
    When Send request get current weather data
    Then Should be return status code 200
    And State Code is "NY"