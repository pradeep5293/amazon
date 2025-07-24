package amazon;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import java.util.List;

public class AddToCart{

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
	        driver.get("https://www.amazon.in");
	        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone 15 128+gb");
	        driver.findElement(By.id("nav-search-submit-button")).click();
	        Thread.sleep(2000);

	        WebElement cell = driver.findElement(By.xpath("//*[contains(text(),'Apple iPhone 15 (128 GB) - Black')]"));
	        
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", cell);
	        
	        String price = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[3]")).getText();
	        System.out.println("Galaxy Price: " + price);
	        
	        Thread.sleep(3000);
	        WebElement ATC = driver.findElement(By.xpath("(//button[@name='submit.addToCart'])[3]"));
	        ATC.click();
//	        Actions actions = new Actions(driver);
//	        actions.moveToElement(ATC).perform();

//        driver.quit();
        }
}