package Utils;

import java.io.FileWriter;
import java.io.IOException;

import org.testng.annotations.Test;

public class WriteInCSVFile {
	
	String csvFileName="./test-data/TC002.csv.txt";
	
	//@Test
	public void writeFile() throws IOException {
	FileWriter writer=new FileWriter(csvFileName);
	writer.append("FName,LName,Day,Month,Year,Gender,Email,Password \n");
	writer.append("Gayathri,R,19,May,1998,Female,rgayu1998@gmail.com,Rgayu@1998 \n");
	writer.append("Ramya,S,2,JANUARY,2000,Female,ramya2000@gmail.com,Ramya@2000\n");
	writer.append("Shivan,S,30,MARCH,1989,Male,shivan1989@gmail.com,Shivan@1989\n");
	writer.append("Raju,Bai,29,JUNE,2020,Custom,raju2020@gmail.com,Raju@2020\n");
	
	writer.close();
	
	System.out.println("The created CSV file is: "+csvFileName);

	}

}
