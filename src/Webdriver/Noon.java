package Webdriver;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class Noon{
	static WebDriver d;
	public static void SectionName(String s) throws InterruptedException{
		try{
		System.out.println(s); 
		JavascriptExecutor js = (JavascriptExecutor) d;
		     switch(s) {
		      case "Recommended for you":
		    	js.executeScript("window.scrollBy(0,800)");
		    	break;
		      case "Trending deals":
		    	((JavascriptExecutor) d).executeScript("javascript:window.scrollBy(0,2600)");
		        d.manage().timeouts().pageLoadTimeout(55,TimeUnit.SECONDS);
				d.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				Thread.sleep(3000);
		        break;
		      case "New in Dresses":
		    	((JavascriptExecutor) d).executeScript("javascript:window.scrollBy(0,4800)");
		        Thread.sleep(4000);
		        d.manage().timeouts().pageLoadTimeout(55,TimeUnit.SECONDS);
				d.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		        break;
		      case "New in Sneakers":
		    	((JavascriptExecutor) d).executeScript("javascript:window.scrollBy(0,5800)");
		        Thread.sleep(4000);
		        //js.executeScript("window.scrollBy(0,800)");
		        d.manage().timeouts().pageLoadTimeout(55,TimeUnit.SECONDS);
				d.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		        break;
	               }
	    WebElement navigbut = d.findElement(By.xpath(
	    	"//div[starts-with(@class,'swiper-button-next custom-navigation swiper-nav-')]"));
	    Actions act = new Actions(d);
	   // ((JavascriptExecutor) d).executeScript("arguments[0].scrollIntoView(true);",navigbut);
	    Thread.sleep(9000);
	    act.moveToElement(navigbut).build().perform();
	   
	    List<WebElement> CarouselItems = d.findElements(By.xpath(
			      "//a[starts-with(@id,'productBox-N')]/div/div[2]/div[1]/span"));
		System.out.println("Total Links --->"+CarouselItems.size());
		
		int j=0;
		  while(j<CarouselItems.size()){
		     if(j==7 || j==14 || j==21 || j==28 || j==35 || j==42) {
		        js.executeScript("arguments[0].click()",navigbut);
			    //navigbut.click();
			    Thread.sleep(4000);
				d.manage().timeouts().pageLoadTimeout(70,TimeUnit.SECONDS);
				d.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
				              }
		      System.out.println(j +"."+ CarouselItems.get(j).getText());
		      j++;
				    }
		   }catch(Exception e){
			System.out.println("Exception Error !!!!!"+e); }
	  }
	public static void main(String[] args) throws InterruptedException{
        //System.setProperty("webdriver.chrome.driver","/Users/pavanivemula/Documents/Drivers/chromedriver");
	    System.setProperty("webdriver.gecko.driver" ,"/Users/pavanivemula/Documents/Drivers/geckodriver");
	    d=new FirefoxDriver();
		d.get("https://www.noon.com/uae-en/");  
		d.manage().window().maximize();
		Thread.sleep(2000);
		d.manage().timeouts().pageLoadTimeout(45,TimeUnit.SECONDS);
		d.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
     	SectionName("Trending deals");
	                          }
	    

}
