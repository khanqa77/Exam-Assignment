package seleniumprograms;

import java.util.concurrent.TimeUnit;
 
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

 
public class Disney_tickets {
 
	public static WebDriver driver;
	public static String driverPath = "C:\\Jar and Browsers\\chromedriver_win32\\";
	private static final String sPricelist = ".//*[@id='radioRateCarouselid-base']/div/div/div/span";
	private static final String sNoofdays = ".//*[@id='pepDayScroller_numDays']/div[1]/a/div[2]";
	private static final String sDate = ".//*[@id='1-day-ThemePark-calendar']/div[2]/table/tbody/tr[4]/td[1]/a";
	private static final String sValue = ".//*[@id='1-day-ThemePark-calendar']/div[4]/div[1]/div[1]";
	private static final String sNooftickets = ".//*[@id='numberOfTicketsModule']/div/div[2]/div[1]/div/button[2]";
	private static final String sThemepark = ".//*[@id='selectThemeParkTicketModule']/div/div[2]/button[1]";
	private static final String sAddtocart = "addToCart";
	
	public static void initWebDriver(String URL) throws InterruptedException {
 
		// Setting up Chrome driver path.
		System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
		// Launching Chrome browser.
		driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
	}
 
	public static void main(String[] args) throws InterruptedException {
 
		initWebDriver("https://disneyworld.disney.go.com/tickets/");

 
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(sPricelist))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(sNoofdays))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(sDate))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(sValue))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(sNooftickets))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(sThemepark))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id(sAddtocart))).click();
 
		 String expectedTitle = "Shopping Cart | Walt Disney World Resort";
         String actualTitle = driver.getTitle();
         Assert.assertEquals(actualTitle, expectedTitle);
         System.out.println("Add to Cart functionality is working");
         
         String expectedprice = "$122.48 USD";
         String actualprice = driver.findElement(By.xpath(".//*[@id='cartTotal']/div[1]/div[1]/div[2]/div")).getText();
         Assert.assertEquals(actualprice, expectedprice);
         System.out.println("Add to Cart functionality is working");
         
         
         
         String i = driver.getCurrentUrl();
         System.out.println(i);
         String j = driver.getTitle();
         System.out.println("Your page title Is : "+j);
         if (driver.getCurrentUrl().contains("cart")) {
             System.out.println("add to cart functionality is working");
         } else {
             System.out.println("add to cart functionality is not working");
         }
         driver.close();
}
}