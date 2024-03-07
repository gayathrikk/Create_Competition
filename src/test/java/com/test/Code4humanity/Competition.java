package com.test.Code4humanity;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Competition {
	
	  private RemoteWebDriver driver;
		
			@BeforeTest
			
			public void setup() throws MalformedURLException 
			{
				
				  DesiredCapabilities dc = DesiredCapabilities.chrome();
			        URL url = new URL("http://172.20.23.7:5554/wd/hub");
			        driver = new RemoteWebDriver(url, dc);
			
			       
			}
			//@Parameters("URL")
			@Test(priority=1)
			//public void login(@Optional("defaultURL") String URL) throws InterruptedException
			public void Launch()throws InterruptedException
			{
				//driver.get(URL);
				driver.get("http://code4humanity.humanbrain.in/annotation/analytics/home");
				driver.manage().window().maximize();
				String HomeURL="http://code4humanity.humanbrain.in/annotation/analytics/home";
				String currentURL = driver.getCurrentUrl();
		        System.out.println("Home URL: " + currentURL);
		        Assert.assertEquals(currentURL, HomeURL, "URLs do not match!");
			}
			
			@Test(priority=2)
			public void Login() throws InterruptedException
			{
				WebDriverWait wait = new WebDriverWait(driver, 10);
				 try {
		    		    WebElement Competition = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Competitions']")));
		    		    Competition.click();
		    		    System.out.println("competition clicked successfully.");
		    		    Thread.sleep(2000);
		    		} catch (Exception e) {
		    		    System.out.println("competition Brain not clicked: " + e.getMessage());
		    		}
				 
				 String parentWindow = driver.getWindowHandle();
				 WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=' Log In ']")));
			        if (loginButton != null) {
			            loginButton.click();
			            System.out.println("Login button clicked successfully.");
			        } else {
			            System.out.println("Login button is not clicked.");
			        }
				  wait.until(ExpectedConditions.numberOfWindowsToBe(2));
				  Set<String> allWindows = driver.getWindowHandles();
			        for (String window : allWindows) {
			            if (!window.equals(parentWindow)) {
			                driver.switchTo().window(window);
			                break;
			            }
			        }
			        
			        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='email']")));
			        if (emailInput != null && emailInput.isDisplayed()) {
			            emailInput.sendKeys("teamsoftware457@gmail.com");
			            System.out.println("Email was entered successfully.");
			        } else {
			           System.out.println("Email was not entered.");
			        }
			       
			
			        WebElement nextButton1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Next']")));
			        if (nextButton1 != null) {
			            nextButton1.click();
			            System.out.println("Next button 1 is clicked.");
			        } else {
			            System.out.println("Next button 1 is not clicked.");
			        }
			       
			        WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@aria-label='Enter your password']")));
			        passwordInput.sendKeys("Health#123");
			        if (passwordInput.getAttribute("value").equals("Health#123")) {
			            System.out.println("Password was entered successfully.");
			        } else {
			            System.out.println("Password was not entered.");
			        }
			       
			        
			        WebElement nextButton2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Next']")));
			        if (nextButton2 != null) {
			            nextButton2.click();
			            System.out.println("Next button 2 is clicked.");
			        } else {
			            System.out.println("Next button 2 is not clicked.");
			        }
			        
			
			        driver.switchTo().window(parentWindow);
			        System.out.println("Login successfully");
			        
			        System.out.println("************************Login validation done***********************");
			        Thread.sleep(5000);
				 
			}
			
			@Test(priority=3)
			public void Hostcompetition()
			{
				 WebDriverWait wait = new WebDriverWait(driver, 10);
				try {
	    		    WebElement Competition = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Host a Competition']")));
	    		    Competition.click();
	    		    System.out.println("Hostcompetition clicked successfully.");
	    		    Thread.sleep(2000);
	    		} catch (Exception e) {
	    		    System.out.println("Hostcompetition not clicked: " + e.getMessage());
	    		}
				
				driver.switchTo().frame(0);
				 WebElement NameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='username']")));
			        if (NameInput != null && NameInput.isDisplayed()) {
			        	NameInput.sendKeys("admin");
			            System.out.println("Username was entered successfully.");
			        } else {
			           System.out.println("Username was not entered.");
			        }
			        
			        WebElement Password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='password']")));
			        if (Password != null && Password.isDisplayed()) {
			        	Password.sendKeys("admin");
			            System.out.println("Password was entered successfully.");
			        } else {
			           System.out.println("Password was not entered.");
			        }
			        try {
		    		    WebElement Login = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Log in']")));
		    		    Login.click();
		    		    System.out.println("Login clicked successfully.");
		    		    Thread.sleep(2000);
		    		} catch (Exception e) {
		    		    System.out.println("Login Brain not clicked: " + e.getMessage());
		    		} 
			}
			    
			@Test(priority=4)
			public void competionName() throws InterruptedException
			{
				 WebDriverWait wait = new WebDriverWait(driver, 10);
					try {
		    		    WebElement competionName = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='name']")));
		    		    competionName.sendKeys("Automation Competition1");
		    		    System.out.println("competionName Entered successfully.");
		    		    Thread.sleep(2000);
		    		} catch (Exception e) {
		    		    System.out.println("competionName  not Entered: " + e.getMessage());
		    		}
					Thread.sleep(2000);
			}
			
			@Test(priority=5)
			public void Description() throws InterruptedException
			{
				 WebDriverWait wait = new WebDriverWait(driver, 10);
					try {
		    		    WebElement Description = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//textarea[@name='description']")));
		    		    Description.sendKeys("Testing purpose");
		    		    System.out.println("Description Entered successfully.");
		    		    Thread.sleep(2000);
		    		} catch (Exception e) {
		    		    System.out.println("Description  not Entered: " + e.getMessage());
		    		}
					Thread.sleep(2000);
			}
			
			@Test(priority=6)
			public void Pipeline() throws InterruptedException
			{
				 WebDriverWait wait = new WebDriverWait(driver, 10);
					try {
		    		    WebElement Pipeline = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//b[@role='presentation'])[1]")));
		    		    Pipeline.click();
		    		    System.out.println("Pipeline Clicked successfully.");
		    		    Thread.sleep(2000);
		    		} catch (Exception e) {
		    		    System.out.println("Pipeline  not Clicked: " + e.getMessage());
		    		}
					Thread.sleep(2000);
					
					try {
		    		    WebElement celldetection = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='CellDetection']")));
		    		    celldetection.click();
		    		    System.out.println("celldetection Clicked successfully.");
		    		    Thread.sleep(2000);
		    		} catch (Exception e) {
		    		    System.out.println("celldetection  not Clicked: " + e.getMessage());
		    		}
					Thread.sleep(2000);
		  }
			
			@Test(priority=7)
			public void uploadfile() throws InterruptedException
			{
				
				 File filePath = new File("src/test/resources/automation.png");
				 WebElement fileInput = driver.findElement(By.xpath("//input[@type='file']")); 
			     fileInput.sendKeys(filePath.getAbsolutePath());
			     Thread.sleep(3000);
			}
			
			        
	    	@AfterTest
			public void close()
			{
				driver.quit();
			}
			

}
