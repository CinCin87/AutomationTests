package To.Sq;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LinkTests {

	@Test
	public void haiDimenticatoLaPassworTest() {
		System.out.println("Starting haiDimenticatoLaPassworTest");
		WebDriver driver = new FirefoxDriver();
		sleep(1000);
		driver.manage().window().maximize();
		String url = "https://node33014-ibsenviroment.it1.eur.aruba.jenv-aruba.cloud/tourismWeb";
		driver.get(url);
		sleep(1000);
		System.out.println("Page is opened.");
		WebElement accediButton = driver.findElement(By.cssSelector(".btn.btn-primary.form-control.py-2"));
		accediButton.click();
		WebElement cliccaQuiLink = driver.findElement(By.cssSelector("[href='\\#\\/password-recovery']"));
		cliccaQuiLink.click();

		String expectedUrl = "https://node33014-ibsenviroment.it1.eur.aruba.jenv-aruba.cloud/tourismWeb/#/password-recovery";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl, "Actual page url is not the same as expected");
		driver.quit();

	}

	@Test
	public void nonSeiRegistratoTest() {
		System.out.println("Starting nonSeiRegistratoTest");
		WebDriver driver = new ChromeDriver();
		sleep(1000);
		driver.manage().window().maximize();
		String url = "https://node33014-ibsenviroment.it1.eur.aruba.jenv-aruba.cloud/tourismWeb";
		driver.get(url);
		sleep(1000);
		System.out.println("Page is opened.");
		WebElement accediButton = driver.findElement(By.cssSelector(".btn.btn-primary.form-control.py-2"));
		accediButton.click();
		WebElement registratiLink = driver.findElement(By.cssSelector(".signinlbl.text-center > a"));
		registratiLink.click();
		String expectedUrl = "https://node33014-ibsenviroment.it1.eur.aruba.jenv-aruba.cloud/tourismWeb/#/registration";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl, "Actual page url is not the same as expected");
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
