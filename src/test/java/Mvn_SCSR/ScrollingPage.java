package Mvn_SCSR;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScrollingPage 
{
	WebDriver driver;
	
	@BeforeTest
	public void LaunchBrowser() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(co);
		driver.manage().window().maximize();
		
		driver.get("https://www.selenium.dev/downloads/");
		Thread.sleep(2000);
	}
	
  @Test
  public void ScrollPage() throws InterruptedException 
  {
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  
	  WebElement ch = driver.findElement(By.linkText("Chrome"));
	  
	  //scroll to the chrome link
	  js.executeScript("arguments[0].scrollIntoView", ch);
	  
	  Thread.sleep(2000);
	  
	  System.out.println(ch.getText());
	  
	// Scroll to the bottom of the page
	  js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	  
	  Thread.sleep(2000);
	  
	// Scroll back to the top of the page
	  js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
	  
	  Thread.sleep(2000);
  }
}
