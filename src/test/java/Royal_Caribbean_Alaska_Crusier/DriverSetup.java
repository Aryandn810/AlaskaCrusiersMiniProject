package Royal_Caribbean_Alaska_Crusier;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverSetup {
	int a=10;
	static  WebDriver driver = null;
	public WebDriver getChromeDriver() {
		driver = new ChromeDriver();
		return driver;
	}

	public WebDriver getEdgeDriver() {
		driver = new EdgeDriver();
		return driver;
	}
	
	public static void closeDriver() {
		driver.quit();
	}
}
