package Webdriver;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import DataUtil.properties;

public class Test extends properties {
     static WebDriver d;
     static Date d1,d2;
	 static List<WebElement> DepFilghtCount,ArrFilghtCount;
	 
	public static void main(String[] args) throws InterruptedException, ParseException {
		System.setProperty("webdriver.chrome.driver","/Users/pavanivemula/Documents/Drivers/chromedriver");
		d= new ChromeDriver();
	    d.manage().window().maximize();
	    d.get("https://www.makemytrip.com/");
	    d.manage().deleteAllCookies();
	    d.manage().timeouts().pageLoadTimeout(45,TimeUnit.SECONDS);
	    d.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
        d.findElement(By.xpath("//li[@data-cy='account']")).click();
        Thread.sleep(2000);
	    d.findElement(By.xpath("//ul[@class='fswTabs latoBlack greyText']/li[2]")).click();
		d.findElement(By.xpath("//div[@class='fsw_inputBox searchCity inactiveWidget ']")).click();
		d.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("DEL");
		Thread.sleep(2000);
		d.findElement(By.xpath("//div[text()='DEL']")).click();
		    	
		d.findElement(By.cssSelector("div.fsw_inputBox.searchToCity.inactiveWidget ")).click(); 
	    d.findElement(By.xpath("//input[@placeholder='To']")).sendKeys("Bengaluru");
		Thread.sleep(2000);
		d.findElement(By.xpath("//div[text()='BLR']")).click(); 
		    	
		init_prop();
		SimpleDateFormat FormatDate = new SimpleDateFormat("MMM dd");
		String DepartureDt =prop.getProperty("DepartureDate");
		String ReturnDt =prop.getProperty("ReturnDate");
		d1 = FormatDate.parse(DepartureDt);
	    d2 = FormatDate.parse(ReturnDt);
		System.out.println("The departure date is ... " + FormatDate.format(d1));
		System.out.println("The Return date is ... " + FormatDate.format(d2));
		        
		if(Differences(d1,d2)>=7) {
		d.findElement(By.xpath("//div[contains(@aria-label,'"+DepartureDt+"')]")).click();
		d.findElement(By.xpath("//div[contains(@aria-label,'"+ReturnDt+"')]")).click();
		ScrollBar();
		    	        }else {
	    System.out.println("This Method is restericated to accept 7 days difference between"
		   + " departure and Arrival date. Please check Given Date again. "
		   + "!!Contact Git Admin for more info");

		    	                     }
	              }
   public static void ScrollBar() throws InterruptedException {
		d.findElement(By.cssSelector("a.primaryBtn.font24.latoBold.widgetSearchBtn")).click();
        d.manage().deleteAllCookies();
        Thread.sleep(6000);
	  /*  ScrollDown();
	    DepFilghtCount = d.findElements(By.xpath("//div[@class='splitVw']/child::div[1]/child::div[2]/div/div/label"));
		System.out.println("No.of Departure Flights avialable ..."+DepFilghtCount.size());
		            
	    ArrFilghtCount = d.findElements(By.xpath("//div[@class='splitVw']/child::div[2]/child::div[2]/div/div/label"));
 	    System.out.println("No.of Return Flights avialable ..."+ArrFilghtCount.size());
 	    
 	    List<WebElement> Radiobutton_Left = d.findElements(By.xpath(""
		        + "//div[@class='splitVw']/child::div[1]/child::div[2]"
		        + "/div/div/label/descendant::span[@class='customRadioBtn']"));

		ScrollUp();
		
		Radiobutton_Left.get(10).click();
		Thread.sleep(2000);
		*/
        JavascriptExecutor js1 = (JavascriptExecutor) d;
       WebElement l= d.findElement(By.xpath("//p[contains(text(),'Popular Filters')]/parent::div/child::div//span[text()='Go First']"));
       js1.executeScript("arguments[0].scrollIntoView(true);", l);
       l.click();
   }
   public static int Differences(Date one, Date two) {
		
		int difference = (int) (two.getTime() - one.getTime());
	    int daysBetween = (int) (difference / (1000*60*60*24));
	    System.out.println("Number of Days between dates: "+daysBetween);
		return daysBetween;
		
	                }
	public static void ScrollDown() throws InterruptedException {
   	Actions act = new Actions(d);
   	WebElement ScrollBar = d.findElement(By.xpath("//html[@lang='en']"));
		for (int i = 0; i <= 30; i++){
             act.moveToElement(ScrollBar).sendKeys(Keys.PAGE_DOWN).build().perform(); //Page Down
             Thread.sleep(1000);  
		              }
       
       
	                                               }
	public static void ScrollUp() throws InterruptedException {
   	Actions act = new Actions(d);
   	WebElement ScrollBar = d.findElement(By.xpath("//html[@lang='en']"));
		for (int i = 0; i <= 22; i++){
             act.moveToElement(ScrollBar).sendKeys(Keys.PAGE_UP).build().perform(); //Page Up
             Thread.sleep(1000);  
   	               }
	                                         }


}











/*
  d.findElement(By.xpath("//div[@class='fsw_inputBox dates inactiveWidget ']")).click();
			String datetobeselected = Data.map().get(7);
			String day = Data.map1().get(15);
			String flag="false";
			 while(flag == "false") {
			    if(d.findElements(By.xpath("//div[contains(@aria-label,'"+datetobeselected+" "+day+"') and @class='DayPicker-Day']")).size()>0) {
			     d.findElement(By.xpath("//div[contains(@aria-label,'"+datetobeselected+" "+day+"') and @class='DayPicker-Day']")).click();
			     flag="true";
			          }
			       else {
			    	 d.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
			       }
			 }	
			 
	}
 
*/