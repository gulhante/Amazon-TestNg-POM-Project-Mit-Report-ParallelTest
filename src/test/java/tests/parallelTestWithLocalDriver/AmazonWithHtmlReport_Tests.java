package tests.parallelTestWithLocalDriver;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;
import utilities.BaseTestReport;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.WebDriverFactoryStaticThreadLocal;


public class AmazonWithHtmlReport_Tests extends BaseTestReport {


    AmazonBasePage basePage = new AmazonBasePage();
    AmazonHomePage homePage = new AmazonHomePage();
    AmazonLoginPage loginPage = new AmazonLoginPage();
    AmazonSearchPage searchPage = new AmazonSearchPage();
    AmazonCartPage cartPage = new AmazonCartPage();

    @BeforeClass
    public void setUp() {
        WebDriverFactoryStaticThreadLocal.setDriver();
    }

    // Amazon-Website öffnen https://www.amazon.com/
    @Test(priority = 1)
    public void WebSeiteOffnenTest(){
        extentTest = extentReports.createTest("AmazonProject", "Amazon Webseite login");
        extentTest.info("Amazon-Website öffnen https://www.amazon.com/");
        WebDriverFactoryStaticThreadLocal.getDriver().get(ConfigurationReader.getProperty("amazonUrl"));

        // Startseite wird geöffnet und überprüft
        Assert.assertTrue(WebDriverFactoryStaticThreadLocal.getDriver().getTitle().contains("Amazon"));
        extentTest.pass("WebSeite wurde gestartet");

    }


    // Cookies akzeptieren
    // homePage.cerezAccept();


    // Login auf der Website
    @Test(priority = 2)
    public void loginTest() {
        extentTest.info("Auf die Schaltfläche Anmelden wird klicken");
        basePage.loginClick();
        extentTest.pass("Auf die Schaltfläche Anmelden geklickt");

    }


    // Login Email
    @Test(priority = 3)
    public void loginEmailTest() {
        extentTest.info("E-Mail-Adresse wird eingegeben");
        loginPage.loginEmail();
        extentTest.pass("E-Mail-Adresse wurde eingegeben");

    }


    // Login Password
    @Test(priority = 4)
    public void loginPasswordTest() {
        extentTest.info("Password wird eingegeben");
        loginPage.loginPassword();
        extentTest.pass("Password wurde eingegeben");
    }


    // Anmelden Click
    @Test(priority = 5)
    public void loginClickTest() {
        extentTest.info("Anmelden wird klicken");
        loginPage.login();

        // Login-Seite wird geöffnet und überprüft
        Assert.assertTrue(basePage.loginVerify().getText().contains("Gülhan"));
        extentTest.pass("Login geschafft");
    }



    // Kategorien-Tab "Computer" auswählen
    @Test(priority = 6)
    public void kategorienTest() {
        extentTest.info("Kategorien-Tab \"Computer\" wird ausgewählt");
        basePage.selectDropDown();

        // Computer-Kategorie ausgewählt und überprüft
        Assert.assertTrue(basePage.selectedCategoryVerify().contains("Computer"));
        extentTest.pass("Kategorien-Tab \"Computer\" wurde ausgewählt");
    }



    // In die Suchleiste "msi" eingeben und Suche ausführen
    @Test(priority = 7)
    public void searchTest() {
        extentTest.info("In die Suchleiste \"msi\" eingeben und Suche ausführen");
        basePage.searchArea("msi");

        // Die Suchergebnisseite wird geöffnet und überprüft
        Assert.assertTrue(searchPage.searchText().contains("msi"));
        extentTest.pass("MSI-Produkte aufgelistet");
    }



    // Auf die 2. Seite der Suchergebnisse navigieren
    @Test(priority = 8)
    public void zweiteSeiteClickTest() {
        extentTest.info("Auf die 2. Seite der Suchergebnisse navigieren");
        searchPage.seiteZweiClick();

        // 2. Seite wird geöffnet und überprüft
        Assert.assertTrue(searchPage.seiteZweiVerify().getText().contains("2"));
        extentTest.pass("2. Seite wurde geöffnet");
    }



    // Wählen Sie das zweite Produkt aus
    @Test(priority = 9)
    public void productSelectTest() {
        extentTest.info("Das zweite Product wird ausgewählt");
        searchPage.products().click();
        extentTest.pass("Das zweite Product wurde ausgewählt");
    }



    // Das zweite Produkt auf der Seite wird dem Warenkorb hinzugefügt.
    @Test(priority = 10)
    public void cartAddTest() throws InterruptedException {
        extentTest.info("Das zweite Produkt auf der Seite wird dem Warenkorb hinzugefügt");
        searchPage.addtoCart();
        Thread.sleep(2000);


        // Überprüfen Sie, ob das Produkt zum Warenkorb hinzugefügt wurde.
        Assert.assertTrue(searchPage.hinzufugen().contains("hinzugefügt"));
        extentTest.pass("Das zweite Product wurde dem Warenkorb hinzugefügt");
    }



    // Überprüfen Sie, ob die Warenkorbseite geöffnet ist.
    @Test(priority = 11)
    public void warenkorbOffnenTest()  {
        extentTest.info("warenkorboffnen wird klicken");
        searchPage.einkaufswagwen();
        extentTest.pass("Die Warenkorbseite wurde geöffnet");
    }




    // Die Anzahl der im Warenkorb gekauften {amount} Artikel wurde erhöht
    @Test(priority = 12)
    public void anzahlWarenkorbErhohenTest()  {
        extentTest.info("Die Anzahl der im Warenkorb gekauften {amount} Artikel wird erhöht");
        cartPage.mengeDropDown();

        // Der Betrag im Warenkorb muss als Produktpreis*Betrag angegeben werden.
        System.out.println("Produktstückpreis = " + cartPage.price());
        System.out.println("Warenkorb-Gesamtpreis = " + cartPage.priceSumme());
        Assert.assertEquals(cartPage.price(), cartPage.priceSumme());
        extentTest.pass("Die Anzahl der im Warenkorb gekauften {amount} Artikel wurde erhöht");
    }



    // Das hinzugefügte Produkt wird aus dem Warenkorb gelöscht.
    @Test(priority = 13)
    public void producktDeleteWarenkorbTest() throws Exception {
        WebDriverFactoryStaticThreadLocal.getDriver().navigate().refresh();
        Thread.sleep(3000);
        extentTest.info("Das hinzugefügte Produkt wird aus dem Warenkorb gelöscht");
        cartPage.loschen().click();


        // Es wird geprüft, ob die Löschung erfolgt ist oder nicht.
        Assert.assertTrue(cartPage.loschenVerify().contains("Dein Amazon-Einkaufswagen ist leer."));
        extentTest.pass("Das hinzugefügte Produkt wurde aus dem Warenkorb gelöscht");
    }



    // Melden Sie sich ab.
    @Test(priority = 14)
    public void abmeldenTest() throws Exception {
        extentTest.info("Die Abmeldung wird gemacht");
        basePage.abmelden();
        Thread.sleep(3000);

        // Überprüfen Sie, ob der Abmeldevorgang abgeschlossen ist.
        Assert.assertTrue(loginPage.abmeldenVerify().contains("Anmelden"));
        extentTest.pass("Die Abmeldung wurde gemacht");
    }

    @AfterClass
    public void tearDown() {
        WebDriverFactoryStaticThreadLocal.closeBrowser();
    }
}



