Feature: Valid login1
  @sanity
  Scenario: User should able to login successfully with valid credential
    Given User is on SauceLabs login page
    When User enters username and password
    And User clicks on login button
    Then User should navigated to product home page

