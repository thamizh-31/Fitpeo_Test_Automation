package base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;

import pages.SelectProductPage;

public class BaseClass {
	public static WebDriver driver;
	

	@Parameters("browser")
	 //this method is to initialize the Browser Setup
	public static WebDriver getDriver(String browser) {
		driver=null;
        if (browser.equalsIgnoreCase("chrome")) {         
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }
		
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        driver.get(SelectProductPage.URL);
        return driver;
    }
	 @AfterClass
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
}
