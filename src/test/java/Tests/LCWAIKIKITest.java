package Tests;

import Elements.SearchBox;
import PageObjectModels.BasketPageObjectModel;
import PageObjectModels.ClotheDetailPageObjectModel;
import PageObjectModels.ClothesListObjectModel;
import PageObjectModels.HomePageObjectModel;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class LCWAIKIKITest extends  BaseTest {

    private HomePageObjectModel homePage;
    private ClothesListObjectModel clothesListPage;

    private ClotheDetailPageObjectModel clotheDetailPage;

    private BasketPageObjectModel basketPage;

    @Test
    @Order(1)
    public void  loginAndSearch(){

        SearchBox searchBox = new SearchBox(driver);

        homePage = new HomePageObjectModel(driver,searchBox);

        homePage.acceptCookies();

        homePage.isOnHomePage();

        homePage.login();

        homePage.isOnHomePage();

        homePage.getSearchBox().search();

    }


    @Test
    @Order(2)
    public  void selectClothe(){

       clothesListPage = new ClothesListObjectModel(driver);

       clothesListPage.showMoreClothes();

       clothesListPage.selectClothe();

    }


    @Test
    @Order(3)
    public  void  addClotheToBasket(){

        clotheDetailPage = new ClotheDetailPageObjectModel(driver);

        clotheDetailPage.selectClotheThenGoToBasket();

    }


    @Test
    @Order(4)
    public  void  goToBasket(){

        basketPage = new BasketPageObjectModel(driver);

        basketPage.areSamePrices();
        basketPage.increaseClothe();
        basketPage.areThereTwoClothes();
        basketPage.removeClothes();
        basketPage.isBasketEmpty();

    }


}
