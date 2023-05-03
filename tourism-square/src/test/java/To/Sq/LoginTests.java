package To.Sq;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests {

	@Test
	public void loginTest() {
		System.out.println("Starting loginTest");

//		Create driver
		WebDriver driver = new ChromeDriver();

		sleep(1000);

		driver.manage().window().maximize();

//		open Tourism Square page
		String url = "https://node33014-ibsenviroment.it1.eur.aruba.jenv-aruba.cloud/tourismWeb";
		driver.get(url);

		sleep(1000);

		System.out.println("Page is opened.");

		// click login button
		WebElement accediButton = driver.findElement(By.cssSelector(".btn.btn-primary.form-control.py-2"));
		accediButton.click();

		// verifica pagina d'accesso
		String expectedUrl = "https://node33014-ibsenviroment.it1.eur.aruba.jenv-aruba.cloud/tourismWeb/#/login";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl, "Actual page url is not the same as expected");

		// campo Email
		WebElement emailField = driver.findElement(By.id("email"));
		Assert.assertTrue(emailField.isDisplayed(), "Il campo Email non è visibile");
		emailField.sendKeys("cinziapandolfo87@gmail.com");

		// campo Password
		WebElement passwordField = driver.findElement(By.id("password"));
		Assert.assertTrue(passwordField.isDisplayed(), "Il campo Password non è visibile");
		passwordField.sendKeys("KKKKKKKK");

		// click su Accedi
		WebElement accedi2Button = driver.findElement(By.cssSelector(".btn.btn-primary.col-10.col-sm-8.mb-4"));
		accedi2Button.click();

		// visualizza homePage
		// String expectedhomePage =
		// "https://node33014-ibsenviroment.it1.eur.aruba.jenv-aruba.cloud/tourismWeb/#/home";
		// String actualhomePage = driver.getCurrentUrl();
		// Assert.assertEquals(actualhomePage, expectedhomePage, "Actual page url is not
		// the same as expected");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		Boolean homePage = wait.until(ExpectedConditions
				.urlToBe("https://node33014-ibsenviroment.it1.eur.aruba.jenv-aruba.cloud/tourismWeb/#/home"));
		Assert.assertTrue(homePage.TRUE, actualUrl);

		// Close browser
		driver.quit();
	}

		@Test
		public void facebookLoginTest() {

			System.out.println("accessoTramiteFacebook");

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

			// verifica nuova pagina
			String expectedUrl = "https://node33014-ibsenviroment.it1.eur.aruba.jenv-aruba.cloud/tourismWeb/#/login";
			String actualUrl = driver.getCurrentUrl();
			Assert.assertEquals(actualUrl, expectedUrl, "Actual page url is not the same as expected");

			// campo Email visibile
			WebElement emailField = driver.findElement(By.id("email"));
			Assert.assertTrue(emailField.isDisplayed(), "Il campo Email non è visibile");

			// campo Password visibile
			WebElement passwordField = driver.findElement(By.id("password"));
			Assert.assertTrue(passwordField.isDisplayed(), "Il campo Password non è visibile");

			// accesso tramite Social
			WebElement fbButton = driver.findElement(By.cssSelector(".btn.btn-default"));
			Assert.assertTrue(fbButton.isDisplayed(), "Il pulsante fb non è visibile");
			fbButton.click();

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

