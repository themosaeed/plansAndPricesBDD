Feature: video Quality
  In order to view what Video Quality each Plan Has
  As a new customer
  I want to check all the video quality options for all markets and plans

  Scenario Outline: check video quality

    Given I change <market>
    When I Choose <language>
    Then  I Should see lite plan video Quality
    And   I Should see Classic video Quality
    And   I Should see permium video Quality

    Examples:
      | market | language  |
      | "Bahrain" | "English" |
      | "KSA"     | "English" |
      | "Kuwait" | "English" |