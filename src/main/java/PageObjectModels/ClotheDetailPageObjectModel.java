package PageObjectModels;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.List;
import java.util.Random;

public class ClotheDetailPageObjectModel extends  BasePageObjectModel{


    private  By sizeOptionItem = By.xpath("/html/body/div[3]/div[1]/div[4]/div[1]/div[2]/div[2]/div[2]/div[1]/div/div[4]/div[2]/div[2]/div/div[1]/div[3]/a");
    private  By goToBasketButton = By.id("pd_add_to_cart");

    private  By stockAlert = By.id("evamToolTipTop");

    private  By priceArea = new By.ByCssSelector("div.col-xs-12.price-area");
    private  By advancePriceLabel = new By.ByCssSelector("span.advanced-price");

    private  By regularPriceLabel = new By.ByCssSelector("span.price-regular");

    private  By getGoToBasketButtonInPopup = By.linkText("Sepete Git");

    private  By shareCombineButton = By.xpath("/html/body/div[3]/div/div[4]/div[1]/div[2]/div[3]/div/div[1]/div/a");

    private  By exitCombinePageLink = By.xpath("/html/body/div[3]/div/div[4]/div[1]/div[2]/div[4]/div[1]/div[2]/div[1]/div[2]/a");


    public  static String price  = "";

    public ClotheDetailPageObjectModel(WebDriver webDriver) {
        super(webDriver);
    }



    private List<WebElement> getAllSizes(){

       List<WebElement> list = findAllElements(sizeOptionItem);

       for(int i=0; i<list.size();i++){

          if(list.get(i).getAttribute("class").equals("disabled")){

                 list.remove(i);

          }

       }

       return  list;

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

                System.out.println(price);
            }

        }catch (NoSuchElementException exception){

            price = findElement(advancePriceLabel).getText();

            System.out.println(price);

        }

    }


    public void selectClotheThenGoToBasket(){

            try{

                if(isDisplayed(stockAlert)){

                    driver.navigate().refresh();

                }

            }catch (NoSuchElementException exception){


                 System.out.println("Stock of the clothe is enough.");


            }

            try{


                 if(isDisplayed(shareCombineButton)) {

                       shortStop();

                       select(exitCombinePageLink);

                       longStop();

                 }

            }catch (NoSuchElementException exception){

                System.out.println("You aren't on Combine Page.");

            }

            selectSize();
            averageScrollDown();
            getPrice();
            select(goToBasketButton);
            averageStop();

            try{

               WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

               wait.until(ExpectedConditions.visibilityOfElementLocated(getGoToBasketButtonInPopup)).click();

            }catch(NoSuchElementException exception){

                 driver.get("https://www.lcwaikiki.com/tr-TR/TR/sepetim");

            }

            longStop();

    }


}
