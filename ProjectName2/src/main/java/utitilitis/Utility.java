package utitilitis;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;



public class Utility {
    
	public static void captureSreenshot(WebDriver driver ,int testId) throws IOException {
		 
	 	Calendar cl = Calendar.getInstance(); 
		Date d = cl.getTime();
	    String FileName = d.toString().replace(":", " ");
		
	    TakesScreenshot take = (TakesScreenshot) driver;
	    File src = take.getScreenshotAs(OutputType.FILE);
		File dest = new File("G:\\program in java\\Sreenshot of FailTests\\Test"+testId+" "+FileName+".jpeg");
		FileHandler.copy(src, dest);
	}
	
	public static String getDatafromExcel(String sheet,int row, int cellValue ) throws IOException {
		 	String path = "C:\\Users\\Admin\\Desktop\\Velocity.xlsx"; 
		    FileInputStream file =new FileInputStream(path);
		    Workbook wb =  WorkbookFactory.create(file);
		    Cell cell = wb.getSheet(sheet).getRow(row).getCell(cellValue);
		    
		    try {
		    	String data = cell.getStringCellValue();  
		    	return data;
		    }
		    catch(Exception e) {
		    	double data1 = cell.getNumericCellValue();
		    	int numericValue=(int)data1;
		    	String result = String.valueOf(numericValue);
		    	return result;
		    }		    	
		    }
	}

