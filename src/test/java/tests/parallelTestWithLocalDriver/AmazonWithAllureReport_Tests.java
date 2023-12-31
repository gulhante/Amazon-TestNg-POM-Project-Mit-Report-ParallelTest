package tests.parallelTestWithLocalDriver;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.parallelTestwithLocalDriver.amazon.*;
import utilities.WebDriverFactoryStaticThreadLocal;

import java.time.Duration;


public class AmazonWithAllureReport_Tests {


    AmazonBasePageLocal basePage = new AmazonBasePageLocal();
    AmazonHomePageLocal homePage = new AmazonHomePageLocal();
    AmazonLoginPageLocal loginPage = new AmazonLoginPageLocal();
    AmazonSearchPageLocal searchPage = new AmazonSearchPageLocal();
    AmazonCartPageLocal cartPage = new AmazonCartPageLocal();

    @BeforeClass
    public void setUp() {
        WebDriverFactoryStaticThreadLocal.setDriver("chrome");
        WebDriverFactoryStaticThreadLocal.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverFactoryStaticThreadLocal.getDriver().manage().window().maximize();
    }

    @Description("Amazon-Website öffnen https://www.amazon.com")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 1)
    public void WebSeiteOffnenTest(){
        WebDriverFactoryStaticThreadLocal.getDriver().get("https://www.amazon.com");
        // Startseite wird geöffnet und überprüft
        Assert.assertTrue(WebDriverFactoryStaticThreadLocal.getDriver().getTitle().contains("Amazon"));
    }


    // Cookies akzeptieren
    // homePage.cerezAccept();


    @Description("Login auf der Website")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 2)
    public void loginTest() {
        basePage.loginClick();
    }



    @Description("Login Email")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 3)
    public void loginEmailTest() {
        loginPage.loginEmail();
    }



    @Description("Login Password")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 4)
    public void loginPasswordTest() {
        loginPage.loginPassword();
    }



    @Description("Anmelden Click")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 5)
    public void loginClickTest() {
        loginPage.login();
        // Login-Seite wird geöffnet und überprüft
        Assert.assertTrue(basePage.loginVerify().getText().contains("Gülhan"));
    }



    @Description("Kategorien-Tab \"Computer\" auswählen")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 6)
    public void kategorienTest() {
        basePage.selectDropDown();
        // Computer-Kategorie ausgewählt und überprüft
        Assert.assertTrue(basePage.selectedCategoryVerify().contains("Computer"));
    }



    @Description("In die Suchleiste \"msi\" eingeben und Suche ausführen")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 7)
    public void searchTest() {
        basePage.searchArea("msi");
        // Die Suchergebnisseite wird geöffnet und überprüft
        Assert.assertTrue(searchPage.searchText().contains("msi"));
    }



    @Description("Auf die 2. Seite der Suchergebnisse navigieren")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 8)
    public void zweiteSeiteClickTest() {
        searchPage.seiteZweiClick();
        // 2. Seite wird geöffnet und überprüft
        Assert.assertTrue(searchPage.seiteZweiVerify().getText().contains("2"));
    }



    @Description("Wählen Sie das zweite Produkt aus")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 9)
    public void productSelectTest() {
        searchPage.products().click();
    }




    @Description("Das zweite Produkt auf der Seite wird dem Warenkorb hinzugefügt.")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 10)
    public void cartAddTest() throws InterruptedException {
        searchPage.addtoCart();
        Thread.sleep(2000);
        // Überprüfen Sie, ob das Produkt zum Warenkorb hinzugefügt wurde.
        Assert.assertTrue(searchPage.hinzufugen().contains("hinzugefügt"));
    }




    @Description("Überprüfen Sie, ob die Warenkorbseite geöffnet ist.")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 11)
    public void warenkorbOffnenTest()  {
        searchPage.einkaufswagwen();
    }





    @Description("Die Anzahl der im Warenkorb gekauften {amount} Artikel wurde erhöht")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 12)
    public void anzahlWarenkorbErhohenTest()  {
        cartPage.mengeDropDown();
        // Der Betrag im Warenkorb muss als Produktpreis*Betrag angegeben werden.
        System.out.println("Produktstückpreis = " + cartPage.price());
        System.out.println("Warenkorb-Gesamtpreis = " + cartPage.priceSumme());
        Assert.assertEquals(cartPage.price(), cartPage.priceSumme());
    }




    @Description("Das hinzugefügte Produkt wird aus dem Warenkorb gelöscht.")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 13)
    public void producktDeleteWarenkorbTest() throws Exception {
        WebDriverFactoryStaticThreadLocal.getDriver().navigate().refresh();
        Thread.sleep(3000);
        cartPage.loschen().click();
        // Es wird geprüft, ob die Löschung erfolgt ist oder nicht.
        Assert.assertTrue(cartPage.loschenVerify().contains("Dein Amazon-Einkaufswagen ist leer."));
    }




    @Description("Melden Sie sich ab.")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 14)
    public void abmeldenTest() throws Exception {
        basePage.abmelden();
        Thread.sleep(3000);
        // Überprüfen Sie, ob der Abmeldevorgang abgeschlossen ist.
        Assert.assertTrue(loginPage.abmeldenVerify().contains("Anmelden"));
    }

    @AfterClass
    public void tearDown() {
        WebDriverFactoryStaticThreadLocal.closeBrowser();
    }
}



