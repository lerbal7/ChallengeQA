package challengeQA;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class base {
	
	private WebDriver driver;
	private String baseUrl = "http://immense-hollows-74271.herokuapp.com/";
	
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		Dimension dimension = new Dimension(384, 854);

		// Comment these two lines alternatively to see the test run for mobile / desktop dimensions
		driver.manage().window().maximize(); 
		//driver.manage().window().setSize(dimension);
		driver.get(baseUrl); 
	}
	
	public void tearDown() throws Exception {
		driver.quit();
	}
	
	public WebDriver getDriver() {
		return driver;
	}
}
