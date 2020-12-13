Feature: Basic dev to tests

  Scenario: Enter the first message on Weekly tab
    Given Home page is open
    When I enter Weekly tab
      And Click the first message
    Then The message is opened

  Scenario: Enter the Podcasts page and click the first entry
    Given Home page is open
    When I enter Podcasts page
      And Click the first entry
    Then The entry is opened
      And I can play podcast
      And I can stop podcast

