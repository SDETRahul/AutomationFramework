package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;


public class ReadExcel {
	 XSSFWorkbook workbook;
	 FileInputStream fs;
	 Sheet sheet;
	 
	
	 public Sheet returnSheet() throws IOException
	 {	
		 	String filepath="/Users/rahulsingh/Documents/Eclipse_Rahul_Neon/SDET/Auto/src/main/java/Data/Data.xlsx";
			File file = new File(filepath);
			fs = new FileInputStream(file);
	        workbook = new XSSFWorkbook(fs);
	        sheet=workbook.getSheetAt(1);
	        return sheet;		 
	 }
	 
	public void readExcel() throws IOException {
		
		String filepath="/Users/rahulsingh/Documents/Eclipse_Rahul_Neon/SDET/Auto/src/main/java/Data/Data.xlsx";
		File file = new File(filepath);
		fs = new FileInputStream(file);
        workbook = new XSSFWorkbook(fs);
        sheet=workbook.getSheetAt(1);
        System.out.println("Data at [0,0]-->"+sheet.getRow(0).getCell(0).getStringCellValue());
        Iterator<Row> ir = sheet.iterator();
        while (ir.hasNext()) {
        
        	 Row currentrow = ir.next();
        	 Iterator<Cell> cellir = currentrow.iterator();
        	 
        	 while(cellir.hasNext())
        	 {
        		 Cell cell=cellir.next();
        		 System.out.print(cell.getStringCellValue()+" | ");
        	 }
        	 System.out.println();
        }
       
	}
	
	  public int findRow(XSSFSheet sheet, String cellContent){
	        /*
	         *  This is the method to find the row number
	         */

	        int rowNum = 0; 

	        for(Row row : sheet) {
	            for(Cell cell : row) {

	                while(cell.getCellType() == Cell.CELL_TYPE_STRING){

	                    if(cell.getRichStringCellValue().getString () == cellContent);{

	                            rowNum = row.getRowNum();
	                            return rowNum;  
	                    }
	                }
	            }
	        }               
	        return rowNum;
	    }
	
}
