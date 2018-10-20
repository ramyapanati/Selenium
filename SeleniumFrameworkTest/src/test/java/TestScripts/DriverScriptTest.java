package TestScripts;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.testng.annotations.Test;

public class DriverScriptTest extends AutomationScript{
	
	@Test
	public static void mainMethod() throws IOException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InterruptedException 
	{
		
	String dt_path = "/Users/ramyarajesh/Documents/work/eclipse/workspace/SeleniumFrameworkTest/src/test/resources/Utility/Book6.xls";
		String[][] recdata = ReusableMethod.readSheet(dt_path, "Sheet1");
		String testCase = null;
		executionReport("Sprint10");
		String flag = null;
		for(int i =1;i<recdata.length;i++){
			flag = recdata[i][1];
			if(flag.trim().equalsIgnoreCase("Y")){
				testCase = recdata[i][2];
				Method testScript = AutomationScript.class.getMethod(testCase.trim());
				testScript.invoke(testScript);
			}else
			{
				System.out.println("Row Number "+i+"test case name "+recdata[i][2]+"is not executed");
			}
		
		
		}
		extent.flush();
	}

}
