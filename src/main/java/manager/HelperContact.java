package manager;

import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelperContact extends HelperBase {
    public HelperContact(WebDriver wd) {
        super(wd);
    }
    Logger logger = LoggerFactory.getLogger(HelperContact.class);

    public void openContactForm(){
        click(By.xpath("//a[@href='/add']"));
    }

    public void fillContactForm(Contact contact){

        type(By.xpath("//input[1]"), contact.getName());
        type(By.xpath("//input[2]"), contact.getLastname());
        type(By.xpath("//input[3]"), contact.getPhone());
        type(By.xpath("//input[4]"), contact.getEmail());
        type(By.xpath("//input[5]"), contact.getAddress());
        type(By.xpath("//input[6]"), contact.getDescription());

    }

    public void submitContactForm(){
        click(By.xpath("//div[@class='add_form__2rsm2']//button"));
    }

    public void isContactCreated(){

    }

    public int removeOneContact() {
        int countBefore = countOfContacts();
        logger.info("Number of contacts before is " + countBefore);
        String phone = wd.findElement(By.cssSelector(".contact-item_card__2SOIM h3")).getText();
        logger.info("The deleted number is " + phone);
        click(By.cssSelector(".contact-item_card__2SOIM"));
        click(By.xpath("//button[.='Remove']"));
        pause(3000);
        int countAfter = countOfContacts();
        logger.info("Number of contacts after is " + countAfter);

        return countAfter - countBefore;
    }

    private int countOfContacts() {
        return wd.findElements(By.cssSelector(".contact-item_card__2SOIM")).size();
    }
}