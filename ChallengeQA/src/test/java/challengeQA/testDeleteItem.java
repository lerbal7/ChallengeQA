package challengeQA;

import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class testDeleteItem {

	private WebDriver driver;
	private String baseUrl = "http://immense-hollows-74271.herokuapp.com/";

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		Dimension dimension = new Dimension(384, 854);
		
		// Comment these two lines alternatively to see the test run for mobile / desktop dimensions
		//driver.manage().window().maximize(); 
		driver.manage().window().setSize(dimension);
		driver.get(baseUrl);
	}
	
	@Test
	public void testDelete() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@ng-model='items']"))); // Wait for the list of items to be visible
		
		WebElement desc = driver.findElement(By.xpath("//*[contains(text(), 'This is an image')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", desc);
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/ul/li[last()]/div/div/div[1]/button[2]")).click(); // Click on Delete button of the last element
		driver.findElement(By.xpath("//button[text()='Yes, delete it!']")).click(); // Confirm that I want to delete the element
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
}
