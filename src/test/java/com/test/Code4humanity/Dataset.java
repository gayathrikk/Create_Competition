package com.test.Code4humanity;

import java.awt.AWTException;

import java.awt.Robot;

import java.awt.Toolkit;

import java.awt.datatransfer.Clipboard;

import java.awt.datatransfer.StringSelection;

import java.awt.event.KeyEvent;

import java.net.URL;

import java.net.URL;

import java.util.Set;

import java.util.concurrent.TimeUnit;



import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.Keys;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.remote.DesiredCapabilities;

import org.openqa.selenium.remote.LocalFileDetector;

import org.openqa.selenium.remote.RemoteWebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;

public class Dataset {
	
	private WebDriver driver;

	private WebDriverWait wait;



	@BeforeTest

	public void setup() throws Exception {

	DesiredCapabilities dc = DesiredCapabilities.chrome();

	URL url = new URL("http://172.20.23.7:5554/wd/hub");

	driver = new RemoteWebDriver(url, dc);

	wait = new WebDriverWait(driver, 60);



	}



	@Test(priority = 1)

	public void login() throws InterruptedException {

	driver.get("http://code4humanity.humanbrain.in/annotation/analytics/home");

	driver.manage().window().maximize();

	String currentURL = driver.getCurrentUrl();

	System.out.println("Current URL: " + currentURL);

	WebDriverWait wait = new WebDriverWait(driver, 60);

	driver.switchTo().defaultContent(); // Switch back to default content



	Thread.sleep(2000);

	WebElement competitionsELement = wait

	.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(), 'Datasets')]")));

	if (competitionsELement.isEnabled() && competitionsELement.isDisplayed()) {

	competitionsELement.click();

	System.out.println("Datasets icon is clicked");

	} else {

	System.out.println("Datasets icon is not clickable");

	}



	System.out.println("************************Login validation Start***********************");



	String parentWindow = driver.getWindowHandle();

	WebElement loginButton = wait

	.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=' Log In ']")));

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

	WebElement emailInput = wait

	.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='email']")));

	if (emailInput != null && emailInput.isDisplayed()) {

	emailInput.sendKeys("teamsoftware457");

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



	WebElement passwordInput = wait.until(

	ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@aria-label='Enter your password']")));

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

	Thread.sleep(3000);



	}



	@Test(priority = 2)

	public void addDataset() throws InterruptedException, AWTException {



	System.out.println("************************Add Dataset start***********************");



	WebDriverWait wait = new WebDriverWait(driver, 60);



	WebElement hostELement = wait.until(

	ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(text(), 'Add Dataset')]")));



	if (hostELement.isEnabled() && hostELement.isDisplayed()) {

	hostELement.click();

	System.out.println("Add Dataset button is clicked");

	} else {

	System.out.println("Add Dataset button is not clickable");

	}

	Thread.sleep(2000);



	WebElement iframeElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("iframe")));



	// now we will Switch to the iframe for further actions

	driver.switchTo().frame(iframeElement);



	WebElement userInput = wait

	.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='text']")));

	if (userInput != null && userInput.isDisplayed()) {

	userInput.sendKeys("admin");

	System.out.println("Username was entered successfully.");

	} else {

	System.out.println("Username was not entered.");

	}

	Thread.sleep(2000);



	WebElement passInput = wait

	.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='password']")));

	if (passInput != null && passInput.isDisplayed()) {

	passInput.click();

	passInput.sendKeys("admin");

	System.out.println("Password was entered successfully.");

	} else {

	System.out.println("Password was not entered.");

	}

	Thread.sleep(2000);

	driver.findElement(By.xpath("//button[normalize-space()='Log in']")).click();

	System.out.println("Login button clicked successfully");



	WebElement nameELement = wait

	.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='id_name']")));

	if (nameELement.isEnabled() && nameELement.isDisplayed()) {

	nameELement.sendKeys("Automation_Datasets_1");

	System.out.println("Name entered successfully");

	} else {

	System.out.println("Name is not entered");

	}

	Thread.sleep(2000);



	WebElement ontologyELement = wait.until(

	ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@id='select2-id_ontology-container']")));

	if (ontologyELement.isEnabled() && ontologyELement.isDisplayed()) {

	ontologyELement.click();

	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@aria-label='Search']")))

	.sendKeys("Atlas", Keys.ENTER);



	System.out.println("Ontology is selected successfully");

	} else {

	System.out.println("Ontology is not selected");

	}

	Thread.sleep(2000);



	WebElement descriptionELement = wait

	.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//textarea[@id='id_description']")));

	if (descriptionELement.isEnabled() && descriptionELement.isDisplayed()) {

	descriptionELement.sendKeys("Writing this to add a new dataset for testing");

	System.out.println("Description entered successfully");

	} else {

	System.out.println("Description is not entered");

	}

	Thread.sleep(2000);



	((RemoteWebDriver) driver).setFileDetector(new LocalFileDetector());

//	driver.get("https://www.monsterindia.com/seeker/registration"); 



	WebElement browser = driver.findElement(By.xpath("//input[@type='file' and @name='image']"));

	// Upload button xpath



	System.out.println("File upload Successfully");



	WebElement imageELement = driver.findElement(By.xpath("//input[@type='file' and @name='image']"));

	if (imageELement.isEnabled() && imageELement.isDisplayed()) {



	Thread.sleep(2000);

	imageELement.sendKeys("src/test/resources/automation.png");

	System.out.println("Image selected successfully");

	} else {

	System.out.println("Image is not selected");

	}

	Thread.sleep(2000);



	WebElement saveELement = wait

	.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[contains(@type, 'submit')]")));

	if (saveELement.isEnabled() && saveELement.isDisplayed()) {

	saveELement.click();

	System.out.println("Datasets saved successfully");

	} else {

	System.out.println("Datasets is not saved");

	}

	Thread.sleep(3000);



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



	System.out.println("************************Adding dataset done***********************\n\n");



	}



	@Test(priority = 3)

	public void deleteDataset() throws InterruptedException {

	System.out

	.println("************************* Now will delete the created Dataset *************************\n\n");



	driver.get("http://code4humanity.humanbrain.in/annotation/lims");

	Thread.sleep(5000);

	WebElement iframeElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("iframe")));



	// now we will Switch to the iframe for further actions

	driver.switchTo().frame(iframeElement);



	WebElement datasetElement = wait

	.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(), 'Data sets')]")));

	if (datasetElement.isEnabled() && datasetElement.isDisplayed()) {

	datasetElement.click();

	System.out.println("Datasets icon is clicked");

	} else {

	System.out.println("Datasets icon is not clickable");

	}

	Thread.sleep(2000);



	WebElement selectElement = wait.until(ExpectedConditions

	.presenceOfElementLocated(By.xpath("//a[contains(text(), 'Automation_Datasets_1')]")));

	if (selectElement.isEnabled() && selectElement.isDisplayed()) {

	selectElement.click();

	System.out.println("Datasets name is selected successfully");

	} else {

	System.out.println("Datasets name is not selected");

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

	System.out.println("Datasets deleted successfully");

	} else {

	System.out.println("Datasets is not deleted");

	}

	Thread.sleep(2000);



	System.out.println("************************* Dataset is deleted successfully *************************\n\n");

	driver.switchTo().defaultContent();



	}



	@AfterTest

	public void afterTest() {

	driver.quit();

	}

}
