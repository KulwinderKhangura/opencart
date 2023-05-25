package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	
	
	
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException{
		
		String path = ".\\testData\\Opencart_LoginData.xlsx"; //this is path that get xl file from testdata
		ExcelUtility xlutil = new ExcelUtility(path);
		int totalrows = xlutil.getRowCount("Sheet1");
		
		int totalcols = xlutil.getCellCount("Sheet1", 1);
		
		String logindata[][] = new String[totalrows][totalcols];
		
		for(int r =1; r<=totalrows;r++) {
			
			for(int c=0; c<totalcols; c++) {
				
			logindata[r-1][c]=	xlutil.getCellData("Sheet1", r, c);
			}
		}
		
		return logindata; //returing data in two dimensional array
		
	}
	
}
