/**
 * 
 */
package challengeQA;

import java.io.File;
import java.time.Duration;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Dimension;

public class testCreateItem {
	
	private WebDriver driver;
	private String baseUrl = "http://immense-hollows-74271.herokuapp.com/";
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		Dimension dimension = new Dimension(384, 854);
		
		// Comment these two lines alternatively to see the test run for mobile / desktop dimensions
		driver.manage().window().maximize(); 
		//driver.manage().window().setSize(dimension);
		
		driver.get(baseUrl);
	}

	@Test
	public void testCreate() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("textarea"))); // Wait for the textarea to be visible 
		
		File file = new File("./src/test/resources/Images/TestImage.jpg"); // Create a File object 
		
		driver.findElement(By.id("inputImage")).sendKeys(file.getAbsolutePath()); // Upload the image by using the File object
		driver.findElement(By.tagName("textarea")).sendKeys("This is an image"); // Type in some description
		driver.findElement(By.xpath("//button[text()='Create Item']")).click(); // Click on the Create Item button
		
		Thread.sleep(2000);
		
		Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(), 'This is an image')]")).isDisplayed());
		
	}
 
	@After
	public void tearDown() throws Exception {
		driver.quit(); 
	}

}
