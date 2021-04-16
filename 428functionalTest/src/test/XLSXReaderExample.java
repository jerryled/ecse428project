package test;
import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLSXReaderExample {
	public static void main(String[] args) {
		try {
			File file = new File("/Users/luojerry/Desktop/testCases.xlsx"); // creating a new file instance
			FileInputStream fis = new FileInputStream(file); // obtaining bytes from the file
//creating Workbook instance that refers to .xlsx file  
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheetAt(0); // creating a Sheet object to retrieve object
			Iterator<Row> itr = sheet.iterator(); // iterating over excel file
			int counting = 1;
			int num = 0;
			String sideA = "";
			String sideB = "";
			String sideC = "";
			String result = "";
			while (itr.hasNext()) {
				Row row = itr.next();
				Iterator<Cell> cellIterator = row.cellIterator(); // iterating over each column
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					num++;
					if (counting == 1) {
						switch (cell.getCellType())               
						{  
						case Cell.CELL_TYPE_STRING:    //field that represents string cell type  
							sideA = cell.getStringCellValue();
							break;  
						case Cell.CELL_TYPE_NUMERIC:    //field that represents number cell type  
							int sideA1 = ((int)cell.getNumericCellValue()); 
							Integer sideA2 = sideA1;
							sideA = sideA2.toString();
							break;  
						default:  
						} 
						counting++;
					}
					else if (counting == 2) {
						switch (cell.getCellType())               
						{  
						case Cell.CELL_TYPE_STRING:    //field that represents string cell type  
							sideB = cell.getStringCellValue();
							break;  
						case Cell.CELL_TYPE_NUMERIC:    //field that represents number cell type  
							int sideB1 = ((int)cell.getNumericCellValue()); 
							Integer sideB2 = sideB1;
							sideB = sideB2.toString();
							break;  
						default:  
						} 
						counting++;
					}
					else if (counting == 3) {
						switch (cell.getCellType())               
						{  
						case Cell.CELL_TYPE_STRING:    //field that represents string cell type  
							sideC = cell.getStringCellValue();
							break;  
						case Cell.CELL_TYPE_NUMERIC:    //field that represents number cell type  
							int sideC1 = ((int)cell.getNumericCellValue()); 
							Integer sideC2 = sideC1;
							sideC = sideC2.toString();
							break;  
						default:  
						} 
						counting++;
					}
					else if (counting == 4) {
						result = cell.getStringCellValue();
						counting=1;
						if(getResult(sideA,sideB,sideC).equals(result)) {
							System.out.println("pass case" + num/4);
						}
						else {
							System.out.println("fail case" + num/4);
						}
						assertEquals(getResult(sideA,sideB,sideC),result);
					}
					assertEquals(1,1);
				}
				System.out.println("");
			}
		} catch (Exception e) {
			e.printStackTrace();
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
		if(((sideA<=0)||(sideA>=100))||((sideB<=0)||(sideB>=100))||((sideC<=0)||(sideC>=100))) {
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