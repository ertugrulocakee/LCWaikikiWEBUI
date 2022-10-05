package PageObjectModels;

import Elements.SearchBox;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageObjectModel extends  BasePageObjectModel{

    private  By acceptCookieButton = By.xpath("/html/body/div[1]/div/button[2]");
    private  By logo = new By.ByCssSelector("a.main-header-logo");
    private  By loginButton = new By.ByCssSelector("a.header-dropdown-toggle");

    private  By emailInput = By.xpath("/html/body/div[2]/div/div[2]/div/div/div/div/form/div[2]/input");

    private  By passwordInput = By.xpath("/html/body/div[2]/div/div[2]/div/div/div/div/form/div[3]/div/input");


    private  SearchBox searchBox;

    public HomePageObjectModel(WebDriver webDriver, SearchBox searchBox) {

        super(webDriver);
        this.searchBox = searchBox;

    }


    public  void acceptCookies(){

        longStop();

        select(acceptCookieButton);

    }

    public  boolean isOnHomePage(){

        return isDisplayed(logo);

    }

    public  void login(){

        select(loginButton);
        averageStop();
        write(emailInput,"Write your Email!");
        write(passwordInput,"Write your Password!");
        enter(passwordInput);
        averageStop();

    }

    public  SearchBox getSearchBox(){

        return  searchBox;

    }

}
