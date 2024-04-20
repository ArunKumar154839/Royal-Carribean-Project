package royal;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
// Handles data from Excel
public class DataHandler {
 
	private static XSSFWorkbook wbook  ;
 
	//set excel workbook based on location given
	public static void setWorkBook(String fileName)throws IOException {
		wbook = new XSSFWorkbook(fileName);
 
	}
 
	//returns URL
	public static String getUrl() {
		XSSFCell  url = wbook.getSheetAt(0).getRow(1).getCell(1);
		return url.toString();
	}
	//returns BrowserName
	public static String getBrowserName() {
		XSSFCell  url = wbook.getSheetAt(0).getRow(1).getCell(0);
		return url.toString();
	}
	//returns Search-data
	public static  String getSearchData() {
		XSSFCell  url = wbook.getSheetAt(0).getRow(1).getCell(2);
		return url.toString();
	}
 
}

