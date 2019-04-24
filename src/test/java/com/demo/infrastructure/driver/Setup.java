package com.demo.infrastructure.driver;

import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Setup {

    public static WebDriver driver;

    @Before
    public void setWebDriver() throws Exception {

        String browser = System.getProperty("browser");
        String driverPath = System.getProperty("driverPath");
        System.out.println("Browser Name : "+browser+" getted");
        System.out.println("Path : "+driverPath+" getted");
        if (browser == null) {
            browser = "chrome";
        }
        if(driverPath==null){
        	driverPath = "src/test/resources/chromedriver";
        }
        switch (browser) {
            case "chrome":
            	System.setProperty("webdriver.chrome.driver", driverPath);
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("start-maximized");
                driver = new ChromeDriver(chromeOptions);
                break;
            case "firefox":
            	System.setProperty("webdriver.gecko.driver",driverPath);
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                break;
            case "internetexplorer":
            	System.setProperty("webdriver.ie.driver", driverPath);
            	driver = new InternetExplorerDriver();
            	driver.manage().window().maximize();
            	break;
            default:
                throw new IllegalArgumentException("Browser \"" + browser + "\" isn't supported.");
        }
    }
}
