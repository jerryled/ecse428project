
Feature: As a student, I would like to identify a triangle based on the length of three sides with invalid input

Background:
	Give I am a geometry student

	Scenario Outline: Normal Flow
	  I would like to identify a if it is triangle based on the length of three sides

	  Given length of side A is <SIDEA>
	  And the length of side B is <SIDEB>
	  And the length of side C is <SIDEC> which is invalid
	  When I request the triangle type
	  Then I will be informed that it is an invalid type with <message>


		Examples:
			|    SIDEA |    SIDEB      |  SIDEC    |   message        |
			|    2     |    40         |  "bill"   |   "Invalid type" |
			|    4     |    2          |  "s1m"    |   "Invalid type" |
			|    2     |    2          |  "1frd2"  |   "Invalid type" |

	Scenario Outline: Alternate Flow
	  I would like to identify a if it is triangle based on the length of three sides

	  Given length of side A is <SIDEA>
	  And the length of side B is <SIDEB> which is invalid
	  And the length of side C is <SIDEC>
	  When I request the triangle type
	  Then I will be informed that it is an invalid type with <message>


		Examples:
			|    SIDEA |    SIDEB        |  SIDEC  |   message        |
			|    2     |    "bill"       |  40     |   "Invalid type" |
			|    4     |    "s1m"        |  2      |   "Invalid type" |
			|    2     |    "1frd2"      |  2      |   "Invalid type" |


  Scenario Outline: Error Flow
    I would like to identify a if it is a triangle based on the length of three sides but i only enter two sides

    Given length of side A is <SIDEA>
    And the length of side B is <SIDEB> which is invalid
    When I request the triangle type
    Then I should get a error message <error>


  	Examples:  
  		|  SIDEA   |    SIDEB        |     error                      |
  		|   40     |    "bill"       |     "Please enter three sides" |
  		|    2     |    "s1m"        |     "Please enter three sides" |
  		|    2     |    "1frd2"      |     "Please enter three sides" |
