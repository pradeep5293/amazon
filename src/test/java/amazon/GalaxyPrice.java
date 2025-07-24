package amazon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class GalaxyPrice extends AmazonBase {

	 @org.testng.annotations.Test
	    public void GalaxySearch() throws InterruptedException {
	        setUp();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 

	        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("samsung galaxy s25 ultra 5g");
	        driver.findElement(By.id("nav-search-submit-button")).click();
	        Thread.sleep(2000);

	        WebElement cell = driver.findElement(By.xpath("//span[contains(text(), 'Samsung Galaxy S25 Ultra') and contains(text(), 'Titanium Black')]"));
	        
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", cell);
	        
	        String price = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[3]")).getText();
	        System.out.println("Galaxy Price: " + price);
	        
	        Thread.sleep(3000);
	        WebElement ATC = driver.findElement(By.xpath("//button[@id='a-autoid-3-announce']"));
	        ATC.click();
	    }
}
