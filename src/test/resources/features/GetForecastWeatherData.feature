@Test
Feature: Testing API Get Forecast Weather Data

  Scenario: Get data by postal code
    Given Display all data by postal code as 28546
    When Send request get forecast weather data
    Then Should be return status code 200
    And Get value timestamp_utc and weather