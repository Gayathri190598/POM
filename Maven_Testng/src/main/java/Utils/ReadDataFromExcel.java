package Utils;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromExcel {
	
	public static String[][] getDataFromExcel() throws IOException {
		
		String fileLocation = "./test-data/TC001.xlsx";
		XSSFWorkbook workBook= new XSSFWorkbook(fileLocation);
		XSSFSheet sheet=workBook.getSheetAt(0);
		
		//to get last row number in a sheet excluding the header row
		int lastRowNumber=sheet.getLastRowNum();
		System.out.println("The last row number is: "+lastRowNumber);
		
		//to get last cell number of a row(column number) in a sheet
		short lastCellNumber=sheet.getRow(0).getLastCellNum();
		System.out.println("The no.of cells in a row is: "+lastCellNumber);
		
		//to get last row number in a sheet including the header row
		int physicalNumberOfRows=sheet.getPhysicalNumberOfRows();
		System.out.println("The last row number including header is: "+physicalNumberOfRows);
		
		String[][] data=new String[lastRowNumber][lastCellNumber];
		
		for (int i = 1; i <=lastRowNumber; i++) {
			XSSFRow row = sheet.getRow(i);
			for (int j = 0; j < lastCellNumber; j++) {
				XSSFCell cell = row.getCell(j);
				DataFormatter dft=new DataFormatter();
				String cellValue=dft.formatCellValue(cell);
				//String cellValue = cell.getStringCellValue();	
				//System.out.println(cellValue);
				data[i-1][j]=cellValue;
			}
		}
		workBook.close();
		return data;
	}

}
