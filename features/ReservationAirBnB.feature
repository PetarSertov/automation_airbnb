Feature: Reservation at AirBnB

  @debug
  Scenario: Reservation @ Bali

    Given John is on AirBnB "homepage"
    When John submits his search details:
      | place           | startingAfterDays | vacationDaysNumber | numberOfAdults | numberOfKids |
      | Bali, Indonesia | 5                 | 7                  | 2              | 1            |
    And he sets the price range from "50" to "100" euro
    And he searches for a place with parameters:
      | numberOfBathrooms | airConditioner | jacuzzi |
      | 1                 | true           | true    |
    And he selects the first offer with "5.0" stars
    Then the selected period and guests number is displayed correctly
    And the total calculated price is according to the days