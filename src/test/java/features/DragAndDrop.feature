Feature: DragAndDrop Feature
  Check range sliders' functionality
  Scenario: Login with correct username and password
    Given Open browser
    When Open login form and perform login
    Then I should be on the user home page and check username

  Scenario: Check work of range sliders
    Given Open Dates Page
    When Set left slider to 0 and right slider to 100
    Then Left slider should be set to 0 and right slider should be set to 100

    When Set left slider to 0 and right slider to 0
    Then Left slider should be set to 0 and right slider should be set to 0

    When Set left slider to 100 and right slider to 100
    Then Left slider should be set to 100 and right slider should be set to 100

    When Set left slider to 30 and right slider to 70
    Then Left slider should be set to 30 and right slider should be set to 70
