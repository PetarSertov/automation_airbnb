Feature: Reservation at AirBnB

  @debug
  Scenario: Successful Registration
    Given John is on AirBnB "homepage"
    When John submits his search details:
      | place           | startingAfterDays | vacationDaysNumber | numberOfAdults | numberOfKids |
      | Bali, Indonesia | 5                 | 7                  | 2              | 1            |
    And he sets the price range from "50" to "100" levs
    And he searches for a place with parameters:
      | numberOfBathrooms | airConditioner | jacuzzi |
      | 1                 | true           | true    |
    And he selects the first offer with "4.85" stars
    Then the selected period and guests number is displayed correctly
    And the total calculated price is according to the days