package Royal_Caribbean_Alaska_Crusier;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ExcelUtility {
	
	public static String getDataFromExcel(WebDriver driver,int Row,int cell) {
		String destination = "C:\\Users\\2361593\\eclipse-workspace\\MiniProject\\src\\test\\resources\\MiniProject.xlsx";
		String sheetValue = "";
		try {
			FileInputStream file = new FileInputStream(destination);
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet("Sheet1");
			sheetValue = sheet.getRow(Row).getCell(cell).toString();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		return sheetValue;
	}
	
	public static void setDataToExcel(WebDriver driver,List<WebElement> cruiserList,List<WebElement> price,List<WebElement> visitingPlace) {
		String destination = "C:\\Users\\2361593\\eclipse-workspace\\MiniProject\\src\\test\\resources\\MiniProject.xlsx";
		try {
			FileOutputStream file = new FileOutputStream(destination);
			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet("OutPut");
			XSSFRow Row0=sheet.createRow(0);
			Row0.createCell(0).setCellValue("SL.NO");
			Row0.createCell(1).setCellValue("Cruiser Name");			
			Row0.createCell(2).setCellValue("Visiting places");
			Row0.createCell(3).setCellValue("Crusier Price");
//			Row0.createCell(0).setCellValue("");
			for(int i=0;i<cruiserList.size();i++) {
				XSSFRow row = sheet.createRow(i+1);
					row.createCell(0).setCellValue(i+1);
					row.createCell(1).setCellValue(cruiserList.get(i).getText());
					row.createCell(2).setCellValue(visitingPlace.get(i).getText());
					row.createCell(3).setCellValue(Integer.parseInt(price.get(i).getText()));
			}
			
			
			workbook.write(file);
			workbook.close();
			file.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
