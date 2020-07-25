package utility;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.aventstack.extentreports.ExtentReports;

public class Base {

	public static WebDriver driver;
	public static ExtentReports reports;
	
	Properties prop;
	String waitingTime;
	String chromeBrowser = "chrome";
	String firefoxBrowser = "firefox";
	String edgeBrowser = "edge";
	
	public static Logger log = LogManager.getLogger(Base.class.getName());

	public void setBrowser() throws Throwable {

		
		String chromeDriverPath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
		String firefoxDriverPath = System.getProperty("user.dir") + "\\drivers\\geckodriver.exe";
		String ieDriverPath = System.getProperty("user.dir") + "\\drivers\\IEDriverServer.exe";

		String propertyPath = System.getProperty("user.dir") + "\\properties\\config.properties";
		prop = new Properties();
		FileInputStream readProperties = new FileInputStream(propertyPath);
		prop.load(readProperties);

		
		waitingTime = prop.getProperty("implicitTime");
		String testExecutionBrowser = prop.getProperty("browser");
		System.out.println("Execution browser " + testExecutionBrowser);

		if (testExecutionBrowser.equals(chromeBrowser)) {

			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			log.info("Inititate chrome browser");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			options.addArguments("window-size=1200x600");
			driver = new ChromeDriver();
			log.info("Initiated chrome browser");

		} else if (testExecutionBrowser.equals(firefoxBrowser)) {

			System.setProperty("webdriver.gecko.driver", firefoxDriverPath);
			log.info("Initiate firefox browser");
			FirefoxOptions options = new FirefoxOptions();
			options.addPreference("javascript.enabled", true);
			driver = new FirefoxDriver(options);
			log.info("Initiated firefox browser");

		} else if (testExecutionBrowser.equals(edgeBrowser)) {

			System.setProperty("webdriver.ie.driver", ieDriverPath);
			driver = new InternetExplorerDriver();
			log.info("Initiated IE/Edge browser");
		}

		driver.manage().window().maximize();
		log.info("Browser has been maximized");
		String url = prop.getProperty("url");
		driver.get(url);
		int impWait = Integer.parseInt(waitingTime);
		driver.manage().timeouts().implicitlyWait(impWait, TimeUnit.SECONDS);
		log.info(driver.getTitle());

	}
	

}
