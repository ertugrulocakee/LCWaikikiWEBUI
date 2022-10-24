package PageObjectModels;

import org.openqa.selenium.*;

import java.util.List;
import java.util.Random;

public class ClotheDetailPageObjectModel extends  BasePageObjectModel{

    private  By sizeOptionItem = By.xpath("//div[@id='option-size']/a[not(@data-stock = '0')]");
    private  By goToBasketButton = By.id("pd_add_to_cart");

    private  By stockAlert = By.id("evamToolTipTop");

    private  By priceArea = new By.ByCssSelector("div.col-xs-12.price-area");
    private  By advancePriceLabel = new By.ByCssSelector("span.advanced-price");

    private  By regularPriceLabel = new By.ByCssSelector("span.price-regular");

    private  By priceLabel = new By.ByCssSelector("span.price");

    private  By getGoToBasketButtonInPopup = By.xpath("//div[@id='cart-action']/a");

    private By  heightOptionItem = By.xpath("//div[@id='option-height']/a[not(@class = 'disabled')]");

    private  By findSizePopup = By.id("ExploreYourBodyBtn");

    private  By shareCombineButton = By.xpath("/html/body/div[3]/div/div[4]/div[1]/div[2]/div[3]/div/div[1]/div/a");

    private  By exitCombinePageLink = By.xpath("/html/body/div[3]/div/div[4]/div[1]/div[2]/div[4]/div[1]/div[2]/div[1]/div[2]/a");


    public  static String price  = "";

    public ClotheDetailPageObjectModel(WebDriver webDriver) {
        super(webDriver);
    }


    private List<WebElement> getAllSizes(){

       return findAllElements(sizeOptionItem);

    }

    private List<WebElement> getAllHeights(){

        return findAllElements(heightOptionItem);

    }


    private void selectHeight(){

        Random r = new Random();
        int number = r.nextInt(getAllHeights().size());

        getAllHeights().get(number).click();

        averageStop();

    }

    private void selectSize() {

        Random r = new Random();
        int number = r.nextInt(getAllSizes().size());

        getAllSizes().get(number).click();

        averageStop();

    }


    private  void getPrice(){

        try{

            if(findElement(priceArea).findElement(regularPriceLabel).isDisplayed()){

                price = findElement(regularPriceLabel).getText();

            }

        }catch (NoSuchElementException exception){

            try{
                price = findElement(advancePriceLabel).getText();

            }catch (NoSuchElementException e){

                price = findElement(priceLabel).getText();

            }

        }

    }

    private  void  isDisplayedSizeAlert(){

        try{

            if(isDisplayed(findSizePopup)){

                driver.navigate().refresh();

            }

        }catch (NoSuchElementException exception){


            System.out.println("There is not a findBodySize button!");


        }

    }

    private  void isDisplayedStockAlert(){

        try{

            if(isDisplayed(stockAlert)){

                driver.navigate().refresh();

            }

        }catch (NoSuchElementException exception){


            System.out.println("Stock of the clothe is enough.");


        }


    }


    public void selectClotheThenGoToBasket(){

           isDisplayedStockAlert();
           isDisplayedSizeAlert();

            try{


                 if(isDisplayed(shareCombineButton)) {

                       shortStop();

                       select(exitCombinePageLink);

                       longStop();

                       isDisplayedStockAlert();
                       isDisplayedSizeAlert();

                 }

            }catch (NoSuchElementException exception){

                System.out.println("You aren't on Combine Page.");

            }

            selectSize();

            try{

                if(isDisplayed(heightOptionItem)){

                    shortStop();

                    selectHeight();

                }


            }catch (NoSuchElementException exception){

                System.out.println("You don't need to select height!");

            }

            averageScrollDown();
            getPrice();
            select(goToBasketButton);
            averageStop();


            driver.get("https://www.lcwaikiki.com/tr-TR/TR/sepetim");

            longStop();

    }


}
