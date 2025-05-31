package Utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.testng.annotations.Test;

public class ReadFromcsvFile {
	
	String filePathName="./test-data/TC002.csv.txt";
	
	@Test
	public void readFromcsv() throws IOException {
		
	//Approach 1: using Scanner class
	/*File file=new File(filePathName);
	Scanner sc=new Scanner(file);
	sc.useDelimiter(",");
	
	while(sc.hasNext()) {
		String text=sc.next();
		System.out.print(text + "\t");
	}
	sc.close();*/
	
	//Approach 2: Using java split() method
	
	String filePathName="./test-data/TC002.csv.txt";
	FileReader reader= new FileReader(filePathName);
	BufferedReader bffreader=new BufferedReader(reader);
	String line;
	while((line=bffreader.readLine())!=null) {
		String data[]=line.split(",");
		for(String value:data) {
			System.out.print(value + "\t");
		}
		
	}
	
			
	}

}
