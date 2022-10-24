package Elements;

import PageObjectModels.BasePageObjectModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class SearchBox extends BasePageObjectModel {

    private By searchBox = By.id("search-form__input-field__search-input");
    private By searchButton = new By.ByCssSelector("div.search-form__input-field.search-form__input-field--second-wrap");

    public SearchBox(WebDriver webDriver) {
        super(webDriver);
    }

    public  void search(){

        longStop();

        write(searchBox,"pantolon");

        select(searchButton);

    }

}
