package Tests;

import Elements.SearchBox;
import PageObjectModels.*;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class LCWAIKIKITest extends  BaseTest {

    private HomePageObjectModel homePage;

    private ClothesListObjectModel clothesListPage;

    private ClotheDetailPageObjectModel clotheDetailPage;

    private BasketPageObjectModel basketPage;

    private LoginPageObjectModel loginPage;

    @Test
    @Order(1)
    public void  loginAndSearch(){

        SearchBox searchBox = new SearchBox(driver);

        homePage = new HomePageObjectModel(driver,searchBox);

        loginPage = new LoginPageObjectModel(driver);

        homePage.acceptCookies();

        homePage.isOnHomePage();

        homePage.login();

        loginPage.login();

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
