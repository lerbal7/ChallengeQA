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

public class testDeleteItem extends base {

	@Before
	public void setUp() throws Exception {
		super.setUp();
	}
	
	@Test
	public void testDelete() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(super.getDriver(), Duration.ofSeconds(2));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@ng-model='items']"))); // Wait for the list of items to be visible
		
		WebElement desc = super.getDriver().findElement(By.xpath("//*[contains(text(), 'This is an image')]"));
		((JavascriptExecutor) super.getDriver()).executeScript("arguments[0].scrollIntoView(true);", desc);
		
		Thread.sleep(2000);
		
		super.getDriver().findElement(By.xpath("/html/body/div[2]/div[1]/div/ul/li[last()]/div/div/div[1]/button[2]")).click(); // Click on Delete button of the last element
		super.getDriver().findElement(By.xpath("//button[text()='Yes, delete it!']")).click(); // Confirm that I want to delete the element
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
	}
}
