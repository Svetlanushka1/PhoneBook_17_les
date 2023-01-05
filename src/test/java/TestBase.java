import manager.ApplicationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class TestBase {

    public static ApplicationManager app = new ApplicationManager(
            System.getProperty("browser", BrowserType.CHROME));
    //    WebDriver wd;
    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeSuite
    public void setUp() {
        app.init();
    }

    @AfterSuite
    public void tearDown() {
//        app.stop();
    }

//    public void pause(int time){
//        wd.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
//    }
//    public void click(By locator){
//        wd.findElement(locator).click();
//    }

//    public void type(By locator, String text){
//        WebElement element = wd.findElement(locator);
//        element.click();
//        element.clear();
//        element.sendKeys(text);
//    }

//    public void openLoginRegistrationForm(){
//       click(By.xpath("//a[text()='LOGIN']"));
//    }
//
//    public void fillLoginRegistrationForm(String email, String password){
//        type(By.xpath("//input[1]"), email);
//        type(By.xpath("//input[2]"), password);
//    }

//    public void submitLogin(){
//        click(By.xpath("//button[1]"));
//    }
//    public void submitRegistration(){
//        click(By.xpath("//button[2]"));
//    }

//    public boolean isElementPresent(By locator){
//        return wd.findElements(locator).size() > 0;
//    }

//    public boolean isLogged(){
//        return isElementPresent(By.xpath("//button"));
//    }
//
//    public void logout(){
//        click(By.xpath("//button"));
//    }
}

