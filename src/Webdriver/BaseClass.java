package Webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
	
   public static WebDriver driver = null;
   
   public static void base() {
      if(driver == null) {
	      if(Constants.browser.equals("chrome")) {
	    	  System.setProperty("webdriver.chrome.driver","/Users/pavanivemula/Documents/Drivers/chromedriver");
				driver = new ChromeDriver();
			           }else if(Constants.browser.equals("FF")){
				System.setProperty("webdriver.gecko.driver","/Users/pavanivemula/Documents/Drivers/geckodriver");
				driver = new FirefoxDriver();
	          }
         }
      driver.manage().window().maximize();
	  driver.manage().deleteAllCookies();
	  driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	  driver.get(Constants.url);
   }
   
   public static void quit() {
	   driver.quit();
	   driver = null;
   }
   
   public static void close() {
	   driver.close();
	   driver = null;
   }
   
}
