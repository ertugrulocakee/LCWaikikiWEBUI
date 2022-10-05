package Elements;

import PageObjectModels.BasePageObjectModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchBox extends BasePageObjectModel {

    private By searchBox = By.xpath("/html/body/div[2]/div/div[1]/header/div[2]/div[2]/form/div/div[1]/input");
    private By searchButton = By.xpath("/html/body/div[2]/div/div[1]/header/div[2]/div[2]/form/div[1]/div[2]/button");

    public SearchBox(WebDriver webDriver) {
        super(webDriver);
    }

    public  void search(){

        write(searchBox,"pantolon");
        select(searchButton);

        averageStop();

    }

}
