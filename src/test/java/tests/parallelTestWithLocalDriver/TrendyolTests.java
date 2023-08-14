package tests.parallelTestWithLocalDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.parallelTestwithLocalDriver.trendyol.*;
import utilities.WebDriverFactoryStaticThreadLocal;

public class TrendyolTests {

    // trendyola gidin
    // herhangi bir urunu arayin
    // arama sonuclarındaki 2. sayfadaki ilk urune tiklayin
    // sepete ekleyin
    // sepete ekledigniz urunu test ediniz
    private TrendyolBasePage basepage;
    private TrendyolHomePage homePage;
    private TrendyolSearchPage searchPage;
    private TrendyolProductPage productPage;
    private TrendyolCartPage cartPage;

    @BeforeClass
    public void setUp() {
        WebDriverFactoryStaticThreadLocal.setDriver("edge");
        basepage = new TrendyolBasePage();
        homePage = new TrendyolHomePage();
        searchPage = new TrendyolSearchPage();
        productPage = new TrendyolProductPage();
        cartPage = new TrendyolCartPage();
    }


    @Test
    public void test() throws InterruptedException {

        // https://www.trendyol.com a gidilir
        WebDriverFactoryStaticThreadLocal.getDriver().get("https://www.trendyol.com");
        Thread.sleep(2000);

        // herhangi bir urunu arayin
        homePage.akzeptClick();
        basepage.search("elbise");

        // arama sonuclarındaki 2. sayfadaki ilk urune tiklayin


        searchPage.xClose();

        System.out.println("searchPage.products.size() = " + searchPage.products.size()); // 24
        Thread.sleep(4000);
//        int productListSize = searchPage.products.size();
//        if (productListSize > 50) {
//            // products listesinin boyutu 50'den büyükse
//            searchPage.products(50); // Geçerli bir indeksle erişmeye çalışın
//        } else {
//            // Ürün listesi 50 veya daha az ürün içeriyorsa
//            System.out.println("Ürün listesi " + productListSize + " ürün içeriyor.");
//        }
//
//        if (productListSize > 0) {
//            int desiredIndex = Math.min(50, productListSize - 1); // Geçerli bir indeksle erişmeye çalışın
//            searchPage.products(desiredIndex);
//        } else {
//            System.out.println("Ürün listesi boş.");
//        }

        searchPage.products(50);
        Thread.sleep(1000);

        // sepete ekleyin
        productPage.addToCartButton();
        Thread.sleep(1000);

        // sepete ekledigniz urunu test ediniz
        basepage.cart();
        Thread.sleep(1000);

        cartPage.cartList();

//        if (cartPage.checkboxCart.isDisplayed()) {
//            System.out.println("Ürün sepete eklidir");
//        } else System.out.println("ürün isaretli olmadigi icin sepete ekli degil");

    }

    @AfterClass
    public void tearDown() {
        WebDriverFactoryStaticThreadLocal.closeBrowser();
    }
}

