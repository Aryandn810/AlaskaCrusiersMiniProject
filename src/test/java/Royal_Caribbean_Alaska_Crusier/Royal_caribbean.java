package Royal_Caribbean_Alaska_Crusier;

import java.time.Duration;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Royal_caribbean {
	static WebDriver driver = null;
	static WebElement element = null;
	static WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(30));
	static JavascriptExecutor js = (JavascriptExecutor)driver;

	public WebDriver createDriver(Scanner sc) {
		DriverSetup ds = new DriverSetup();
		System.out.println("Enter driver name (Chrom/Edge)");
		String driverName = sc.next();
		if (driverName.equalsIgnoreCase("chrome")) {
			driver = ds.getChromeDriver();
		} else if (driverName.equalsIgnoreCase("edge")) {
			driver = ds.getEdgeDriver();
		} else { 
			System.out.println("Please Enter correct driver name");
			createDriver(sc);
		}
		String baseUrl = "https://www.royalcaribbean.com/alaska-cruises";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
		driver.get(baseUrl);
		return driver;
	}

	public static void popup() {

		WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(120));
		mywait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div[3]/div/div[2]/div[1]")));
		ScreeShotUtility.captureScreenshot(driver, "popup");
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[3]/div/div[2]/div[1]")).click();
		// country selection
		driver.findElement(By.xpath("//button[@class=\"headerCountryNotification__CTA\"]")).click();
		String[] values = {"Handelling PopUp","Done"};
	}

	public static void search() {
		element = webElementsUtility.searchicon(driver);
		element.click();
		element = webElementsUtility.searchinput(driver);
		element.sendKeys("Rhapsody of the Seas");
		ScreeShotUtility.captureScreenshot(driver, "Search");
		element = webElementsUtility.searchButton(driver);
		element.click();
		String[] values = {"Search Rhapsody of the Seas","Done"};
	}

	public static void firstResultClick() {
		element = webElementsUtility.searchResult(driver);
		ScreeShotUtility.captureScreenshot(driver, "searchResult");
		element.click();
		String[] values = {"Opening first result form the search result","Done"};
	}

	public static void bookNow() {
		element = webElementsUtility.BookNow(driver);
		element.click();
		String[] values = {"Clicking Booking button","Done"};
	}

	public static void date() {
		element = webElementsUtility.dateButton(driver);
//		mywait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();

	}

	public static void months(Actions action) {

		List<WebElement> monthsList = webElementsUtility.months(driver);
		element = driver.findElement(By.xpath(
				"//div[@class='styles__YearWrapper-sc-e7674c24-1 gDVxdN date-carousel-item-class']//button[@type='button'][normalize-space()='Nov']"));
		String[] months = { "Jan", "Feb", "Mar", "Apr" };
		for (int i = 0; i < months.length; i++) {
			for (WebElement ele : monthsList) {
				if (ele.getText().equalsIgnoreCase(months[i])) {
					action.click(ele).perform();
					continue;
				}

			}
		}
	}

	public static void destination(Actions action) {
		element = webElementsUtility.destination(driver);
		action.click(element).perform();
		element = webElementsUtility.destinationSelect(driver);
		element.click();
	}

	public static void departurePort(Actions action) {
		element = webElementsUtility.departurePort(driver);
		element.click();
		element = webElementsUtility.departurePortSelect(driver);
		action.moveToElement(element).perform();
		mywait.until(ExpectedConditions.elementToBeClickable(element));
//		element.click();
		action.click(element).build().perform();
	
		
	}

	public static void numberOfNight(Actions action) {
		element = webElementsUtility.numberOfNights(driver);
		action.moveToElement(element).perform();
		element.click();
		element = webElementsUtility.numberOfNightSelection(driver);
		element.click();
	}

	public static void seeResults() {
		element = webElementsUtility.seeResults(driver);
		element.click();
	}

	public static List<WebElement> cusiersList() {
		ScreeShotUtility.captureScreenshot(driver, "CusierList");
		List<WebElement> list = webElementsUtility.getCuises(driver);
		return list;
	}

	public static List<WebElement> cusiersPrice() {
		List<WebElement> list = webElementsUtility.getCuisesPrice(driver);
		
		return list;
	}
	public static List<WebElement> visitingPlaces(){
		List<WebElement> list = driver.findElements(By.xpath("//ul[@class=\"CruiseCardLocationList-styles__CruiseCardLocationListItemsContainer-sc-fbffed9d-2 MlzJc\"]"));
		return list;
	}
	
	public static void FinalScreenshot() {
		List<WebElement> list= driver.findElements(By.xpath("//div[@data-destination-code=\"SEA\"]"));
		int count = 0;
		for(WebElement ele : list) {
			mywait.until(ExpectedConditions.visibilityOf(ele));
			ScreeShotUtility.captureElementScreenshot(driver, ele,"A"+count);
			count++;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Royal_caribbean rc = new Royal_caribbean();
		rc.createDriver(sc);
		Actions action = new Actions(driver);
		popup();
		search();
		firstResultClick();
		bookNow();
		date();
		months(action);
		destination(action);
		departurePort(action);
		numberOfNight(action);
		seeResults();
		List<WebElement> cruiseList=cusiersList();
		List<WebElement> priceList =  cusiersPrice();
		List<WebElement> VisitingPlaceList =  cusiersPrice();
		FinalScreenshot();
		ExcelUtility.setDataToExcel(driver, cruiseList, priceList,visitingPlaces());
		System.out.println("Total number of cruise :"+cruiseList.size());
		DriverSetup.closeDriver();

	}
}
