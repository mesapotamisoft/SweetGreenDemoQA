package com.demo.basepage;

import com.demo.infrastructure.driver.Setup;
import com.demo.infrastructure.driver.Wait;
import java.util.regex.Pattern;
import org.openqa.selenium.WebDriver;

public class BasePage {

    protected WebDriver driver;
    protected Wait wait;

    public BasePage() {
        this.driver = Setup.driver;
        this.wait = new Wait(this.driver);
    }
    
    public int getFirstIntegerInString(String content)
    {
        Pattern p = Pattern.compile("\\d+");
        java.util.regex.Matcher m = p.matcher(content);
        
        while(m.find()) {
        	return Integer.parseInt(m.group());
        }
        return 0;
        
    }
}
