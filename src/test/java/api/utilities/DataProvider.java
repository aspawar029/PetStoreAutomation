package api.utilities;

import java.io.IOException;

public class DataProvider {

	@org.testng.annotations.DataProvider(name="Data")
	public String[][] getAllData() throws IOException
	{
		String path = System.getProperty("user.dir")+"//testData//Userdata.xlsx";
		XLUtility xl = new XLUtility(path);
		
		int rownum = xl.getRowCount("sheet1");
		int colcount = xl.getCellCount("sheet1", 1);
		
		String apidata[][] = new String[rownum][colcount];
		
		for(int i=1 ; i<=rownum ; i++)
		{
			for(int j =0; j<colcount ; j++)
			{
				apidata[i-1][j] = xl.getCellData("sheet1", i, j);
			}
		}
		return apidata;
	}

	@org.testng.annotations.DataProvider(name="UserNames")
	public String[] getUserName() throws IOException
	{
		String path = System.getProperty("user.dir")+"//testData//userdata.xlsx";
		
		XLUtility xl = new XLUtility(path);
		
		int rownum = xl.getRowCount("sheet1");
		
		String apidata[] = new String[rownum];
		
		for(int i=1 ;i<=rownum ;i++)
		{
			apidata[i-1] =xl.getCellData("sheet1",i,1);
			
		}
		
		return apidata;
	}

	
}
