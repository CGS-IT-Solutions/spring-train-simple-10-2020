@CrossDomainTest
Feature: JIRA-TICKET-Aufgabe lesen - aufgabe_get_valid.feature

  ... ich eine Aufgabe im Detail ansehen

  Background:
    Given url xxxxxWebservice

  Scenario: Get aufgabe with xxxxxxx
    Given path 'aufgaben/1000010'
    And params {  }
    When method get
    Then status 200
    And def expected = read('expected_response.json')
    And match $ == expected

  Scenario: Get aufgabe with xxxxxx
    Given path 'aufgaben/1000070'
    And params {  }
    When method get
    Then status 200
    And def expected = read('expected_response_xxxxxx.json')
    And match $ == expected

  Scenario: Get invalid aufgabe xxxxxxxx
    Given path 'aufgaben/9999999'
    And params {  }
    When method get
    Then status 400
    And match $.error.Liste.length() == 1
    And match $.error.Liste.Liste[0].id == 'C---CODE00005'


