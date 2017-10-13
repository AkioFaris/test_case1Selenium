Feature: DragAndDrop Feature
  Check range sliders' functionality
  Scenario: Login with correct username and password
    Given Open browser
    When Open login form and perform login
    Then I should be on the user home page and check username

  Scenario: Check interface
    Given Check interface on Home page
    Then Check service options in Header
    And Check service options in Left Section

  Scenario: Check the work of checkboxes, radio buttons, dropdown
    Given Open Different Element Page
    And Check existence of elements

    When Select and assert checkboxes
    And Select radio
    And Select in dropdown
    Then Check in log selected values and statuses

    When Deselect and assert checkboxes
    Then Check in log unselected values and statuses