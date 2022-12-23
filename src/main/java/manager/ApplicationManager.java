package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApplicationManager {
    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);

    WebDriver wd;
    HelperUser user;

    public HelperUser getUser() {
        return user;
    }

    public void init() {
        wd = new ChromeDriver();
        wd.navigate().to("https://telranedu.web.app/home");
        user = new HelperUser(wd);
        //contact = new HelperContact(wd);
    }
/*
    public class HelperUser getUser(){
        return user;

    }
    public class HelperContact getContact(){
        return contact;
    }*/
    public void stop() {
//        wd.quit();
    }

}
