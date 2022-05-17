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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class testCreateItem extends base {
	
	@Before
	public void setUp() throws Exception {
		super.setUp();
	}

	@Test
	public void testCreate() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(super.getDriver(), Duration.ofSeconds(2));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("textarea"))); // Wait for the textarea to be visible 
		
		File file = new File("./src/test/resources/Images/TestImage.jpg"); // Create a File object 
		
		super.getDriver().findElement(By.id("inputImage")).sendKeys(file.getAbsolutePath()); // Upload the image by using the File object
		super.getDriver().findElement(By.tagName("textarea")).sendKeys("This is an image"); // Type in some description
		super.getDriver().findElement(By.xpath("//button[text()='Create Item']")).click(); // Click on the Create Item button
		
		Thread.sleep(2000);
		
		Assert.assertTrue(super.getDriver().findElement(By.xpath("//*[contains(text(), 'This is an image')]")).isDisplayed());
	}
	
	@After
	public void tearDown() throws Exception {
		super.tearDown();
	}
}
