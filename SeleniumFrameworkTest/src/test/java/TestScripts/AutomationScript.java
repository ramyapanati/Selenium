package TestScripts;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class AutomationScript extends ReusableMethod{
	
	public static void loginToXero() throws Exception{
		String propertyPath = "./src/test/resources/DataFiles/Configuration.properties";
		Properties pro = loadPropertyFile(propertyPath);
		String objectRepoPath = "./src/Test/resources/objectRepo/objectmap.properties";
		Properties objPro = loadPropertyFile(objectRepoPath);
		logger = extent.createTest("loginToXero");
		IntializeDriver("firefox");
		driver.get(pro.getProperty("xeroUrl"));
		logger.log(Status.INFO,"xero page opened");
			String TestData = "/Users/ramyarajesh/Documents/work/eclipse/workspace/SeleniumFrameworkTest/src/test/resources/Utility/TestData.xls";
			String[][] data = ReusableMethod.readSheet(TestData, "Sheet1");
			
				
				String excelemailaddress = data[0][1].trim();
				String excelpassword = data[1][1].trim();
				
				WebElement emailaddress = driver.findElement(getLocator("xero.login.emailaddress",objPro));
				enterTextUser(emailaddress, "userName", excelemailaddress);

				WebElement password = driver.findElement(getLocator("xero.login.password",objPro));
				enterTextPswd(password, "Password", excelpassword);
				
				WebElement login = driver.findElement(getLocator("xero.login.login",objPro)) ;
				clickElement(login, "Login Button");

				
			logger.log(Status.PASS, MarkupHelper.createLabel("Firefox browser is Closed...", ExtentColor.GREEN));
			String imagePath=takeScreenShot();
			logger.addScreenCaptureFromPath(imagePath);
			driver.close();
		}
	public static void testCase1() throws Exception{
		String propertyPath = "./src/test/resources/DataFiles/Configuration.properties";
		Properties pro = loadPropertyFile(propertyPath);
		String objectRepoPath = "./src/Test/resources/objectRepo/objectmap.properties0";
		Properties objPro = loadPropertyFile(objectRepoPath);
		logger = extent.createTest("testCase1");
		IntializeDriver("firefox");
		driver.get(pro.getProperty("xeroUrl"));
		logger.log(Status.INFO,"xero page opened");
			
		String TestData = "/Users/ramyarajesh/Documents/work/eclipse/workspace/SeleniumFrameworkTest/src/test/resources/Utility/TestData.xls";
		String[][] data = ReusableMethod.readSheet(TestData, "Sheet1");
		
			
			String excelemailaddress = data[0][1].trim();
				

				WebElement forgot = driver.findElement(getLocator("xero.login.forgot",objPro));
				clickElement(forgot, "forgot Button");
				WebElement emailaddress = driver.findElement(getLocator("xero.forgot.username",objPro));
				enterTextUser(emailaddress, "userName", excelemailaddress);
				
				WebElement login = driver.findElement(getLocator("xero.username.submit",objPro)) ;
				clickElement(login, "Login Button");

				
			logger.log(Status.PASS, MarkupHelper.createLabel("Firefox browser is Closed...", ExtentColor.GREEN));
			String imagePath=takeScreenShot();
			logger.addScreenCaptureFromPath(imagePath);
			driver.close();
		}
	
	
	public static void testCase3() throws Exception{
		String propertyPath = "./src/test/resources/DataFiles/Configuration.properties";
		Properties pro = loadPropertyFile(propertyPath);
		String objectRepoPath = "./src/Test/resources/objectRepo/objectmap.properties2";
		Properties objPro = loadPropertyFile(objectRepoPath);
		logger = extent.createTest("testCase3");
		IntializeDriver("firefox");
		driver.get(pro.getProperty("xeroUrl"));
		logger.log(Status.INFO,"xero page opened");
			String TestData = "/Users/ramyarajesh/Documents/work/eclipse/workspace/SeleniumFrameworkTest/src/test/resources/Utility/TestData.xls";
			String[][] data = ReusableMethod.readSheet(TestData, "Sheet1");
			
				
				String excelemailaddress = data[0][1].trim();
				String excelpassword = data[1][1].trim();
				
				WebElement emailaddress = driver.findElement(getLocator("xero.login.emailaddress",objPro));
				enterTextUser(emailaddress, "userName", excelemailaddress);

				WebElement password = driver.findElement(getLocator("xero.login.password",objPro));
				enterTextPswd(password, "Password", excelpassword);
				
				WebElement login = driver.findElement(getLocator("xero.login.login",objPro)) ;
				clickElement(login, "Login Button");
				
				WebElement dashboard = driver.findElement(getLocator("xero.login.dashboard",objPro));
				clickElement(dashboard, "dashboardButton");
				
				WebElement account = driver.findElement(getLocator("xero.login.account",objPro));
				clickElement(account, "AccountButton");
				WebElement reports = driver.findElement(getLocator("xero.login.reports",objPro));
				clickElement(reports, "ReportButton");
				WebElement contacts = driver.findElement(getLocator("xero.login.contacts",objPro));
				clickElement(contacts, "ReportButton");
				WebElement settings = driver.findElement(getLocator("xero.login.settings",objPro));
				clickElement(settings, "settingsButton");
				WebElement plus = driver.findElement(getLocator("xero.login.plus",objPro));
				clickElement(plus, "PlusButton");
				WebElement files = driver.findElement(getLocator("xero.login.files",objPro));
				clickElement(files, "FilesButton");
				WebElement notification = driver.findElement(getLocator("xero.login.notification",objPro));
				clickElement(notification, "notifyButton");
				WebElement search = driver.findElement(getLocator("xero.login.search",objPro));
				clickElement(search, "searchButton");
				WebElement question = driver.findElement(getLocator("xero.login.question",objPro));
				clickElement(question, "questionButton");
				
			logger.log(Status.PASS, MarkupHelper.createLabel("Firefox browser is Closed...", ExtentColor.GREEN));
			String imagePath=takeScreenShot();
			logger.addScreenCaptureFromPath(imagePath);
	}
	public static void testCase4() throws Exception{
		String propertyPath = "./src/test/resources/DataFiles/Configuration.properties";
		Properties pro = loadPropertyFile(propertyPath);
		String objectRepoPath = "./src/Test/resources/objectRepo/objectmap.properties3";
		Properties objPro = loadPropertyFile(objectRepoPath);
		logger = extent.createTest("testCase4");
		IntializeDriver("firefox");
		driver.get(pro.getProperty("xeroUrl"));
		logger.log(Status.INFO,"xero page opened");
		WebDriverWait wait = new WebDriverWait(driver, 40);
			String TestData = "/Users/ramyarajesh/Documents/work/eclipse/workspace/SeleniumFrameworkTest/src/test/resources/Utility/TestData.xls";
			String[][] data = ReusableMethod.readSheet(TestData, "Sheet1");
			
				
				String excelemailaddress = data[0][1].trim();
				String excelpassword = data[1][1].trim();
				
				WebElement emailaddress = driver.findElement(getLocator("xero.login.emailaddress",objPro));
				enterTextUser(emailaddress, "userName", excelemailaddress);

				WebElement password = driver.findElement(getLocator("xero.login.password",objPro));
				enterTextPswd(password, "Password", excelpassword);
				
				WebElement login = driver.findElement(getLocator("xero.login.login",objPro)) ;
				clickElement(login, "Login Button");
				WebElement users = driver.findElement(getLocator("xero.login.usersbutton",objPro));
				clickElement(users, "users Button");
				WebElement profile = driver.findElement(getLocator("xero.usersbutton.profile",objPro)) ;
				clickElement(profile, "profile Button");
				Thread.sleep(1000);
				WebElement uploadphoto = driver.findElement(getLocator("xero.profile.uploadphoto",objPro));
				clickElement(uploadphoto, "uploadphotoButton");
				WebElement browsephoto = driver.findElement(getLocator("xero.browse.upload",objPro));
				browsephoto.sendKeys("/Users/ramyarajesh/Desktop/rr.png");
				WebElement upload = driver.findElement(getLocator("xero.browse.uploadphoto",objPro));
				clickElement(upload, "uploadphoto");
				
				
			logger.log(Status.PASS, MarkupHelper.createLabel("Firefox browser is Closed...", ExtentColor.GREEN));
			String imagePath=takeScreenShot();
			logger.addScreenCaptureFromPath(imagePath);
			//driver.quit();
		}
	public static void testCase8() throws Exception{
		String propertyPath = "./src/test/resources/DataFiles/Configuration.properties";
		Properties pro = loadPropertyFile(propertyPath);
		String objectRepoPath = "./src/Test/resources/objectRepo/objectmap.properties4";
		Properties objPro = loadPropertyFile(objectRepoPath);
		logger = extent.createTest("loginToXero");
		IntializeDriver("firefox");
		driver.get(pro.getProperty("xeroUrl"));
		logger.log(Status.INFO,"xero page opened");
			String TestData = "/Users/ramyarajesh/Documents/work/eclipse/workspace/SeleniumFrameworkTest/src/test/resources/Utility/TestData.xls";
			String[][] data = ReusableMethod.readSheet(TestData, "Sheet1");
			
				
				String excelemailaddress = data[0][1].trim();
				String excelpassword = data[1][1].trim();
				
				WebElement emailaddress = driver.findElement(getLocator("xero.login.emailaddress",objPro));
				enterTextUser(emailaddress, "userName", excelemailaddress);

				WebElement password = driver.findElement(getLocator("xero.login.password",objPro));
				enterTextPswd(password, "Password", excelpassword);
				
				WebElement login = driver.findElement(getLocator("xero.login.login",objPro)) ;
				clickElement(login, "Login Button");
				
				WebElement self = driver.findElement(getLocator("xero.login.myxero.self",objPro)) ;
				clickElement(self, "self Button");
				Thread.sleep(1000);
				WebElement myxero = driver.findElement(getLocator("xero.login.myxero",objPro)) ;
				clickElement(myxero, "myxero Button");
				
				WebElement addorg = driver.findElement(getLocator("xero.myxero.addorg",objPro)) ;
				clickElement(addorg, "myxeroaddorgButton");
				Thread.sleep(1000);
				WebElement addname = driver.findElement(getLocator("xero.addorg.addname",objPro)) ;
				addname.sendKeys("zero");
				WebElement addtime = driver.findElement(getLocator("xero.addorg.addtime",objPro)) ;
				addtime.sendKeys("(UTC-08:00) Pacific Time (US & Canada)");
				Thread.sleep(1000);
				WebElement addwork = driver.findElement(getLocator("xero.addorg.addwork",objPro)) ;
				addwork.sendKeys("Accounting");
				/*WebElement addwork1 = driver.findElement(getLocator("xero.addorg.addwork1",objPro));
				clickElement(addwork1, "myxeroaddorgButton");*/
				
				WebElement addsoft = driver.findElement(getLocator("xero.addorg.addsoft",objPro)) ;
				clickElement(addsoft, "myxeroaddorgButton");
				WebElement addsoft1 = driver.findElement(getLocator("xero.addorg.addsoft1",objPro));
				clickElement(addsoft1, "myxeroaddorgButton");
			/*	WebElement submit = driver.findElement(getLocator("xero.addorg.submit",objPro));
				clickElement(submit, "myxeroaddorgButton");*/
				WebElement buynow = driver.findElement(getLocator("xero.addorg.buynow",objPro));
				clickElement(buynow, "myxeroaddorgButton");
				WebElement starter = driver.findElement(getLocator("xero.buynow.starter",objPro));
				clickElement(starter, "myxeroaddorgButton");
				WebElement billing = driver.findElement(getLocator("xero.starter.billing",objPro));
				clickElement(billing, "myxeroaddorgButton");
				WebElement address = driver.findElement(getLocator("xero.billing.address",objPro));
				address.sendKeys("3450 Granada Ave");
				WebElement town = driver.findElement(getLocator("xero.billing.town",objPro));
				town.sendKeys("santa clara");
				/*WebElement state = driver.findElement(getLocator("xero.billing.state",objPro));
				Select select = new Select(state);
				select.selectByVisibleText("California");*/
				WebElement zipcode = driver.findElement(getLocator("xero.billing.zipcode",objPro));
				zipcode.sendKeys("95051");
				
				
			logger.log(Status.PASS, MarkupHelper.createLabel("Firefox browser is Closed...", ExtentColor.GREEN));
			String imagePath=takeScreenShot();
			logger.addScreenCaptureFromPath(imagePath);
			driver.close();
		}
	public static void testCase9() throws Exception{
		String propertyPath = "./src/test/resources/DataFiles/Configuration.properties";
		Properties pro = loadPropertyFile(propertyPath);
		String objectRepoPath = "./src/Test/resources/objectRepo/objectmap.properties5";
		Properties objPro = loadPropertyFile(objectRepoPath);
		logger = extent.createTest("loginToXero");
		IntializeDriver("firefox");
		driver.get(pro.getProperty("xeroUrl"));
		logger.log(Status.INFO,"xero page opened");
			String TestData = "/Users/ramyarajesh/Documents/work/eclipse/workspace/SeleniumFrameworkTest/src/test/resources/Utility/TestData.xls";
			String[][] data = ReusableMethod.readSheet(TestData, "Sheet1");
			
				
				String excelemailaddress = data[0][1].trim();
				String excelpassword = data[1][1].trim();
				
				WebElement emailaddress = driver.findElement(getLocator("xero.login.emailaddress",objPro));
				enterTextUser(emailaddress, "userName", excelemailaddress);

				WebElement password = driver.findElement(getLocator("xero.login.password",objPro));
				enterTextPswd(password, "Password", excelpassword);
				
				WebElement login = driver.findElement(getLocator("xero.login.login",objPro)) ;
				clickElement(login, "Login Button");
				
				WebElement self = driver.findElement(getLocator("xero.login.myxero.self",objPro)) ;
				clickElement(self, "self Button");
				Thread.sleep(1000);
				WebElement myxero = driver.findElement(getLocator("xero.login.myxero",objPro)) ;
				clickElement(myxero, "myxero Button");
				Thread.sleep(1000);
				WebElement addorg = driver.findElement(getLocator("xero.myxero.addorg",objPro)) ;
				clickElement(addorg, "myxeroaddorgButton");
				Thread.sleep(1000);
				WebElement addname = driver.findElement(getLocator("xero.addorg.addname",objPro)) ;
				addname.sendKeys("zero");
				WebElement addtime = driver.findElement(getLocator("xero.addorg.addtime",objPro)) ;
				addtime.sendKeys("(UTC-08:00) Pacific Time (US & Canada)");
				Thread.sleep(1000);
				WebElement addwork = driver.findElement(getLocator("xero.addorg.addwork",objPro)) ;
				addwork.sendKeys("Accounting");
				/*WebElement addwork1 = driver.findElement(getLocator("xero.addorg.addwork1",objPro));
				clickElement(addwork1, "myxeroaddorgButton");*/
				
				WebElement addsoft = driver.findElement(getLocator("xero.addorg.addsoft",objPro)) ;
				clickElement(addsoft, "myxeroaddorgButton");
				WebElement addsoft1 = driver.findElement(getLocator("xero.addorg.addsoft1",objPro));
				clickElement(addsoft1, "myxeroaddorgButton");
				/*WebElement submit = driver.findElement(getLocator("xero.addorg.submit",objPro));
				clickElement(submit, "myxeroaddorgButton");*/
				WebElement quick = driver.findElement(getLocator("xero.addorg.quick",objPro)) ;
				clickElement(quick, "myxeroaddorgButton");
				WebElement check = driver.findElement(getLocator("xero.addorg.check",objPro)) ;
				clickElement(check, "myxeroaddorgButton");
				WebElement enter = driver.findElement(getLocator("xero.addorg.enter",objPro)) ;
				clickElement(enter, "myxeroaddorgButton");
				logger.log(Status.PASS, MarkupHelper.createLabel("Firefox browser is Closed...", ExtentColor.GREEN));
				String imagePath=takeScreenShot();
				logger.addScreenCaptureFromPath(imagePath);
				driver.close();
				
	}
	public static void testCase10() throws Exception{
		String propertyPath = "./src/test/resources/DataFiles/Configuration.properties";
		Properties pro = loadPropertyFile(propertyPath);
		String objectRepoPath = "./src/Test/resources/objectRepo/objectmap.properties6";
		Properties objPro = loadPropertyFile(objectRepoPath);
		logger = extent.createTest("loginToXero");
		IntializeDriver("firefox");
		driver.get(pro.getProperty("xeroUrl"));
		logger.log(Status.INFO,"xero page opened");
			String TestData = "/Users/ramyarajesh/Documents/work/eclipse/workspace/SeleniumFrameworkTest/src/test/resources/Utility/TestData.xls";
			String[][] data = ReusableMethod.readSheet(TestData, "Sheet1");
			
				
				String excelemailaddress = data[0][1].trim();
				String excelpassword = data[1][1].trim();
				
				WebElement emailaddress = driver.findElement(getLocator("xero.login.emailaddress",objPro));
				enterTextUser(emailaddress, "userName", excelemailaddress);

				WebElement password = driver.findElement(getLocator("xero.login.password",objPro));
				enterTextPswd(password, "Password", excelpassword);
				
				WebElement login = driver.findElement(getLocator("xero.login.login",objPro)) ;
				clickElement(login, "Login Button");
				WebElement accounts = driver.findElement(getLocator("xero.login.account",objPro)) ;
				clickElement(accounts, "Account Button");
				WebElement purchase = driver.findElement(getLocator("xero.account.purchases",objPro)) ;
				clickElement(purchase, "purchase Button");
			/*	WebElement bill = driver.findElement(getLocator("xero.purchases.new",objPro));
				clickElement(bill, "paid Button");
				WebElement create = driver.findElement(getLocator("xero.new.bill",objPro));
				create.sendKeys("aaa");
				WebElement save = driver.findElement(getLocator("xero.bill.save",objPro));
				clickElement(save, "paid Button");*/
				//Thread.sleep(5000);
				/*WebElement user = driver.findElement(getLocator("xero.login.usersbutton",objPro)) ;
				clickElement(user, "Account Button");*/
				Thread.sleep(1000);
				/*WebElement logout = driver.findElement(getLocator("xero.usersbutton.logout",objPro)) ;
				clickElement(logout, "purchase Button");*/
				WebElement paid = driver.findElement(getLocator("xero.new.paid",objPro)) ;
				clickElement(paid, "purchase Button");
				/*WebElement repeat = driver.findElement(getLocator("xero.new.repeat",objPro)) ;
				clickElement(repeat, "purchase Button");
				WebElement all = driver.findElement(getLocator("xero.new.all",objPro)) ;
				clickElement(all, "purchase Button");*/
				logger.log(Status.PASS, MarkupHelper.createLabel("Firefox browser is Closed...", ExtentColor.GREEN));
				String imagePath=takeScreenShot();
				logger.addScreenCaptureFromPath(imagePath);
				driver.close();
	}
	public static void clickFreeTrail() throws Exception{
		String propertyPath = "./src/test/resources/DataFiles/Configuration.properties1";
		Properties pro = loadPropertyFile(propertyPath);
		String objectRepoPath = "./src/Test/resources/objectRepo/objectmap.properties1";
		Properties objPro = loadPropertyFile(objectRepoPath);
		logger = extent.createTest("clickFreeTrail");
		IntializeDriver("firefox");
		driver.get(pro.getProperty("xeroUrl"));
		logger.log(Status.INFO,"xero page opened");
		WebDriverWait wait = new WebDriverWait(driver, 300);
		String TestData = "/Users/ramyarajesh/Documents/work/eclipse/workspace/SeleniumFrameworkTest/src/test/resources/Utility/TestData1.xls";
		String[][] data = ReusableMethod.readSheet(TestData, "Sheet1");
		
			String firstName = data[0][1].trim();
			String lastName = data[1][1].trim();
			String email = data[2][1].trim();
			String phoneNumber = data[3][1].trim();
			
			WebElement freeTail = driver.findElement(getLocator("xero.login.freeTrail",objPro)) ;
			clickElement(freeTail, "freeTrailButton");
			
			WebElement namefirst = driver.findElement(getLocator("xero.freeTrail.firstName",objPro));
			enterTextUser(namefirst, "FirstName", firstName);
			WebElement namelast = driver.findElement(getLocator("xero.freeTrail.lastName",objPro));
			enterTextUser(namelast, "LastName", lastName);
			WebElement Email = driver.findElement(getLocator("xero.freeTrail.email",objPro));
			enterTextUser(Email, "Email", email);
			WebElement phonenumber = driver.findElement(getLocator("xero.freeTrail.phonenumber",objPro));
			enterTextUser(phonenumber, "PhoneNumber", phoneNumber);
			WebElement Country = driver.findElement(getLocator("xero.freeTrail.country",objPro));
			Select select = new Select(Country);
			select.selectByVisibleText("United States");
			WebElement captcha = driver.findElement(getLocator("xero.freetrail.captcha",objPro));
			driver.switchTo().frame(captcha);
			WebElement image = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(getLocator("xero.captcha.image",objPro))));
			clickElement(image,"getstartedButton");
			//WebElement images = wait.until(ExpectedConditions.elementToBeClickable(clickElement(image, "image")));
			driver.switchTo().defaultContent();
			WebElement checkBox = driver.findElement(getLocator("xero.freetrail.checkBox",objPro));
			clickElement(checkBox, "checkbox");
			
			WebElement getStarted = driver.findElement(getLocator("xero.freeTrail.getStarted",objPro));
			clickElement(getStarted,"getstartedButton");
			logger.log(Status.PASS, MarkupHelper.createLabel("Firefox browser is Closed...", ExtentColor.GREEN));
			String imagePath=takeScreenShot();
			logger.addScreenCaptureFromPath(imagePath);
			//driver.quit();
		}
		
		
		
	}




