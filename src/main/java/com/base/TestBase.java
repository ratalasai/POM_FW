package com.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	
	//we are going to take data from the configuration properties file and open the browser 
	//and set the configuration

	public static Properties prop;
	private static FileInputStream file;
	public static WebDriver driver;
	String proppath="./src/main/java/Configuration_prop/EQuarz_prop";

	public TestBase() {
		prop=new Properties();
		try {
			file=new FileInputStream(proppath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			prop.load(file);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void Intialization() {
		String browsername=prop.getProperty("browser");

		if(browsername.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			//WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browsername.equalsIgnoreCase("edge")){
			System.setProperty("webdriver.edge.driver", "edgedriver.exe");
			driver=new EdgeDriver();
		}
		else if(browsername.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.firefox.driver", "firefoxdriver.exe");
			driver=new FirefoxDriver();
		}
		else {
			System.out.println("enter valid browser");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(12, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}	
	
	
}
