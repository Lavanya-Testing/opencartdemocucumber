package factory;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import dev.failsafe.Timeout;

public class BaseClass {

	static WebDriver driver;
	static Properties p;
	static Logger logger;

	public static WebDriver initilizeBrowser() throws IOException {
		p = getProperties();
		String executionenv = p.getProperty("execution_env");
		String browser = p.getProperty("browser").toLowerCase();
		String os = p.getProperty("os").toLowerCase();

		if (executionenv.equalsIgnoreCase("remote")) {
			DesiredCapabilities capabilities = new DesiredCapabilities();

			switch (os) {
			case "windows":
				capabilities.setPlatform(Platform.WINDOWS);
				break;
			case "mac":
				capabilities.setPlatform(Platform.MAC);
				break;
			case "linux":
				capabilities.setPlatform(Platform.LINUX);
				break;
			default:
				System.out.println("No matching os ");
				return null;
			}
			switch (browser)
			{
			case "chrome":
				capabilities.setBrowserName("chrome");
				break;
			case "edge":
				capabilities.setBrowserName("MicrosoftEdge");
				break;
			case "firefox":
				capabilities.setBrowserName("FireFox");
				break;
			default:
				System.out.println("No matching browser");
			return null;
			}
			 driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
		}
		else if(executionenv.equalsIgnoreCase("local"))
		{
			switch(browser.toLowerCase())
			{
			case "chrome":
				driver=new ChromeDriver();
				break;
			case "edge":
				driver=new EdgeDriver();
				break;
			case "firefox":
				driver=new FirefoxDriver();
				break;
			default:
				System.out.println("No  matching browset");
			return null;	
				
			}
			
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		return driver;
		

	}

	public static WebDriver getDriver() {
		return driver;

	}

	public static Properties getProperties() throws IOException {
		FileReader file = new FileReader(System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties");
		p = new Properties();
		p.load(file);
		return p;

	}

	public static Logger getLogger() {
		logger = LogManager.getLogger();
		return logger;
	}

	public static String getRandomString() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}

	public static String getRandomNumber() {
		String generatedNumber = RandomStringUtils.randomNumeric(10);
		return generatedNumber;
	}

	public static String getAlphaNumeric() {
		String str = RandomStringUtils.randomAlphabetic(5);
		String num = RandomStringUtils.randomNumeric(10);
		return str + num;
	}

}
