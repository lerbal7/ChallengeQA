package challengeQA;

import org.junit.Assert;
import java.time.Duration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.JavascriptExecutor;

public class testEditItem {
	
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
	public void testEdit() throws InterruptedException {
		String descriptionText = "I have edited the description of this item";
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@ng-model='items']"))); // Wait for the list of items to be visible 
		
		WebElement item = driver.findElement(By.xpath("//ul/li[4]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", item); // Focus on the element
		
		Thread.sleep(2000); // Just some waiting for seeing how it focuses and then goes back to the top to edit the description
		
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div/ul/li[5]/div/div/div[1]/button[1]")).click(); // Click on the Edit button
		
		WebElement descriptionElement = driver.findElement(By.tagName("textarea"));
		descriptionElement.clear(); 
		descriptionElement.sendKeys(descriptionText); // Change the description of the item 
		
		driver.findElement(By.xpath("//button[text()='Update Item']")).click();
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", item);
		
		// Make sure that the new description has been added to the chosen item
		Assert.assertTrue(driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/ul/li[5]/div/div/div[2]/p")).getText().contains(descriptionText));
	}
	
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

}
