package PageObjectModels;

import Elements.SearchBox;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageObjectModel extends  BasePageObjectModel{

    private  By acceptCookieButton = By.xpath("/html/body/div[1]/div/button[2]");
    private  By logo = new By.ByCssSelector("a.main-header-logo");

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



    public  SearchBox getSearchBox(){

        return  searchBox;

    }

}
