package genericLibrary;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Browsers {
		
		public static WebDriver driver;
		public static WebDriver getBrowser() throws Throwable{
			
			if(Constants.Browser.equals("Firefox")){
				driver=new FirefoxDriver();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.get(Constants.url);
		}
			
			else if(Constants.Browser.equals("Chrome")){
				System.setProperty("webdriver.chrome.driver", "./src/main/resources/driver_servers/chromedriver");

				 ChromeOptions ops = new ChromeOptions();			/*To disable the Notifications*/
				 ops.addArguments("--disable-notifications");
				 driver = new ChromeDriver(ops);
				
//				driver.manage().window().maximize();
				driver.get(Constants.url);
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); 
				Thread.sleep(10000);
			}
			
			else if(Constants.Browser.equals("IE")){
				System.setProperty("webdriver.ie.driver", "./src/main/resources/driver_servers/IEdriver.exe");
				driver= new InternetExplorerDriver();
				driver.manage().window().maximize();
				driver.get(Constants.url);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
			 return driver;

	}	
	
	}


