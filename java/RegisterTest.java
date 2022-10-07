import com.demo.nopcommerce.Base.BasePage;
import com.demo.nopcommerce.Page.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Properties;

public class RegisterTest {
    WebDriver driver;
    BasePage basePage;
    Properties prop;
    RegisterPage registerPage;
    @BeforeMethod
    public void openBrowser(){
        basePage = new BasePage();
        prop = basePage.initialiseProperties();
        String webEngine = prop.getProperty("browser");
        driver = basePage.initialiseDriver(webEngine);
        driver.get(prop.getProperty("url"));
        registerPage = new RegisterPage(driver);
    }
        @Test
    public void regTest() throws InterruptedException {
        registerPage.clickOnRegisterLink();
        Thread.sleep(5000);
        registerPage.doRegister(prop.getProperty("fName"),prop.getProperty("lName"),prop.getProperty("dob"),prop.getProperty("mob"),prop.getProperty("yob"),prop.getProperty("Email"),prop.getProperty("pwd"),prop.getProperty("cpwd"));
        }
   /* @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }*/
}
