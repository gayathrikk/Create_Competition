package com.test.Code4humanity;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class demo {
	

	private RemoteWebDriver driver;
	private WebDriverWait wait;

	@BeforeTest

	public void setup() throws Exception {
	DesiredCapabilities dc = DesiredCapabilities.chrome();
	URL url = new URL("http://172.20.23.7:5555/wd/hub");
	driver = new RemoteWebDriver(url, dc);
	wait = new WebDriverWait(driver, 30);

	}

	@Test(priority = 1)
	public void login() throws InterruptedException {
	driver.get("https://demo.humanbrain.in/viewer/annotation/portal");
	driver.manage().window().maximize();
	String currentURL = driver.getCurrentUrl();
	System.out.println("Current URL: " + currentURL);

}
	@AfterTest
	public void close()
	{
		driver.quit();
	}
}
