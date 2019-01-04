package TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.Base.TestBase;

public class TC001_Login extends TestBase {

	@BeforeTest
	public void setUp() {
		System.setProperty(pathProperties.getProperty("chromeKey"), pathProperties.getProperty("chromeValue"));
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(pathProperties.getProperty("url"));
	}
	
	@Test
	public void testLogin() {
		//driver.findElement(By.xpath(elementsProperties.getProperty("textUserID"))).sendKeys("mngr172213");
		generic.enterText("textUserID", "mngr172213");
		generic.enterText("textPassword", "zaqazev");
		generic.clickButton("buttonLogin");
		System.out.print(driver.getTitle());
	}
	
	@AfterTest
	public void cleanUp() {
		//driver.close();
	}
}
