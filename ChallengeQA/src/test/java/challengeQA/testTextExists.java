package challengeQA;

import java.time.Duration;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class testTextExists extends base {

	@Before
	public void setUp() throws Exception {
		super.setUp();
	}

	@Test
	public void testText() {
		WebDriverWait wait = new WebDriverWait(super.getDriver(), Duration.ofSeconds(2));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@ng-model='items']")));
		
		Assert.assertTrue(super.getDriver().findElement(By.xpath("//*[contains(text(), 'Creators: Matt Duffer, Ross Duffer')]")).isDisplayed());

	}
	
	@After
	public void tearDown() throws Exception {
		super.tearDown();
	}

}
