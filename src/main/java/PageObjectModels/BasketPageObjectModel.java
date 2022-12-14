package PageObjectModels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static PageObjectModels.ClotheDetailPageObjectModel.price;

public class BasketPageObjectModel extends  BasePageObjectModel{

    private  By basketPriceLabel = new By.ByCssSelector("span.rd-cart-item-price.mb-15");
    private  By increaseButton = new By.ByCssSelector("a.oq-up.plus");
    private  By numberOfTheClotheLabel = new By.ByCssSelector("input.item-quantity-input.ignored");

    private  By removeAllClothesButton = new By.ByCssSelector("i.fa.fa-trash-o");

    private  By startShoppingButton = new By.ByCssSelector("a.homepage-link.mt-20");

    private  By removePopup = By.xpath("//div[@class='modal-content']/child::div/following-sibling::div/following-sibling::div/div/div/a[@class='inverted-modal-button sc-delete']");


    public BasketPageObjectModel(WebDriver webDriver) {
        super(webDriver);
    }

    public void areSamePrices(){

        String basketPrice = findElement(basketPriceLabel).getText();


        if(basketPrice.equals(price)){

            System.out.println("The prices are same!");

        }else {

            System.out.println("The prices are not same !");

        }

    }


    public void increaseClothe(){

         select(increaseButton);

         longStop();

    }

    public boolean areThereTwoClothes(){

         int value =  Integer.valueOf(findElement(numberOfTheClotheLabel).getAttribute("value"));

         if(value == 2){

             return  true;

         }

         return  false;

    }

    public  void removeClothes(){

        select(removeAllClothesButton);
        averageStop();
        select(removePopup);
        longStop();

    }

    public boolean isBasketEmpty(){

        return isDisplayed(startShoppingButton);

    }


}
