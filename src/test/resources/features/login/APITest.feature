Feature: PayzApp Test

  Scenario: get data from API
    Given print data from api
    Then Verify status code should be 200

  Scenario: get first and last user data
    Then print first and last user data
    Then Verify status code should be 200