package testery.testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class FirstTest {

	WebDriver driver;
	
	private WebDriver createBrowser() {
		ChromeOptions options = new ChromeOptions();

		if("true".equals(System.getenv("IS_TESTERY"))) {
		    options.addArguments(System.getenv("TESTERY_CHROME_ARGS").split(";"));
		}

		return new ChromeDriver(options);
	}


	@Test(groups = {"pass"})
	public void webSiteName() {
		WebDriver browser = createBrowser();
        browser.get("http://www.testery.io/");
        System.out.println(browser.getTitle());
        Assert.assertEquals(browser.getTitle(), "Testery - Cloud-based continuous testing platform");

	}
}