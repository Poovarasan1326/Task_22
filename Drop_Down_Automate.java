package task_22;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Drop_Down_Automate {

	public static void main(String[] args) {
		// Initialize the ChromeDriver
		WebDriver driver = new ChromeDriver();

		// Timeouts
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Maximize the browser window
		driver.manage().window().maximize();

		// Navigate to the form page
		driver.get("https://phptravels.com/demo/");

		// Fill in the form details
		WebElement firstNameInput = driver.findElement(By.name("first_name"));
		firstNameInput.sendKeys("jack");

		WebElement lastNameInput = driver.findElement(By.name("last_name"));
		lastNameInput.sendKeys("jackj");

		WebElement businessNameInput = driver.findElement(By.name("business_name"));
		businessNameInput.sendKeys("jackd");

		WebElement emailInput = driver.findElement(By.name("email"));
		emailInput.sendKeys("jack@example.com");

		// Calculate num1 and num2
		WebElement getNum1 = driver.findElement(By.id("numb1"));
		int num1 = Integer.parseInt(getNum1.getText());

		WebElement getNum2 = driver.findElement(By.id("numb2"));
		int num2 = Integer.parseInt(getNum1.getText());

		int result = num1 + num2;

		// Convert the result to a string before sending keys
		String resultString = String.valueOf(result);

		// Find the element to send the result
		WebElement outputResult = driver.findElement(By.id("number"));

		// Send keys (input) to the web element
		outputResult.sendKeys(resultString);

		WebElement submitButton = driver.findElement(By.xpath("//button[text()='Submit']"));
		submitButton.click();

		// Wait for the success message
		WebElement successMessage = driver.findElement(By.xpath("//strong[text()=' Thank you!']"));

		// Verify the message displayed
		if (successMessage.getText().contains(" Thank you!")) {
			System.out.println("Form submitted successfully.");
		} else {
			System.out.println("Form submission failed.");
		}

		// Close the browser
		driver.quit();
	}

}
