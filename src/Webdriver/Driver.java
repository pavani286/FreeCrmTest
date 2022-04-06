package Webdriver;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Driver{
    static WebDriver d;
	public static void main(String[] args) throws InterruptedException, ParseException{
		//select("20/08/2021"); 
		System.setProperty("webdriver.chrome.driver" ,"/Users/pavanivemula/Documents/Drivers/chromedriver");
		  d=new ChromeDriver();
		  d.manage().window().maximize();
		  d.get("https://www.travelocity.com/");
		  d.manage().timeouts().pageLoadTimeout(45,TimeUnit.SECONDS);
	      d.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		  d.findElement(By.xpath("//ul[@id='uitk-tabs-button-container']/li[2]/a")).click();
		  d.findElement(By.cssSelector("#d1-btn")).click();
		  JavascriptExecutor js = (JavascriptExecutor) d;
		  js.executeScript("window.scrollBy(0,200)");
		  String Date_Heading1="//div[@class='uitk-date-picker-menu-months-container']/div[1]/h2";
		  String Date_Heading2="//div[@class='uitk-date-picker-menu-months-container']/div[2]/h2";
		  String Date_Xpath1="//div[@class='uitk-date-picker-menu-months-container']/div[1]/table/tbody/tr/td/button";
		  String Date_Xpath2= "//div[@class='uitk-date-picker-menu-months-container']/div[2]/table/tbody/tr/td/button";
		  String Monthyeartobeselected = "February 2022";
		  int i1;
		  while(!d.findElement(By.xpath(Date_Heading1)).getText().contains(Monthyeartobeselected) 
			 && !d.findElement(By.xpath(Date_Heading2)).getText().contains(Monthyeartobeselected)){
		      
			  d.findElement(By.xpath("//div[@class='uitk-calendar']/div[1]/button[2]")).click();
		  }
		String Date_Heading = d.findElement(By.xpath("//div[@class='uitk-date-picker-menu-months-container']/div[2]/h2")).getText();
		System.out.println("Date_Heading ..."+Date_Heading);
		  if(Monthyeartobeselected.equals(Date_Heading)){
		       List<WebElement> dates= d.findElements(By.xpath(Date_Xpath2));  
		     //Grab common attribute//Put into list and iterate
		    for(i1=2;i1<dates.size();i1++){
		        if(i1==14){
		           d.findElements(By.xpath(Date_Xpath2)).get(i1).click();
		           Thread.sleep(2000);
		           d.findElement(By.xpath(
		        	 "//div[@class='uitk-flex uitk-date-picker-menu-footer']/button")).click();
		    break;
		           }
		        		     }
	                                   }
		  d.close();
		     
}
		 
		  
	 /*  System.setProperty("webdriver.chrome.driver" ,"/Users/pavanivemula/Documents/Drivers/chromedriver");
	   d=new ChromeDriver();
	   d.manage().window().maximize();
	   d.get("https://www.worldometers.info/world-population/");
	   d.manage().timeouts().pageLoadTimeout(45,TimeUnit.SECONDS);
	   d.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	   JavascriptExecutor js = (JavascriptExecutor) d;
	   js.executeScript("window.scrollBy(0,200)");
	   Thread.sleep(2000);
	   int count=0;
	   while(count<=20) {
		   System.out.println(+count+"sec");
		   System.out.println("******World Population*******");
	       System.out.println(d.findElement(By.xpath("//div[@id='maincounter-wrap']/div")).getText());
	       System.out.println("******Today's and This Year Population Count *******");
	       List<WebElement> poplist=d.findElements(By.xpath(
	    		   "//div[@class='sec-counter']/span[@class='rts-counter']"));
	       for(int i=0;i<poplist.size();i++) {
		       System.out.println(poplist.get(i).getText());
		                     }
	   count++;
	          }
  
	*/
		/*String [] a = {"Recommended for you","Trending deals","Top picks in laptops","Top picks in mobiles","Blablablabla.."};
		
		Arrays.sort(a);
		System.out.println("***********After sorting*********");
		for(int i = 0;i<a.length;i++)
		{
		  System.out.println(a[i]);
		}
		 */
		  
	}

	
			 
	

		
		
		
		


















		/*	d.get("https://www.amazon.com/books-used-books-textbooks/b/?ie=UTF8&node=283155&ref_=nav_cs_books_2ed85a0fb54a4598ba909c22690d166e");
	
		String s = d.findElement(By.xpath("//div[@class='left_nav browseBox']//descendant::li[8]")).getText();
		
		System.out.println("text is..."+s);
		
		*/
	/*	
		
		d.get("http://demo.guru99.com/test/guru99home/");
		String s = d.findElement(By.xpath("//div[@id='rt-feature']//child::div[1][@class='rt-grid-12 rt-alpha rt-omega']")).getText();
		
		System.out.println("text is..."+s);
		*/
		
	/*	d.get("https://twitter.com/login?lang=en");
		d.findElement(By.xpath("//input[@name ='session[username_or_email]']")).sendKeys("cc@gmail.com");
		d.findElement(By.xpath("//input[@name ='session[password]']")).sendKeys("cc");
		d.findElement(By.xpath("//div[@class='css-1dbjc4n']//child::div[3]/div/div/span/span")).click();
	    //String errmess = d.findElement(By.xpath("//*[@class='css-1dbjc4n r-1ydw1k6']/div/span")).getText();
		String errmess = d.findElement(By.xpath("//*[@class='css-1dbjc4n r-tvv088']//preceding::div[1]/span")).getText();
		System.out.println("Error Message ..." +errmess);
		*/
		
		//d.quit();
	