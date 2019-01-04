package com.qa.Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TestGeneric extends TestBase {
	
	
	
	public WebElement getXpath(String objName) {
		String xpath = elementsProperties.getProperty(objName);	
		WebElement el = driver.findElement(By.xpath(xpath));
		return el;
		
	}
	public void clickButton(String objName) {
		WebElement el = getXpath(objName);
		el.click();
	}
	
	public void enterText(String objName, String value) {
		getXpath(objName).sendKeys(value);;
		
	}
	
}