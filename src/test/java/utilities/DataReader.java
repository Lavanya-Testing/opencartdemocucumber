package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataReader {

	
	public static List<HashMap<String,String>> data(String filepath,String sheetname) throws IOException
	{
		
		List<HashMap<String,String>> myData=new ArrayList<>();
		
		FileInputStream file=new FileInputStream(filepath);
		XSSFWorkbook wb=new XSSFWorkbook(file);
		XSSFSheet sheet=wb.getSheet(sheetname);
		 int totalRows=sheet.getLastRowNum();
		 
		 
		 XSSFRow headerRow=sheet.getRow(0);
		 for(int i=1;i<=totalRows;i++)
		 {
			XSSFRow currentRow=sheet.getRow(i);
			
			 HashMap<String,String> currentHash=new HashMap<String,String>();
			 
			 
			 for(int j=0;j<currentRow.getLastCellNum();j++)
			 {
				 XSSFCell currentCell=currentRow.getCell(j);
				 
				 currentHash.put(headerRow.getCell(j).toString(),currentRow.getCell(j).toString());
			 }
			 myData.add(currentHash);
			 
		 }
		 
		 file.close();
		 
		 
		
		return myData;
		
	}
}
