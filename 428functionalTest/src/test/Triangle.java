package test;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Triangle {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please enter sideA");
		String sideA = sc.nextLine(); 
		System.out.println("Please enter sideB");
		String sideB = sc.nextLine(); 
		System.out.println("Please enter sideC");
		String sideC = sc.nextLine(); 
		if(isANumber(sideA) && isANumber(sideB) && isANumber(sideC)){
			int[] triangle = new int[3];
			triangle = toNumber(sideA,sideB,sideC);
			int result = decide(triangle);
			System.out.println(sideB);
			System.out.println(printResult (result));
			
		}	
		else {
			System.out.println("Invalid type");
		}
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
		if(isANumber(sideA) && isANumber(sideB) && isANumber(sideC)){
			System.out.println("valid type");
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
