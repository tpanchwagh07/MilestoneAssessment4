package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks {
	
	public static WebDriver driver;

	@BeforeAll
	public static void setUp() {
		String browser = System.getProperty("browser", "chrome");
		if (driver == null) {
			if (browser.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().clearDriverCache().setup();
				driver = new ChromeDriver();
			}else if (browser.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().clearDriverCache().setup();
				driver = new FirefoxDriver();
			}else if (browser.equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().clearDriverCache().setup();
				driver = new EdgeDriver();
			}
			driver.manage().window().maximize();
		}
	}

	@AfterAll
	public static void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
