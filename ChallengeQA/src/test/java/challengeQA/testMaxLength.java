package challengeQA;

import java.time.Duration;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class testMaxLength extends base {

	@Before
	public void setUp() throws Exception {
		super.setUp();
	}

	@Test
	public void testText() {
		WebDriverWait wait = new WebDriverWait(super.getDriver(), Duration.ofSeconds(2));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@ng-model='items']"))); // Wait for the list of items to be visible 
		super.getDriver().findElement(By.xpath("//*[@id=\"content\"]/div[1]/div/ul/li[1]/div/div/div[1]/button[1]")).click();
		
		WebElement description = super.getDriver().findElement(By.tagName("textarea"));
		description.clear();
		description.sendKeys("This is a test for checking the max length of the field description. There should be a limit of 300 characters. If more characters are allowed, then the test should fail. Otherwise, if 300 or less than 300 chracters are allowed, then the test is going to pass. This should be a text of 300 characters");
		
		String text = description.getAttribute("value");
		int textLength = text.length();
		Assert.assertTrue(textLength <= 300);
		WebElement updateBtn = super.getDriver().findElement(By.xpath("//button[contains(text(), 'Update Item')]"));
		Assert.assertTrue(updateBtn.isEnabled());
		updateBtn.click();

	}
	
	@After
	public void tearDown() throws Exception {
		super.tearDown();
	}

}
