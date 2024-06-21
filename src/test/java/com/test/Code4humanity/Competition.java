package com.test.Code4humanity;

import java.io.File;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
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
			        URL url = new URL("http://172.20.23.92:4444/wd/hub");
			        driver = new RemoteWebDriver(url, dc);
			
			       
			}
			//@Parameters("URL")
			@Test(priority=1)
			//public void login(@Optional("defaultURL") String URL) throws InterruptedException
			public void Launch()throws InterruptedException
			{
				//driver.get(URL);
				driver.get("https://code4humanity.humanbrain.in/viewer/annotation/analytics/home");
				driver.manage().window().maximize();
				String HomeURL="https://code4humanity.humanbrain.in/viewer/annotation/analytics/home";
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
			            emailInput.sendKeys("softwareteam45@gmail.com");
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
		    		    competionName.sendKeys("Automation_Competition1");
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
				
				((RemoteWebDriver) driver).setFileDetector(new LocalFileDetector());
				 File filePath = new File("src/test/resources/automation.png");
				 WebElement fileInput = driver.findElement(By.xpath("//input[@type='file']")); 
			     fileInput.sendKeys(filePath.getAbsolutePath());
			     Thread.sleep(3000);
			}
			
			@Test(priority=8)
			public void save() throws InterruptedException
			{
				WebDriverWait wait = new WebDriverWait(driver, 10);
				try {
	    		    WebElement celldetection = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='submit']")));
	    		    celldetection.click();
	    		    System.out.println("Save Clicked successfully.");
	    		    Thread.sleep(2000);
	    		} catch (Exception e) {
	    		    System.out.println("Save  not Clicked: " + e.getMessage());
	    		}
				Thread.sleep(2000);
				

				driver.switchTo().defaultContent();



				WebElement exitELement = wait.until(

				ExpectedConditions.presenceOfElementLocated(By.xpath("//div//button//nb-icon[@icon='close-outline']")));

				if (exitELement.isEnabled() && exitELement.isDisplayed()) {

				exitELement.click();

				System.out.println("Exit button was clicked successfully");

				} else {

				System.out.println("Exit button is not clickable");

				}

				Thread.sleep(3000);

			}
			

			@Test(priority =9)

			public void deleteDataset() throws InterruptedException {
				
			WebDriverWait wait = new WebDriverWait(driver, 10);

			System.out

			.println("************************* Now will delete the created Competition	 *************************\n\n");



			driver.get("https://code4humanity.humanbrain.in/viewer/annotation/lims");

			Thread.sleep(5000);

			WebElement iframeElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("iframe")));



			// now we will Switch to the iframe for further actions

			driver.switchTo().frame(iframeElement);



			WebElement datasetElement = wait

			.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Competitions']")));

			if (datasetElement.isEnabled() && datasetElement.isDisplayed()) {

			datasetElement.click();

			System.out.println("Competitions option is clicked");

			} else {

			System.out.println("Competitions option is not clickable");

			}

			Thread.sleep(2000);



			WebElement selectElement = wait.until(ExpectedConditions

			.presenceOfElementLocated(By.xpath("//a[contains(text(), 'Automation_Competition1')]")));

			if (selectElement.isEnabled() && selectElement.isDisplayed()) {

			selectElement.click();

			System.out.println("Competition name is selected successfully");

			} else {

			System.out.println("Competition name is not selected");

			}

			Thread.sleep(2000);



			WebElement deleteElement = wait

			.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(), 'Delete')]")));

			if (deleteElement.isEnabled() && deleteElement.isDisplayed()) {

			deleteElement.click();

			System.out.println("Delete icon is clicked");

			} else {

			System.out.println("Delete icon is not clickable");

			}

			Thread.sleep(2000);



			WebElement confirmElement = wait

			.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='Yes, I’m sure']")));

			if (confirmElement.isEnabled() && confirmElement.isDisplayed()) {

			confirmElement.click();

			System.out.println("Competition deleted successfully");

			} else {

			System.out.println("Competition is not deleted");

			}

			Thread.sleep(2000);



			System.out.println("************************* Competition is deleted successfully *************************\n\n");

			driver.switchTo().defaultContent();



			}
			
			        
	    	@AfterTest
			public void close()
			{
				driver.quit();
			}
			

}
