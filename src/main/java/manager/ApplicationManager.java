package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

    public class ApplicationManager {
        Logger logger = LoggerFactory.getLogger(ApplicationManager.class);
        WebDriver wd;
        HelperUser user;
        HelperContact contact;

        String browser;

        public ApplicationManager(String browser) {

            this.browser = browser;
        }

        public HelperUser getUser() {

            return user;
        }

        public HelperContact getContact() {

            return contact;
        }

        public void init(){
//        wd = new ChromeDriver();
            if(browser.equals(BrowserType.FIREFOX)){
                wd = new EventFiringWebDriver(new FirefoxDriver());
                logger.info("Tests on FIREFOX");
            } else if(browser.equals(BrowserType.CHROME)){
                wd = new EventFiringWebDriver(new ChromeDriver());
                logger.info("Tests on CHROME");
            }

            wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            wd.navigate().to("https://telranedu.web.app/home");
            user = new HelperUser(wd);
            contact = new HelperContact(wd);
        }
    public void stop() {
//        wd.quit();
    }

}
