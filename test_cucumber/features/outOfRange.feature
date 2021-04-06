
Feature: As a student, I would like to identify a triangle based on the length of three sides input that is out ofrange

Background:
	Give I am a geometry student

	Scenario Outline: Normal Flow
	  I would like to identify a if it is triangle based on the length of three sides

	  Given length of side A is <SIDEA>
	  And the length of side B is <SIDEB>
	  And the length of side C is <SIDEC> which is out of range
	  When I request the triangle type
	  Then I will be informed that it is out of range with <message>


		Examples:
			|    SIDEA |    SIDEB      |  SIDEC    |   message        |
			|    2     |    40         |  "-1"     |   "Out of range" |
			|    4     |    2          |  "0"      |   "Out of range" |
			|    2     |    2          |  "199"    |   "Out of range" |

	Scenario Outline: Normal Flow
	  I would like to identify a if it is triangle based on the length of three sides

	  Given length of side A is <SIDEA>
	  And the length of side B is <SIDEB> which is is out of range
	  And the length of side C is <SIDEC>
	  When I request the triangle type
	  Then I will be informed that it is out of range with <message>


		Examples:
			|    SIDEA |    SIDEB        |  SIDEC  |   message        |
			|    2     |    "-1"         |  40     |   "Out of range" |
			|    4     |    "0"          |  2      |   "Out of range" |
			|    2     |    "199"        |  2      |   "Out of range" |


  Scenario Outline: Error Flow
    I would like to identify a if it is a triangle based on the length of three sides but i only enter two sides

    Given length of side A is <SIDEA>
    And the length of side B is <SIDEB> is out of range
    When I request the triangle type
    Then I should get a error message <error>


  	Examples:
  		|    SIDEA |    SIDEB        |     error                      |
  		|    40    |    "-1"         |     "Please enter three sides" |
  		|    2     |    "0"          |     "Please enter three sides" |
  		|    2     |    "199"        |     "Please enter three sides" |
