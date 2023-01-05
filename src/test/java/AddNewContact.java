import models.Contact;
import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewContact extends TestBase{

    @BeforeMethod
    public void preCondition(){
        if(app.getUser().isLogged()){
            app.getUser().pause(3);


        } else {
            app.getUser().openLoginRegistrationForm();
            app.getUser().fillLoginRegistrationForm("abc@def.com", "$Abcdef12345");
            app.getUser().submitLogin();
            app.getUser().pause(3);
        }
    }
    @Test(invocationCount = 5)
    public void addNewContactPositiveTest(Contact contact) {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        Contact contact = Contact.builder()
                .name("John" + i)
                .lastname("Snow" + i)
                .phone("055666777" + i)
                .email("john" + i + "@mail.com")
                .address("Haifa, Herzel, " + i)
                .description("friend")
                .build();

        app.getContact().openContactForm();
        app.getContact().fillContactForm(contact);
        app.getContact().submitContactForm();

        Assert.assertTrue(
                app.getUser().getText(By.xpath("" +
                        "//div[@class='contact-item_card__2SOIM'][last()]//h3")).equals(contact.getPhone())
        );
    }

    @Test
    public void addNewContactPositiveTestOld(){
        app.getUser().click(By.xpath("//a[@href='/add']"));
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        String name = "John" + i;
        String lastname = "Snow" + i;
        String phone = "055666777" + i;
        String email = "john" + i + "@mail.com";
        String address = "Haifa, Herzel, " + i;
        String description = "friend";

        app.getUser().type(By.xpath("//input[1]"), name);
        app.getUser().type(By.xpath("//input[2]"), lastname);
        app.getUser().type(By.xpath("//input[3]"), phone);
        app.getUser().type(By.xpath("//input[4]"), email);
        app.getUser().type(By.xpath("//input[5]"), address);
        app.getUser().type(By.xpath("//input[6]"), description);
        app.getUser().click(By.xpath("//div[@class='add_form__2rsm2']//button"));

        Assert.assertTrue(
                app.getUser().getText(By.xpath("" +
                        "//div[@class='contact-item_card__2SOIM'][last()]//h3")).equals(phone)
        );
    }

//    @AfterMethod

}