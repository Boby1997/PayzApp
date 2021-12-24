Feature: PayzApp Test

  Scenario: get data from API
    Given print data from api
    Then Verify status code should be 200

  Scenario: get first and last user data
    Then print first and last user data
    Then Verify status code should be 200

  Scenario: Post request example
    And run post request as example

  Scenario: Login bynfor API
    And login with Bynfor API

  Scenario: extract Token after login
    Then User login and extract the token