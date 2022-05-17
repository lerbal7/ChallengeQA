package challengeQA;

import org.junit.Assert;
import java.time.Duration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.JavascriptExecutor;

public class testEditItem extends base {

	@Before
	public void setUp() throws Exception {
		super.setUp();
	}

	@Test
	public void testEdit() throws InterruptedException {
		String descriptionText = "I have edited the description of this item";
		
		WebDriverWait wait = new WebDriverWait(super.getDriver(), Duration.ofSeconds(2));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@ng-model='items']"))); // Wait for the list of items to be visible 
		
		WebElement item = super.getDriver().findElement(By.xpath("//ul/li[4]"));
		((JavascriptExecutor) super.getDriver()).executeScript("arguments[0].scrollIntoView(true);", item); // Focus on the element
		
		Thread.sleep(2000); // Just some waiting for seeing how it focuses and then goes back to the top to edit the description
		
		super.getDriver().findElement(By.xpath("//*[@id=\"content\"]/div[1]/div/ul/li[5]/div/div/div[1]/button[1]")).click(); // Click on the Edit button
		
		WebElement descriptionElement = super.getDriver().findElement(By.tagName("textarea"));
		descriptionElement.clear(); 
		descriptionElement.sendKeys(descriptionText); // Change the description of the item 
		
		super.getDriver().findElement(By.xpath("//button[text()='Update Item']")).click();
		
		((JavascriptExecutor) super.getDriver()).executeScript("arguments[0].scrollIntoView(true);", item);
		
		// Make sure that the new description has been added to the chosen item
		Assert.assertTrue(super.getDriver().findElement(By.xpath("/html/body/div[2]/div[1]/div/ul/li[5]/div/div/div[2]/p")).getText().contains(descriptionText));
	}
	
	@After
	public void tearDown() throws Exception {
		super.tearDown();
	}

}
