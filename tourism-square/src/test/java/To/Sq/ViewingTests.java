package To.Sq;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ViewingTests {
		@Test
		public void visualizzaElementiTest() {

			System.out.println("Starting ViewingTests");

//			Create driver
			WebDriver driver = new ChromeDriver();

			sleep(1000);

			// maximize browser window
			driver.manage().window().maximize();

//			open Tourism Square page
			String url = "https://node33014-ibsenviroment.it1.eur.aruba.jenv-aruba.cloud/tourismWeb";
			driver.get(url);

			sleep(2000);

			System.out.println("Page is opened.");

			// click login button
			WebElement accediButton = driver.findElement(By.cssSelector(".btn.btn-primary.form-control.py-2"));
			accediButton.click();

			// verifica 
			
			//visualizza nuova pagina
			String expectedUrl = "https://node33014-ibsenviroment.it1.eur.aruba.jenv-aruba.cloud/tourismWeb/#/login";
			String actualUrl = driver.getCurrentUrl();
			Assert.assertEquals(actualUrl, expectedUrl, "Actual page url is not the same as expected");

			// visualizza campo Email 
			WebElement emailField = driver.findElement(By.id("email"));
			Assert.assertTrue(emailField.isDisplayed(), "Il campo Email non è visibile");

			// visualizza campo Password 
			WebElement passwordField = driver.findElement(By.id("password"));
			Assert.assertTrue(passwordField.isDisplayed(), "Il campo Password non è visibile");
			
			//visualizza pulsante Accedi (cliccabile solo se i campi: Email e Password sono compilati)
			WebElement accedi2Button = driver.findElement(By.cssSelector(".btn.btn-primary.col-10.col-sm-8.mb-4"));
			Assert.assertTrue(accedi2Button.isDisplayed(), "Il pulsante Accedi non è visibile");

			//  visualizza accesso tramite fb
			WebElement fbButton = driver.findElement(By.cssSelector(".btn.btn-default"));
			Assert.assertTrue(fbButton.isDisplayed(), "Il pulsante fb non è visibile");
			
			// visualizza "Hai dimenticato la password? Clicca Qui"
			WebElement cliccaQui = driver.findElement(By.cssSelector(".align-content-center p:nth-child(8)"));
			Assert.assertTrue(cliccaQui.isDisplayed(), "Il link Clicca qui non è visibile ");
			
			// visualizza "Non sei registrato? Registrati"
			WebElement registratiLikn = driver.findElement(By.cssSelector(".signinlbl.text-center > a"));
			Assert.assertTrue(registratiLikn.isDisplayed(), "Il link Registrati non è visibile ");
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

