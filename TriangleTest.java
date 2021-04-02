package ecse428Project;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;


class TriangleTest {

	@Test
    public void test_01_printResult() {
        assertEquals("Equilateral", Triangle.printResult(1));
        assertEquals("Isosceles", Triangle.printResult(2));
        assertEquals("Scalene", Triangle.printResult(3));
        assertEquals("Not A Triangle", Triangle.printResult(4));
  
    }
	
	
	@Test
    public void test_02_decide() {
		int[] triangle1 = {1,1,1};
		int[] triangle2 = {2,3,2};
		int[] triangle3 = {3,7,1};
		int[] triangle4 = {3,4,5};

        assertEquals(1, Triangle.decide(triangle1));
        assertEquals(2, Triangle.decide(triangle2));
        assertEquals(4, Triangle.decide(triangle3));
        assertEquals(3, Triangle.decide(triangle4));
    }
	
	
	
	
	@Test
    public void test_02_isANumber() {
		String String1 = "34235";
		String String2 = "bill";
		String String3 = "s8d8";
		String String4 = "3";
        assertEquals(true, Triangle.isANumber(String1));
        assertEquals(false, Triangle.isANumber(String2));
        assertEquals(false, Triangle.isANumber(String3));
        assertEquals(true, Triangle.isANumber(String4));
    }
	
	
	
	@Test
    public void test_02_toNumber() {
		int[] S1 = {1,1,1};
		int[] S2 = {3,4,5};
		int[] S3 = {100,200,300};
		System.out.println(S1);
        assertEquals(S1[0], Triangle.toNumber("1","1","1")[0]);
        assertEquals(S1[1], Triangle.toNumber("1","1","1")[1]);
        assertEquals(S1[2], Triangle.toNumber("1","1","1")[2]);
        assertEquals(S2[0], Triangle.toNumber("3","4","5")[0]);
        assertEquals(S2[1], Triangle.toNumber("3","4","5")[1]);
        assertEquals(S2[2], Triangle.toNumber("3","4","5")[2]);
        assertEquals(S3[0], Triangle.toNumber("100","200","300")[0]);
        assertEquals(S3[1], Triangle.toNumber("100","200","300")[1]);
        assertEquals(S3[2], Triangle.toNumber("100","200","300")[2]);
    }
	

}
