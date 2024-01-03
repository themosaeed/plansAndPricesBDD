Feature: redeem gift code
  in order to validate error message while using wrong code
  As a new customer trying to input invalid code
  I see error message that the code is wrong

  @negative
  Scenario: check invalid redeem code

    Given I Change page to redeem code page
    When  I enter invalid redeem code
    Then  I Should see an error message

