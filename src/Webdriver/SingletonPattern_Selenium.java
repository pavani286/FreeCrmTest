package Webdriver;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SingletonPattern_Selenium extends BaseClass {
	
	@BeforeMethod
	public void Intialization() {
		BaseClass.base();
	}
	
	@Test
	public void titleofpage() {
		String title = driver.getTitle();
		System.out.println("title of the page ..."+title);
		Assert.assertEquals(title, Constants.loginpgtitle);
	}
	
   @AfterMethod
   public static void teardown() {
	  BaseClass.quit();
  }
  
}
