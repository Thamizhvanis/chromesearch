package chromebing;

import java.util.Collections;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class chrometest {
	
	WebDriver driver;

    @BeforeTest
	public void driversetup() throws Exception {
    	
//	    System.setProperty("webdriver.chrome.driver", "/home/ubuntu/chromedriver");	
		WebDriverManager.chromedriver().setup();
	    
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setAcceptInsecureCerts(true);
		
		ChromeOptions options = new ChromeOptions();

		options.addArguments("--headless");
        options.addArguments("disable-infobars");
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        options.setExperimentalOption("useAutomationExtension", false);

        options.addArguments("--disable-gpu");
        options.addArguments("--disable-extensions");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless");
        options.addArguments("--window-size=1580,1280");

        final HashMap<String, Object> prefs = new HashMap();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);
        
		options.merge(caps);
		
		driver = new ChromeDriver(options);
		driver.get("https://www.bing.com/");
		Thread.sleep(4000);
		
	
    }

	
	@Test
	public void testcase() throws Exception {
			

		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='sb_form_q']")).sendKeys("Intellipaat");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='search_icon']")).click();
		Thread.sleep(2000);
		String actualtitle = driver.getTitle();
		System.out.println("Search result webpage title: " + actualtitle);
	
	}
	
	

}
