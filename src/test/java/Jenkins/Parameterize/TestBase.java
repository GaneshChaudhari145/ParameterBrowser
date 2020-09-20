package Jenkins.Parameterize;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;



public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static String path;
	
	
	
	public TestBase(){
		try {
			prop = new Properties();
			path=System.getProperty("user.dir");
			FileInputStream ip = new FileInputStream(path+"/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void initialization(){
		//String browserName = prop.getProperty("browser");
		String browserName=System.getProperty("browser");
		path=System.getProperty("user.dir");
		System.out.println(path);
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			 driver=new ChromeDriver();
		}
		else if(browserName.equals("ie")){
			System.setProperty("webdriver.ie.driver", path+"\\drivers\\iedriver\\IEDriverServer.exe");
			 driver=new InternetExplorerDriver();
		}
		else if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		driver.get(prop.getProperty("Url"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}

}
