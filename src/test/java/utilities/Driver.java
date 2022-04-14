package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    private static WebDriver driver;

    /**
     *  this method set up WebDriver type
     *  based on provided browser type in
     *  configuration.properties file.
     *  And it will return the WebDriver
     * @return
     */
    public static WebDriver getDriver(){
        String browserType=ConfigReader.getProperty("browser");

        if(driver==null || ((RemoteWebDriver)driver).getSessionId()==null){
            if(browserType.equalsIgnoreCase("chrome")){
                WebDriverManager.chromedriver().setup();
                driver=new ChromeDriver();
            }else if(browserType.equalsIgnoreCase("edge")){
                WebDriverManager.edgedriver().setup();
                driver=new EdgeDriver();
            }else if(browserType.equalsIgnoreCase("ie")){
                WebDriverManager.iedriver().setup();
                driver=new InternetExplorerDriver();
            }else if(browserType.equalsIgnoreCase("firefox")){
                WebDriverManager.firefoxdriver().setup();
                driver=new FirefoxDriver();

            }else{
                throw new RuntimeException("Invalid browser type is provided in properties file");
            }
        }else{
            return driver;
        }
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;

    }
}
