package royal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
 
// Configure driver based on data in data-provider
public class DriverSetup {
 
	//returns driver
	
	public static WebDriver getDriver() {
 
		String browserName = DataHandler.getBrowserName();
		WebDriver driver = null ;
		if (browserName.equalsIgnoreCase("chrome")){
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if (browserName.equalsIgnoreCase("edge")){
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
 
		return driver;
 
	}
}
