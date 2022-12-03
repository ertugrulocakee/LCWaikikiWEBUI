package PageObjectModels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageObjectModel extends BasePageObjectModel {


    private By emailInput = By.xpath("//div[@class='input-container']/input");

    private By passwordInput = By.xpath("//div[@class='login-form__password']/child::div/input");

    private By loginButton = By.xpath("//form/button[@class='login-form__button login-form__button--bg-blue']");


    public LoginPageObjectModel(WebDriver webDriver) {
        super(webDriver);
    }


    public  void  login(){

        write(emailInput,"---write your email---");
        shortStop();
        write(passwordInput,"---write your password---");
        shortStop();
        select(loginButton);

        longStop();

    }


}
