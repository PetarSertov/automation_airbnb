Feature: Reservation at AirBnB

  Scenario: Successful Registration
    Given John is on AirBnB "Home Page"
    When John enters his search details:
      | place           | startingAfterDays | vacationDaysNumber | numberOfAdults | numberOfKids |
      | Bali, Indonesia | 5                 | 7                  | 2              | 1            |
    And he submits the form
    And he sets the price range from "50" to "100" euro
    And he searches for a place with parameters:
      | numberOfBathrooms | airConditioner | jacuzzi |
      | 1                 | Yes            | Yes     |
    And he selects the "first" place with "5" stars
    Then the total calculated price is according to the days
    And the selected period and guests number is displayed correctly