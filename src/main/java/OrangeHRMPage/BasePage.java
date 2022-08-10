package OrangeHRMPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BasePage {

    public static WebDriver driver;
    public static Properties prop;
    public static LoginPage loginPage;


    /**
     * Read properties
     */
    public static void properties(){
        try {
            FileInputStream fis = new FileInputStream("src/resources/genericResources.properties");
            prop = new Properties();
            prop.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Browser setup.
     */
    public static void setUp(){
        properties();
        if(prop.getProperty("browser").contains("chrome")) {
            System.setProperty("webdriver.chrome.driver", prop.getProperty("driverPath"));
            driver = new ChromeDriver();
        }else {
//            FirefoxDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }

        driver.get(prop.getProperty("url"));
        driver.manage().timeouts().getImplicitWaitTimeout();
        driver.manage().window().maximize();
        loginPage = PageFactory.initElements(driver, LoginPage.class);
    }

    public static void tearDown(){
        driver.quit();
    }
}
