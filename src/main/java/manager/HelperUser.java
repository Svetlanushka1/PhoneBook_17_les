package manager;

import models.User;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperUser extends HelperBase{

    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void submitLogin(){
        click(By.xpath("//button[1]"));
    }
    public void submitRegistration(){
        click(By.xpath("//button[2]"));
    }

    public boolean isLogged(){
        return isElementPresent(By.xpath("//button"));
    }


    public void login(User user){
        openLoginRegistrationForm();
        fillLoginRegistrationForm(user);
        submitLogin();
        pause(1000);
    }

    public void logout(){
        click(By.xpath("//button"));
    }

    public void openLoginRegistrationForm(){
        click(By.xpath("//a[text()='LOGIN']"));
    }

    public void fillLoginRegistrationForm(String email, String password){
        type(By.xpath("//input[1]"), email);
        type(By.xpath("//input[2]"), password);
    }
    public void fillLoginRegistrationForm(User user){
        type(By.xpath("//input[1]"), user.getEmail());
        type(By.xpath("//input[2]"), user.getPassword());
    }

    public boolean isAlertPresent() {

        Alert alert = new WebDriverWait(wd, 10)
                .until(ExpectedConditions.alertIsPresent());
        if(alert == null){
            return false;
        } else {
            wd.switchTo().alert();
            System.out.println(alert.getText());
            alert.accept(); // for Ok button
            // alert.dismiss() for Cancel button
            // alert.sendKeys() for input data
            return true;
        }
    }

    public boolean isErrorMessageInFormat(){
        Alert alert = new WebDriverWait(wd, 10)
                .until(ExpectedConditions.alertIsPresent());
        String errorMessage = "Wrong email or password";
        return alert.getText().contains(errorMessage);
    }
}
