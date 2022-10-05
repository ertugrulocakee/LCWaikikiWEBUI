package PageObjectModels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class ClothesListObjectModel extends BasePageObjectModel {

    private  By clotheItem = new By.ByCssSelector("div.product-card.product-card--one-of-4");

    private  By showMoreClothesButton = By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[5]/div/div[2]/div[97]/button");

    public ClothesListObjectModel(WebDriver webDriver) {
        super(webDriver);
    }


    public  void showMoreClothes(){

           longScrollDown();
           averageStop();
           select(showMoreClothesButton);
           longStop();
    }


    private List<WebElement> getAllClothes(){

        return findAllElements(clotheItem);

    }


    public void selectClothe() {


        Random r = new Random();
        int number = r.nextInt(getAllClothes().size());

        getAllClothes().get(number).click();

        averageStop();

    }

}
