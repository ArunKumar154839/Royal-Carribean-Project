package royal;

import java.io.IOException;

public class Main {

 
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String location = "./data/testData.xlsx";
 
		try {
			DataHandler.setWorkBook(location);
 
		}catch(IOException e) {
			System.out.println("File not found");
		}
		String search = DataHandler.getSearchData();
		Utilities utils = new Utilities();	
		utils.launchBrowser();
		utils.searchShips();
		utils.bookAttempt();
		Thread.sleep(30000);
		utils.manageBanner();
		utils.selectDates();
		utils.selectDeparturePort();
		utils.selectDestinationPort();
		utils.selectNoOfDays();
		utils.sortByOrder();
		utils.closebrowser();
		System.out.println("Script Completed");
 
	}
 
}