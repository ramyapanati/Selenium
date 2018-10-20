package TestScripts;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ReusableMethod {
	
	static ExtentHtmlReporter htmlReporter;
	static ExtentReports extent=null;
	static ExtentTest logger=null;
	public static WebDriver driver = null;
	
	public static Properties loadPropertyFile(String strPath) throws IOException{
	
		Properties pro = new Properties();
	
		BufferedReader reader = new BufferedReader(new FileReader(strPath));
		pro.load(reader);
		return pro;
	}
public static By getLocator(String strElement,Properties propertyFile) throws Exception {
	
	//Properties prop = new Properties();
	// retrieve the specified object from the object list
	String locator = propertyFile.getProperty(strElement);
	
	// extract the locator type and value from the object
	String locatorType = locator.split(":")[0];
	String locatorValue = locator.split(":")[1];
	
	// for testing and debugging purposes
	System.out.println("Retrieving object '" + strElement + "' with attribute type '" + locatorType + "' and attribute value '" + locatorValue + "' from the object map");
	
	// return a instance of the By class based on the type of the locator
	// this By can be used by the browser object in the actual test
	if(locatorType.toLowerCase().equals("id"))
		return By.id(locatorValue);
	else if(locatorType.toLowerCase().equals("name"))
		return By.name(locatorValue);
	else if((locatorType.toLowerCase().equals("classname")) || (locatorType.toLowerCase().equals("class")))
		return By.className(locatorValue);
	else if((locatorType.toLowerCase().equals("tagname")) || (locatorType.toLowerCase().equals("tag")))
		return By.className(locatorValue);
	else if((locatorType.toLowerCase().equals("linktext")) || (locatorType.toLowerCase().equals("link")))
		return By.linkText(locatorValue);
	else if(locatorType.toLowerCase().equals("partiallinktext"))
		return By.partialLinkText(locatorValue);
	else if((locatorType.toLowerCase().equals("cssselector")) || (locatorType.toLowerCase().equals("css")))
		return By.cssSelector(locatorValue);
	else if(locatorType.toLowerCase().equals("xpath"))
		return By.xpath(locatorValue);
	else
		throw new Exception("Unknown locator type '" + locatorType + "'");
}

	
	public static WebDriver IntializeDriver(String name){
		
		if(name.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver","./src/test/resources/Utility/geckodriver");
			driver=new FirefoxDriver();
		}
		else if(name.equalsIgnoreCase("chrome")){
			System.out.println("chrome entered");
			System.setProperty("webdriver.chrome.driver","./src/test/resources/chromedriver.exe");
			//driver=new ChromeDriver();
			//driver.manage().window().maximize();
		}
		else if(name.equalsIgnoreCase("ie")){
			System.out.println("chrome entered");
			System.setProperty("webdriver.ie.driver","./src/test/resources/IEDriverServer.exe");
			//driver=new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		return driver;
	}
	public static void closeDriver(){
		driver.close();
	}
	
	
	public static String takeScreenShot() throws IOException{
		String reportPath = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		String curDir = System.getProperty("user.dir");
		String destination = curDir+"/TestReports/Screenshots/"+reportPath+"image.PNG";
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(destination),true);
		return destination;
		
		}
	public static void executionReport(String reportName) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		String timeNow = dtf.format(now);
		timeNow = timeNow.replace(":", "_");
		timeNow = timeNow.replace(" ", "_");
		timeNow = timeNow.replace("/", "_");
		
		
		System.out.println(reportName+"_"+timeNow+".html");
		
htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/TestReports/"+reportName+".html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}

	public static String[][] readSheet(String dt_path,String sheetName) throws IOException{
		//String path = System.getProperty("user.dir");
		//sSystem.out.println(path);
		File XLfin = new File(dt_path);
		FileInputStream xlDoc = new FileInputStream(XLfin);
		HSSFWorkbook workbook = new HSSFWorkbook(xlDoc);
		HSSFSheet sheet = workbook.getSheet(sheetName); 
	    int rows = sheet.getLastRowNum()+1;
		int cols = sheet.getRow(0).getLastCellNum();
		System.out.println("rows="+rows+"cols="+cols);
		String[][] data = new String[rows][cols];
		for(int i =0;i<rows;i++){
			for(int j =0;j<cols;j++){
				
				HSSFCell cell = sheet.getRow(i).getCell(j);
				if(cell.getCellType() == CellType.STRING)
				
				data[i][j] = cell.getStringCellValue()+" ";
				else if(cell.getCellType() == CellType.NUMERIC)
				data[i][j] = String.valueOf(cell.getNumericCellValue());	
				
			}
			System.out.println();
			
		}
		return data;
		
	}
	public static void enterTextUser (WebElement webElement,String webElementName,String text)
	{
		if (webElement.isDisplayed())
		{		
			webElement.sendKeys(text);
			logger.log(Status.PASS,text+" entered in " +webElementName);		
		}
		else
			logger.log(Status.FAIL, MarkupHelper.createLabel(webElementName+" Text box not found ", ExtentColor.RED));


	}
	public static void enterTextPswd (WebElement webElement,String webElementName,String text)
	{
		if (webElement.isDisplayed())
		{		
			webElement.sendKeys(text);
			logger.log(Status.PASS,text+" entered in " +webElementName);		
		}
		else
			logger.log(Status.FAIL, MarkupHelper.createLabel(webElementName+" Text box not found ", ExtentColor.RED));


	}
 
	 public static void clickElement (WebElement element, String elementName) throws IOException
		{
			if (element.isDisplayed())
			{
				logger.log(Status.PASS,elementName+" is clicked");
				element.click();
				//String imagePath=takeScreenShot();
				//logger.addScreenCaptureFromPath(imagePath);
				
			}
			else
				logger.log(Status.FAIL, MarkupHelper.createLabel( elementName+" is not found", ExtentColor.RED));
		
		}
	 
	

}
