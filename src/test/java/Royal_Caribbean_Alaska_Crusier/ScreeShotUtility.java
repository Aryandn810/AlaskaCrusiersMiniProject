package Royal_Caribbean_Alaska_Crusier;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
 
public class ScreeShotUtility {

	public static void captureScreenshot(WebDriver driver,String fileName) {
		
		String destination = System.getProperty("user.dir")+"/screenshot/"+fileName+".png";
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);
		
		try {
			Files.createDirectories(Paths.get(System.getProperty("user.dir")+"/screenshot/"));
			Files.copy(sourceFile.toPath(), new File(destination).toPath());
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void captureElementScreenshot(WebDriver driver,WebElement element,String fileName) {
		
		String destination = System.getProperty("user.dir")+"/screenshot/"+fileName+".png";
		
//		TakesScreenshot ts = (TakesScreenshot)driver;
		File sourceFile = element.getScreenshotAs(OutputType.FILE);
		
		try {
			Files.createDirectories(Paths.get(System.getProperty("user.dir")+"/screenshot/"));
			Files.copy(sourceFile.toPath(), new File(destination).toPath());
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
