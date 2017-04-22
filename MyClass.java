package seleniumprograms;

import org.openqa.selenium.By; 

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement; 
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.chrome.ChromeDriver; 
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import org.openqa.selenium.firefox.*;
import java.util.concurrent.*;
 
public class MyClass {
     
	public static void main(String[] args) {
	      String baseUrl = "https://disneyworld.disney.go.com/tickets/";
	      System.setProperty("webdriver.firefox.marionette","C:\\geckodriver.exe");
	      WebDriver driver = new FirefoxDriver();
 
          
	      driver.get(baseUrl);
	      //click on the number of days 
	      driver.findElement(By.xpath(".//*[@id='pepDayScroller_numDays']/div[1]/a")).click();

         //wait 5 secs 
         driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
         
       //click on the date 
          
         driver.findElement(By.xpath(".//*[@id='1-day-ThemePark-calendar']/div[2]/table/tbody/tr[5]/td[4]/a")).click();

         //wait 5 secs 
         driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
         
       //click on the + sign to add number tickets 
         
         driver.findElement(By.xpath(".//*[@id='numberOfTicketsModule']/div/div[2]/div[1]/div/button[2]")).click();

         //wait 5 secs 
         driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
         
       //click on the select your theme park ticket 
         
         driver.findElement(By.xpath(".//*[@id='selectThemeParkTicketModule']/div/div[2]/button[1]")).click();

         //wait 5 secs 
         driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
          
         //click on add to cart  
         
         driver.findElement(By.xpath(".//*[@id='addToCart']")).click();

         //wait 5 secs 
         driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
         
          
       //verify that we are now on your cart page
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