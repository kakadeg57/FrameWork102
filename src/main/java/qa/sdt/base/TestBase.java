package qa.sdt.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() {
		
		prop = new Properties();
		try {
		FileInputStream configfile = new FileInputStream("C:\\Users\\user\\eclipse-workspace\\Automation-Framework-Batch102\\src\\main\\java\\qa\\sdt\\config\\config.properties");
		prop.load(configfile);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void initilization()	
	{
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		}
		else if(browserName.equals("firefox")) {	
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			}
		else if(browserName.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else
		{
			System.out.println("browser is not avaiable");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get(prop.getProperty("website"));	
	}
	
}
