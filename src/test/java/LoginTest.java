import models.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase{

    WebDriver wd;

    @BeforeMethod
    public void init(){
        wd = new ChromeDriver();
        //wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/home");
        wd.navigate().to("https://telranedu.web.app/home");

    }

  /*  @Test
    public void loginPositiveTest(){
        // open login/reg form
        WebElement loginBtn = wd.findElement(By.xpath("//a[text()='LOGIN']"));
        loginBtn.click();
        // fill login/reg form
        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys("abc@def.com");

        WebElement passInput = wd.findElement(By.xpath("//input[2]"));
        passInput.click();
        passInput.clear();
        passInput.sendKeys("$Abcdef12345");

        // click on Login button
        wd.findElement(By.xpath("//button[1]")).click();

        // Assert
//        pause(3);
        Assert.assertTrue(wd.findElement(By.cssSelector("div a:last-child"))!=null);

    }*/
    @Test
    public void loginSuccess(){
        User data = new User()
                .withEmail("name851@mail.com")
                    .withPassword("Haifa082022$");

        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(data.getEmail(), data.getPassword());
        app.getUser().submitLogin();
    }

    @AfterMethod
    public void tearDown(){
//        wd.quit();
    }

}
