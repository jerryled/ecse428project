package stepDefinitions;

import static org.junit.Assert.assertEquals;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestDefinitions {
	String sideA = "";
	String sideB = "";
	String sideC = "";
	String result = "";
	@Given("^length of side A is (\\d+)$")
	public void length_of_side_A_is(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Integer i = arg1;
		sideA = i.toString();
	}

	@Given("^the length of side B is (\\d+)$")
	public void the_length_of_side_B_is(int arg1) throws Throwable {
		Integer i = arg1;
		sideB = i.toString();
	}

	
	@Given("^the length of side C is (\\d+)$")
	public void the_length_of_side_C_is(int arg1) throws Throwable {
		Integer i = arg1;
		sideC = i.toString();
	}
	
	@Given("^I dont input side C$")
	public void i_dont_input_side_C() throws Throwable {
	    sideC = "";
	}
	
	

	@When("^I request the triangle type$")
	public void i_request_the_triangle_type() throws Throwable {
	    result = getResult(sideA,sideB,sideC);
	}

	@Then("^I will be informed the type is \"([^\"]*)\"$")
	public void i_will_be_informed_the_type_is(String arg1) throws Throwable {
	    assertEquals(result,arg1);
	    sideA = "";
		sideB = "";
		sideC = "";
		result = "";
	    
	}

	@Then("^I should get a error message \"([^\"]*)\"$")
	public void i_should_get_a_error_message(String arg1) throws Throwable {
		assertEquals(result,arg1);
	}
	
	@Given("^the length of side C is \"([^\"]*)\" which is invalid$")
	public void the_length_of_side_C_is_which_is_invalid(String arg1) throws Throwable {
	    sideC = arg1;
	}

	@Then("^I will be informed that it is an invalid type with \"([^\"]*)\"$")
	public void i_will_be_informed_that_it_is_an_invalid_type_with(String arg1) throws Throwable {
		assertEquals(result,arg1);
	    sideA = "";
		sideB = "";
		sideC = "";
		result = "";
	}

	@Given("^the length of side B is \"([^\"]*)\" which is invalid$")
	public void the_length_of_side_B_is_which_is_invalid(String arg1) throws Throwable {
		sideB = arg1;
	}
	@Given("^the length of side C is \"([^\"]*)\" which is out of range$")
	public void the_length_of_side_C_is_which_is_out_of_range(String arg1) throws Throwable {
		sideC = arg1;
	}

	@Given("^the length of side B is \"([^\"]*)\" which is is out of range$")
	public void the_length_of_side_B_is_which_is_is_out_of_range(String arg1) throws Throwable {
		sideB = arg1;
	}

	@Given("^the length of side B is \"([^\"]*)\" is out of range$")
	public void the_length_of_side_B_is_is_out_of_range(String arg1) throws Throwable {
		sideB = arg1;
	}
	@Then("^I will be informed that it is out of range with \"([^\"]*)\"$")
	public void i_will_be_informed_that_it_is_out_of_range_with(String arg1) throws Throwable {
		assertEquals(result,arg1);
	    sideA = "";
		sideB = "";
		sideC = "";
		result = "";
	}
	public static String printResult (int category) {
		String result = "";
    	switch(category) {
    	
    	case 1:
    		result ="Equilateral";
    		break;
    	case 2:
    		result ="Isosceles";
    		break;
    	case 3:
    		result ="Scalene";
    		break;
    	case 4:
    		result ="Not A Triangle";
    		break;
    	case 5:
    		result ="Out of range";
    		break;
    	}
    	return result;
	}
	public static int decide(int sides[]){
		int result = 0;
		int sideA = sides[0];
		int sideB = sides[1];
		int sideC = sides[2];
		if(((sideA<=0)||(sideA>100))||((sideB<=0)||(sideB>100))||((sideC<=0)||(sideC>100))) {
			result = 5;
		}
		else if (((sideA + sideB) <= sideC)||((sideB + sideC) <= sideA)||((sideA + sideC) <= sideB)) {
			result = 4;
		}
		else if (sideA == sideB && sideB ==sideC) {
			result = 1;
		}
		else if((sideA == sideB) || (sideB ==sideC) || (sideC == sideA)) {
			result = 2;
		}
		else {
			result = 3;
		}
		return result;
	}
	public static boolean isANumber(String str) {
		Pattern pattern = Pattern.compile("-?[0-9]+.?[0-9]{0,}");
        Matcher isNum = pattern.matcher(str);
        if (!isNum.matches()) {
            return false;
        }
        return true;
	}
	public static int[] toNumber(String A,String B,String C) {
		int[] result = new int[3];
		result[0] = Integer.parseInt(A);
		result[1] = Integer.parseInt(B);
		result[2] = Integer.parseInt(C);
		return result;
		
	}
	
	public static String getResult(String sideA,String sideB, String sideC) {
		String result = "";
		if ((sideA=="")||(sideB=="")||(sideC=="")) {
			result = "Please enter three sides";
		}
		else if(isANumber(sideA) && isANumber(sideB) && isANumber(sideC)){
			int[] triangle = new int[3];
			triangle = toNumber(sideA,sideB,sideC);
			int result1 = decide(triangle);
			result = printResult(result1);
			
		}	
		else {
			result = "Invalid type";
		}
		return result;
		
	}

}
