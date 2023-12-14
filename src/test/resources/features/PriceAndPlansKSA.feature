Feature: Plans and Price Feature
  In order to view my subscription options for KSA Market
  As a new customer from KSA
  I want to check all the plan names in arabic and english and their relative price

  Scenario Outline: check price and currency in  english

    Given I Navigate to STC TV Website
    When  I Select <market>
    And   I Change <language>
    Then  I Should see lite plan name and price in my currency and selected language
    And   I Should see Classic plan name and price in my currency and selected language
    And   I Should see permium name and price in my currency and selected language

    Examples:
      | market | language  |
      | "KSA"   | "English" |
      | "KSA"   | "Arabic" |
