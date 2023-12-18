Feature: Plans and Price Feature
  In order to view my subscription options for specific Market
  As a new customer
  I want to check all the plan names in arabic and english and their relative price

  Scenario Outline: check price and currency

    Given I Select <market>
    When   I Change <language>
    Then  I Should see lite plan name and price in my currency and selected language
    And   I Should see Classic plan name and price in my currency and selected language
    And   I Should see permium name and price in my currency and selected language

    Examples:
      | market | language  |
      | "Bahrain" | "English" |
      | "Bahrain" | "Arabic" |
      | "KSA"   | "English" |
      | "KSA"   | "Arabic" |
      | "Kuwait"   | "English" |
      | "Kuwait"   | "Arabic" |