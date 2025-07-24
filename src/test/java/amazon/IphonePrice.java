package amazon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class IphonePrice extends AmazonBase {

	 @org.testng.annotations.Test
	    public void IphoneSearch() throws InterruptedException {
	        setUp();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
	        
	        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone 15 128+gb");
	        driver.findElement(By.id("nav-search-submit-button")).click();
	        Thread.sleep(2000);

	        WebElement cell = driver.findElement(By.xpath("//*[contains(text(),'Apple iPhone 15 (128 GB) - Black')]"));
	        
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", cell);
	        
	        String price = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[3]")).getText();
	        System.out.println("iPHONE Price: " + price);
	        
	        Thread.sleep(3000);
	        WebElement ATC = driver.findElement(By.xpath("//button[@id='a-autoid-2-announce']"));
	        ATC.click();
	        
	        tearDown();
	    }
}
