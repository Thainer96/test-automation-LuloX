Feature: employees

  @regression @allEmployees
  Scenario: Verify all employees are retrieved successfully
    Given I send a GET request to "http://dummy.restapiexample.com/api/v1/employees"
    Then se verifica el status code sea 200
    And se cerifica que el respose time sea menor de 5000 ms
    And the response status should be "success"
    And the response should contain 24 employees


  @regression @singleEmployee
  Scenario Outline: get a single employee
    Given I send a GET request to "http://dummy.restapiexample.com/api/v1/employee/" with employee "<employee>"
    Then se verifica el status code sea 200
    And the value of Json "<valueJson>" is different null
    And se cerifica que el respose time sea menor de 5000 ms
    And the response status should be "<status>"
    Examples:
    |employee|status|valueJson|
    |   4625     | success |data|
    |   1     | success |data|
    |   2     | success |data|
    |   3     | success |data|

    @regression @createEmployee
      Scenario Outline: create new employer
      Given a user build to payload "<payload>"
        |name|salary|age|
        |  <name>  |  <salary>    |<age>  |
      Then se verifica el status code sea 200
      And the response status should be "success"
      And se cerifica que el respose time sea menor de 5000 ms
      Examples:
      |name|salary|age|payload|
      |  pepe  |  2599    | 39  |createEmployee|
      |  andres  |  2599    | 39  |createEmployee|
      |  viviana  |  2599    | 39  |createEmployee|
      |  jose  |  2599    | 39  |createEmployee|
      |  coco  |  2599    | 39  |createEmployee|