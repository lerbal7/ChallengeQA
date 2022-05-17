package challengeQA;

import static org.junit.Assert.*;

import java.time.Duration;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
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

public class testTextExists {
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
	public void testText() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@ng-model='items']")));
		
		Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(), 'Creators: Matt Duffer, Ross Duffer')]")).isDisplayed());

	}
	
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

}
