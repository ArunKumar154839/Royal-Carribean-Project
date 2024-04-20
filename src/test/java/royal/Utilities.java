package royal;


import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
 
import org.apache.commons.math3.analysis.function.Exp;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.net.UrlChecker.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
 
public class Utilities {
 
 
	private  WebDriver driver = DriverSetup.getDriver();
	private String baseUrl = DataHandler.getUrl();
	private WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
	private  WebDriverWait wait2 = new WebDriverWait(driver,Duration.ofSeconds(60));
	private  Actions handler = new Actions(driver);
	JavascriptExecutor js = (JavascriptExecutor) driver;
 
	// Configure browser based on input
	public void launchBrowser() {
		driver.get(baseUrl);
		// Maximize window
		driver.manage().window().maximize();
		//implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			takeScreenshot("image1");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Browser Launched");
 
	}
 
	public void searchShips() {
		// Search button
		 String searchName = DataHandler.getSearchData();
		WebElement searchIcon = driver.findElement(By.xpath("//div[@class='header__buttonIcon header__buttonIcon__search']"));
		wait.until(ExpectedConditions.elementToBeClickable(searchIcon)).click();
 
		WebElement searchBtn = driver.findElement(By.id("rciSearchInput"));
		wait.until(ExpectedConditions.elementToBeClickable(searchBtn)).sendKeys(searchName, Keys.ENTER);
		System.out.println("Searched for: "+searchName);
 
 
	}
 
	// Attempts to book a ship
	public void bookAttempt() {
		//moving mouse to near element
		WebElement nearEle = driver.findElement(By.xpath("//a[contains(text(),'Rhapsody of the Seas | Cruise Ships | Royal Caribbean Cruises')]"));
		nearEle.click();
		// book button
		WebElement bookBtn = driver.findElement(By.xpath("//a[contains(text(),'BOOK NOW')]"));
		bookBtn.click();
	}
 
	//Filters based on conditions
	public void selectDates() {
		//manageBanner();
		//Cruise date button
		WebElement CruiseDtBtn = driver.findElement(By.xpath("//button[text()='Cruise dates']"));
		wait.until(ExpectedConditions.elementToBeClickable(CruiseDtBtn)).click();
		manageBanner();
		List<WebElement> buttonList = driver.findElements(By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-outlined MuiButton-outlinedPrimary MuiButton-sizeMedium MuiButton-outlinedSizeMedium MuiButton-disableElevation MuiButton-root MuiButton-outlined MuiButton-outlinedPrimary MuiButton-sizeMedium MuiButton-outlinedSizeMedium MuiButton-disableElevation styles__MonthButton-sc-kwznkh-5 djZkAF month-button css-csbzia']"));
		System.out.println("Selected Dates are: ");
		for (int i = 0; i < 4; i++) {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", buttonList.get(i));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			wait.until(ExpectedConditions.elementToBeClickable(buttonList.get(i))).click();
			System.out.println(buttonList.get(i).getText());
		}
		try {
			takeScreenshot("image2");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clickSearchBtn();
	}
	public void selectDeparturePort() {
		// Departure port 
			WebElement dep_port =  driver.findElement(By.xpath("//button[text()='Departure Port']"));
			wait.until(ExpectedConditions.visibilityOf(dep_port));
			js.executeScript("arguments[0].click();", dep_port);
			//WebElement dep_port =  driver.findElement(By.xpath("//button[text()='Departure Port']"));
			//dep_port.click();
		//wait.until(ExpectedConditions.elementToBeClickable(dep_port)).click();
		WebElement dep_port_choice = driver.findElement(By.xpath("(//div[@class='components__ButtonWrap-sc-1vlkokz-1 bcmVKK']//button)[1]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dep_port_choice);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		handler.moveToElement(dep_port_choice).click().build().perform();
		try {
			takeScreenshot("image3");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Selected Departure Place: "+dep_port_choice.getText());
		clickSearchBtn();
	}
	public void selectDestinationPort() {
		//destination port
		WebElement des_port = driver.findElement(By.xpath("//button[contains(text(),'Destinations')]"));
		wait.until(ExpectedConditions.elementToBeClickable(des_port)).click();
 
		WebElement des_port_choice = driver.findElement(By.xpath("//div[@class='components__ButtonWrap-sc-1vlkokz-1 bcmVKK']//button[1]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", des_port_choice);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		wait.until(ExpectedConditions.elementToBeClickable(des_port_choice)).click();
 
		try {
			takeScreenshot("image4");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Selected Destination Port: "+des_port_choice.getText());
		clickSearchBtn();
	}
 
	public void selectNoOfDays(){
 
		// Days of stay
		WebElement no_of_days = driver.findElement(By.xpath("//button[text()='Number of nights']"));
		wait.until(ExpectedConditions.elementToBeClickable(no_of_days)).click();
 
 
		WebElement no_of_days_choice = driver.findElement(By.xpath("//div[@class='NightsSelector__OverPill-sc-8n7ogz-2 iLYrYR']//button[1]"));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		wait.until(ExpectedConditions.elementToBeClickable(no_of_days_choice)).click();
		try {
			takeScreenshot("image4");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Selected Number of days: "+no_of_days_choice.getText());
		clickSearchBtn();
	}
 
	//Clicks search button
	public void clickSearchBtn() {
		// See results button
		WebElement result = driver.findElement(By.xpath("//button[text()='See results']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", result);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		wait.until(ExpectedConditions.elementToBeClickable(result)).click();
	}
 
	// Sort by order
	public void sortByOrder() {
		//sort Button
		WebElement sortBtn = driver.findElement(By.xpath("//button[contains(@class,'MuiTypography-root MuiTypography-title2')]"));
		sortBtn.click();
		WebElement option = driver.findElement(By.xpath("(//li[contains(@class,'styles__Item-sc-109olgd-6 glUKly')])[2]"));
		wait.until(ExpectedConditions.elementToBeClickable(option)).click();

 
	}
 
	// Takes a string as name and store full-screen screenshot
	public void takeScreenshot( String name) throws IOException{
		File firstsrc = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("./snaps/"+name+".png");
		FileHandler.copy(firstsrc, dest);
	}
	// Takes a string as name and store web-element as screenshot
	public void takeScreenshot(WebElement element, String name) throws IOException{
		File firstsrc = element.getScreenshotAs(OutputType.FILE);
		File dest = new File("./snaps/"+name+".png");
		FileHandler.copy(firstsrc, dest);
	}
 
	public  void manageBanner(){
		// Cancel Button 
		try {
			WebElement cancel = driver.findElement(By.xpath("//div[@class='email-capture__body']/child :: */child::*[2]"));
			cancel.click();
			System.out.println("banner found");
		}catch(Exception e) {
			System.out.println("No Banner found");
			e.printStackTrace();
		}
 
 
	}
	//Display the number of Cruise Search Results
	public void closebrowser() {
		WebElement ele = driver.findElement(By.xpath("//div[@class='styles__TitleRow-sc-mayrxo-0 fABAMH']//span//span"));
		wait.until(ExpectedConditions.visibilityOf(ele));
		String results=ele.getText();
		System.out.println("Number of Cruise Search Results :"+results);
		//Close the browser
		driver.close();
		
	}
}