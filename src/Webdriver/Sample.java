package Webdriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;


public class Sample {
	  static WebDriver d;
	  static Date d1,d2;
	  static List<WebElement> DepFilghtCount,ArrFilghtCount;
	  public static Properties prop;
	public static Properties init_prop() {

			prop = new Properties();
			try {
				FileInputStream ip = new FileInputStream("/Users/pavanivemula/Documents/Workspace/Selenium_Bascis/Config");
				prop.load(ip);

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			return prop;

		                   }
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
	    	//Non_Stop();
	    	//One_Stop();
	    	FarePriceCheck(0, 2);
	    	
	    	                     }else {
	  System.out.println("This Method is restericated to accept 7 days difference between"
	   + " departure and Arrival date. Please check Given Date again. "
	   + "!!Contact Git Admin for more info");

	    	                     }
	    	
	                       }
	public static Object[][] Data() {
		
		Object[][] data ={{0,2},{7,5},{1,3},{4,2},{5,3},{6,4}};
		return data;
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

	public static void ScrollBar() throws InterruptedException {
		d.findElement(By.cssSelector("a.primaryBtn.font24.latoBold.widgetSearchBtn")).click();
    	d.manage().deleteAllCookies();
    	Thread.sleep(6000);
    	
    	ScrollDown();
	    DepFilghtCount = d.findElements(By.xpath("//div[@class='splitVw']/child::div[1]/child::div[2]/div/div/label"));
        System.out.println("No.of Departure Flights avialable ..."+DepFilghtCount.size());
        
	    ArrFilghtCount = d.findElements(By.xpath("//div[@class='splitVw']/child::div[2]/child::div[2]/div/div/label"));
        System.out.println("No.of Return Flights avialable ..."+ArrFilghtCount.size());
           
	                             }
	public static void One_Stop() throws InterruptedException{
		//1-stop
		ScrollUp();
        System.out.println("********  One-Stop option is selected  *********");
        d.findElement(By.xpath("//p[contains(text(),'New Delhi')]/parent::div/child::div//span[text()='1 Stop']")).click();
        Thread.sleep(2000);
        d.findElement(By.xpath("//p[contains(text(),'Bengaluru')]/parent::div/child::div//span[text()='1 Stop']")).click();
        ScrollDown();
        DepFilghtCount = d.findElements(By.xpath("//div[@class='splitVw']/child::div[1]/child::div[2]/div/div/label"));
        System.out.println("No.of Departure Flights avialable ....."+ DepFilghtCount.size());
        
	    ArrFilghtCount  = d.findElements(By.xpath("//div[@class='splitVw']/child::div[2]/child::div[2]/div/div/label"));
        System.out.println("No.of Return Flights avialable ....."+ ArrFilghtCount.size());
        
	                }
	public static void Non_Stop() throws InterruptedException {
		System.out.println("********** Non-Stop option is selected **********");
        //non-stop
		ScrollUp();
        d.findElement(By.xpath("//p[contains(text(),'New Delhi')]/parent::div/child::div//span[text()='Non Stop']")).click();
        Thread.sleep(2000);
        d.findElement(By.xpath("//p[contains(text(),'Bengaluru')]/parent::div/child::div//span[text()='Non Stop']")).click();
        
        ScrollDown();
        DepFilghtCount = d.findElements(By.xpath("//div[@class='splitVw']/child::div[1]/child::div[2]/div/div/label"));
        System.out.println("No.of Departure Flights avialable ....."+ DepFilghtCount.size());
        
	    ArrFilghtCount  = d.findElements(By.xpath("//div[@class='splitVw']/child::div[2]/child::div[2]/div/div/label"));
        System.out.println("No.of Return Flights avialable ....."+ ArrFilghtCount.size());
      
	          }
	
	public static void FarePriceCheck(int DepartIndex, int ArrivalIdx) throws InterruptedException {
		
		List<WebElement> Radiobutton_Left = d.findElements(By.xpath(""
		        + "//div[@class='splitVw']/child::div[1]/child::div[2]"
		        + "/div/div/label/descendant::span[@class='customRadioBtn']"));

		ScrollUp();
		
		Radiobutton_Left.get(0).click();
		Thread.sleep(2000);
		        
        List<WebElement> Price_Left = d.findElements(By.xpath(""
        		+ "//div[@class='splitVw']/child::div[1]/child::div[2]/div/div"
        		+ "/label/descendant::div[@class='makeFlex column relative']/p"));
        String Departure_Fare = d.findElement(By.xpath("//div[@class='splitviewSticky makeFlex']//child::div[1]"
        		                                 + "/p[contains(text(),'Departure')]"
        		                                 + " //parent::div//following-sibling::div/span")).getText();
        if(Price_Left.get(0).getText().equalsIgnoreCase(Departure_Fare)) {
        	System.out.println("Prices of Departureflight's are Equal ....");
                      }
       
        List<WebElement> Radiobutton_Right = d.findElements(By.xpath(""
                + "//div[@class='splitVw']/child::div[2]/child::div[2]"
                + "/div/div/label/descendant::span[@class='customRadioBtn']"));
               
        Radiobutton_Right.get(2).click();
	    Thread.sleep(2000);
	    List<WebElement> Price_Right = d.findElements(By.xpath("//div[@class='splitVw']/child::div[2]/child::div[2]/div/div/"
	    		+ "label/descendant::div[@class='makeFlex column relative']/p"));
	    String Return_Fare = d.findElement(By.xpath("//div[@class='splitviewSticky makeFlex']//child::div[2]"
	    		+ "/p[contains(text(),'Return')]//parent::div//following-sibling::div/span")).getText();
	    if(Price_Right.get(2).getText().equalsIgnoreCase(Return_Fare)) {
        	System.out.println("Prices of Returnflight's are Equal ....");
                      }
	}
	
	
}
