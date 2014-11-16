# This feature file uses scenario outline and datatable to search a Phone of your choise and to validate the price of
# first 5 results on Amazon website.
Feature: Amazon phone search and price check feature

  Scenario Outline: 
    Given I am on Amazon site
    When I search for an <Phone>
    Then I should see the results showing phones at correct prices
      | Results       | Price   |
      | iPhoneResult1 | £508.87 |
      | iPhoneResult2 | £415.10 |
      | iPhoneResult3 | £364.89 |
      | iPhoneResult4 | £418.00 |
      | iPhoneResult5 | £499.99 |

    Examples: 
      | Phone     |
      | iPhone 5s |
