package newPack.data;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData {

	public HashMap<Object, Object[]> myFun(String testName) throws IOException {
		// TODO Auto-generated method stub
		
		
		//After finding the required TC , get the entire row and feed the data to the TC
		FileInputStream fis = new FileInputStream("C:\\Users\\Asus\\Downloads\\Budget.xlsx");
		XSSFWorkbook work = new XSSFWorkbook(fis);
		int sheets = work.getNumberOfSheets();
		HashMap<Object,Object[]> map1 = new HashMap<>();
		for(int i=0;i<sheets;i++) 
		{
			if(work.getSheetName(i).equalsIgnoreCase("Test")) 
			{
			XSSFSheet sheet = work.getSheetAt(i);
			//Identify the test case row by scanning all the rows
			Iterator<Row> it=  sheet.iterator();
			Row firstRow = it.next();
			Iterator<Cell> cell = firstRow.cellIterator();
			//Identify the test case column by scanning all the columns in the row
			int k = 0;
			int column=0;
			int row =0;
			
			while(cell.hasNext()) 
			{
				Cell value = cell.next();
				if(value.getStringCellValue().equalsIgnoreCase("TestCases")) 
				{
					column = k;
				}
			    k++;
			}
			
			k=0;
			System.out.println("Column no.: "+column);
			
			//Once column is identified scan the entire column to get the required TC name
			while(it.hasNext()) 	
			{  
				Row r = it.next();
			   if(r.getCell(column).getStringCellValue().equalsIgnoreCase(testName)) 
			   {   row=k;
			       k=0;
				   Iterator<Cell> cv = r.cellIterator();
				   while(cv.hasNext()) 
				   {   Cell x = cv.next();
					   switch(k) 
					   {
					   case 0:
					   map1.put("TestName", new String[] {String.valueOf(x.getStringCellValue())});
					   
					   case 1:
					   map1.put("Email", new String[] {String.valueOf(x.getStringCellValue())});
					   
					   case 2:
					   map1.put("Password", new String[] {String.valueOf(x.getStringCellValue())});
						
					   case 3:
					   map1.put("Products", new String[] {String.valueOf(x.getStringCellValue())});
						   
					   }
					    k++;
				   }
			   }
			  k++;
			  
			}
			System.out.println("Row no is: "+row);
			
			}
			
			
			
			
		}
		work.close();
       return map1;
	}

	
	
}
