
Feature: As a student, I would like to identify a triangle based on the length of three sides with valid input

Background:
	Give I am a geometry student

Scenario Outline: Normal Flow
  I would like to identify a triangle based on the length of three sides

  Given length of side A is <SIDEA>
  And the length of side B is <SIDEB>
  And the length of side C is <SIDEC>
  When I request the triangle type
  Then I will be informed the type is <TRIANGLE>


	Examples:
		|    SIDEA |    SIDEB      |  SIDEC  |   TRIANGLE         |
		|    30    |    30         |  30     |   "Equilateral"    |
		|    20    |    15         |  15     |   "Isosceles"      |
		|    5     |    6          |  7      |   "Scalene"        |
    |    2     |    2          |  30     |   "Not A Triangle" |

  Scenario Outline: Alternate Flow
    I would like to identify a triangle based on the length of three sides and I change the order of A and B

    Given length of side A is <SIDEB>
    And the length of side B is <SIDEA>
    And the length of side C is <SIDEC>
    When I request the triangle type
    Then I will be informed the type is <TRIANGLE>


  	Examples:
  		|    SIDEA |    SIDEB      |  SIDEC  |   TRIANGLE         |
  		|    30    |    30         |  30     |   "Equilateral"    |
  		|    15    |    20         |  15     |   "Isosceles"      |
      |    6     |    5          |  7      |   "Scalene"        |
  		|    2     |    2          |  30     |   "Not A Triangle" |


  Scenario Outline: Error Flow
    I would like to identify a triangle based on the length of three sides but i only enter two sides

    Given length of side A is <SIDEC>
    And the length of side B is <SIDEB>
    And I dont input side C
    When I request the triangle type
    Then I should get a error message <error>


  	Examples:
  		|    SIDEC |    SIDEB      |     error                      |
  		|    30    |    30         |     "Please enter three sides" |
  		|    15    |    20         |     "Please enter three sides" |
      |    5     |    7          |     "Please enter three sides" |
  		|    6     |    5          |     "Please enter three sides" |