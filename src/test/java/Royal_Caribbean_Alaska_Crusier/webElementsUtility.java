package Royal_Caribbean_Alaska_Crusier;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class webElementsUtility {
	static WebElement element=null;
	public static WebElement searchicon(WebDriver driver) {
		element = driver.findElement(By.id("rciSearchHeaderIcon"));
		return element;
	}
	public static WebElement searchinput(WebDriver driver) {
		element = driver.findElement(By.xpath("//div[@class='headerSearch__base__container__searchbox']//input[@id='rciSearchInput']"));
		return element;
	}
	public static WebElement searchButton(WebDriver driver) {
		element = driver.findElement(By.xpath("//div[@class='headerSearch__base__container__searchbox']//div[@id='rciSearchInputIcon']"));
		return element;
	}
	public static WebElement searchResult(WebDriver driver) {
		element = driver.findElement(By.xpath("//div[@class='searchResult__base'][1]//a"));
		return element;
	}
	public static WebElement BookNow(WebDriver driver) {
		element = driver.findElement(By.xpath("//a[@id=\"promoHeroCTAButton\"]"));
		return element;
	}
	
	public static WebElement dateButton(WebDriver driver) {
		element = driver.findElement(By.xpath("//button[@class=\"MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-colorPrimary MuiButton-disableElevation MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-colorPrimary MuiButton-disableElevation filter-dropdown-startDate filter-button css-pjauuf\"]"));
		return element;
	}
	public static List<WebElement> months(WebDriver driver) {
		List<WebElement> mylist = driver.findElements(By.xpath("//div[@class=\"styles__YearWrapper-sc-e7674c24-1 gDVxdN date-carousel-item-class\"]//button"));
		return mylist;
	}
	public static WebElement destination(WebDriver driver) {
		element = driver.findElement(By.xpath("//section[@class='components__FiltersConstrain-sc-90ce5f2-2 kaPDeG']//button[@type='button'][normalize-space()='Destinations']"));
		return element;
	}
	public static WebElement destinationSelect(WebDriver driver) {
		element = driver.findElement(By.xpath("//button[@id='custom-filter-label-AL_KSF']"));
		return element;
	}
	public static WebElement departurePort(WebDriver driver) {
		element = driver.findElement(By.xpath("//section[@class='components__FiltersConstrain-sc-90ce5f2-2 kaPDeG']//button[@type='button'][normalize-space()='Departure Port']"));
		return element;
	}
	public static WebElement departurePortSelect(WebDriver driver) {
		element = driver.findElement(By.xpath("//button[text()=\"Seattle, Washington\"]"));
		return element;
	}
	
	public static WebElement numberOfNights(WebDriver driver) {
		element = driver.findElement(By.xpath("//section[@class='components__FiltersConstrain-sc-90ce5f2-2 kaPDeG']//button[@type='button'][normalize-space()='Number of nights']"));
		return element;
	}
	
	public static WebElement numberOfNightSelection(WebDriver driver) {
		element = driver.findElement(By.xpath("//button[normalize-space()='6 - 8']")); 
		return element;
	}
	public static WebElement seeResults(WebDriver driver) {
		element = driver.findElement(By.xpath("//button[normalize-space()='See results']"));
		return element;
	}
	
	public static  List<WebElement> getCuises(WebDriver driver)
	{
		List<WebElement> myList = driver.findElements(By.xpath("//div[@data-destination-code=\"SEA\"]//div//div//div[1]//h3"));
		return myList;	
	}
	public static  List<WebElement> getCuisesPrice(WebDriver driver)
	{
		List<WebElement> myList = driver.findElements(By.xpath("//div[@data-destination-code=\"SEA\"]//div[5]//span[2]"));
		return myList;	
	}
	
}
