package Utils;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataUtils {
	@DataProvider(name="search")
	public String[][] getData() throws IOException {
		
		String[][] data=ReadDataFromExcel.getDataFromExcel();
		
		//String[][] data=new String[3][2];
		
//		data[0][0]="Universe";
//		data[0][1]="Multiverse";
//		
//		data[1][0]="Galaxy";
//		data[1][1]="Blackhole";
//		
//		data[2][0]="SolarSystem";
//		data[2][1]="Sun";
//		
		return data;
	}

}
