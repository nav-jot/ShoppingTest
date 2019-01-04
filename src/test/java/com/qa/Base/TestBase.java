package com.qa.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;


public class TestBase {
	
	public static WebDriver driver = null;
	public static TestGeneric generic = null;
	
	public static File elementsFile = new File(System.getProperty("user.dir")+"/src/test/resources/Properties/elements.properties");
	public static FileInputStream efs = null;
	public static Properties elementsProperties = null;
	
	public static File pathFile = new File(System.getProperty("user.dir")+"/src/test/resources/Properties/path.properties");
	public static FileInputStream pfs = null;
	public static Properties pathProperties = null;
	
	static {	
		try {
			efs = new FileInputStream(elementsFile);
			pfs = new FileInputStream(pathFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		elementsProperties = new Properties();
		pathProperties = new Properties();
		try {
			elementsProperties.load(efs);
			pathProperties.load(pfs);
		} catch (IOException e) {
				e.printStackTrace();
		}
		generic = new TestGeneric();
	}
	
	
	
}
