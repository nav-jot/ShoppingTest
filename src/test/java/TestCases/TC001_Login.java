package TestCases;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.Base.TestBase;

public class TC001_Login extends TestBase {

	@BeforeTest
	public void setUp() {
		System.setProperty(pathProperties.getProperty("chromeKey"), System.getProperty("user.dir")+pathProperties.getProperty("chromeValue"));
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(pathProperties.getProperty("url"));
	}
	
	@Test(priority = 1, dataProvider = "getData")
	public void testLogin(String userName, String password) {
		//driver.findElement(By.xpath(elementsProperties.getProperty("textUserID"))).sendKeys("mngr172213");
		generic.enterText("textUserID", userName);
		generic.enterText("textPassword", password);
		generic.clickButton("buttonLogin");
		boolean alertPresent;
		Alert alert = null;
		SoftAssert sa = new SoftAssert();
		try{
			alert = driver.switchTo().alert();
			alertPresent = true;
		}
		catch(NoAlertPresentException ex){
			alertPresent = false;
		}
		if (alertPresent) {
			alert.accept();
			sa.assertEquals(alert.getText(), "User is not valid");
		}
		else
		{
		sa.assertEquals(driver.getTitle(),"GTPL Bank Manager HomePage");
		}
	}
	
	@AfterTest
	public void cleanUp() {
		driver.close();
	}
	
	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][2];
		data[0][0]="mngr172213";
		data[0][1]="wrongpassword";
		data[1][0]="mngr172213";
		data[1][1]="zaqazev";
		return data;
	}
}
