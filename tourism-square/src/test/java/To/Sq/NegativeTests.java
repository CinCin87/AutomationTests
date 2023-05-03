package To.Sq;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeTests {
	@Test
	public void incorrectEmailTest() {
	

		System.out.println("Starting incorrectEmailTest");

		WebDriver driver = new ChromeDriver();

		sleep(1000);

		driver.manage().window().maximize();

		String url = "https://node33014-ibsenviroment.it1.eur.aruba.jenv-aruba.cloud/tourismWeb";
		driver.get(url);

		sleep(1000);

		System.out.println("Page is opened.");

		WebElement accediButton = driver.findElement(By.cssSelector(".btn.btn-primary.form-control.py-2"));
		accediButton.click();

		// verifica pagina d'accesso
		String expectedUrl = "https://node33014-ibsenviroment.it1.eur.aruba.jenv-aruba.cloud/tourismWeb/#/login";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl, "Actual page url is not the same as expected");

		// campo Email
		WebElement emailField = driver.findElement(By.id("email"));
		Assert.assertTrue(emailField.isDisplayed(), "Il campo Email non è visibile");
		emailField.sendKeys("incorrect@email.com");

		// campo Password
		WebElement passwordField = driver.findElement(By.id("password"));
		Assert.assertTrue(passwordField.isDisplayed(), "Il campo Password non è visibile");
		passwordField.sendKeys("KKKKKKKK");

		// click su Accedi
		WebElement accedi2Button = driver.findElement(By.cssSelector(".btn.btn-primary.col-10.col-sm-8.mb-4"));
		accedi2Button.click();


		
		/*errorMessage		
		  WebElement errorMessage = driver.findElement(By.className("alert-custom"));
		  String expectedErrorMessage = " Email o password non corretti ";
		  String actualErrorMessage = errorMessage.getText();
		  Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage),
		  "Il messaggio attuale non contiene il messaggio aspettato; " +
		  actualErrorMessage + "\nIl messaggio aspettato: " + expectedErrorMessage); 
	    */
		 

		// Close browser
		driver.quit();
	}

	private void sleep(long m) {
		try {
			Thread.sleep(m);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
