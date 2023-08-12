package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utilities.ConfigurationReader;
import utilities.Driver;



public class AmazonProject_Test {

    // Amazon-Website öffnen https://www.amazon.com/
    // Startseite wird geöffnet und überprüft
    // Cookies akzeptieren
    // Login auf der Website
    // Login-Seite wird geöffnet und überprüft
    // Kategorien-Tab "Bilgisayar" auswählen
    // Computer-Kategorie ausgewählt und überprüft
    // In die Suchleiste "msi" eingeben und Suche ausführen
    // Die Suchergebnisseite wird geöffnet und überprüft
    // Auf die 2. Seite der Suchergebnisse navigieren
    // 2. Seite wird geöffnet und überprüft
    // Das dritte Produkt auf der Seite wird dem Warenkorb hinzugefügt.
    // Überprüfen Sie, ob das Produkt zum Warenkorb hinzugefügt wurde.
    // Überprüfen Sie, ob die Warenkorbseite geöffnet ist.
    // Die Anzahl der im Warenkorb gekauften {amount} Artikel wurde erhöht
    // Der Betrag im Warenkorb muss als Produktpreis*Betrag angegeben werden.
    // Das hinzugefügte Produkt wird aus dem Warenkorb gelöscht.
    // Es wird geprüft, ob die Löschung erfolgt ist oder nicht.
    // Melden Sie sich ab.
    // Überprüfen Sie, ob der Abmeldevorgang abgeschlossen ist.

    @Description("AmazonProject")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void test() throws InterruptedException {


        AmazonBasePage basePage = new AmazonBasePage();
        AmazonHomePage homePage = new AmazonHomePage();
        AmazonLoginPage loginPage = new AmazonLoginPage();
        AmazonSearchPage searchPage = new AmazonSearchPage();
        AmazonCartPage cartPage = new AmazonCartPage();


        // Amazon-Website öffnen https://www.amazon.com/
        Driver.getDriver().get(ConfigurationReader.getProperty("amazonUrl"));


        // Startseite wird geöffnet und überprüft
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Amazon"));

        // Cookies akzeptieren
        // homePage.cerezAccept();

        // Login auf der Website
        basePage.loginClick();

        // Login Email
        loginPage.loginEmail();


        // Login password
        loginPage.loginPassword();


        // Login click
        loginPage.login();

        // Login-Seite wird geöffnet und überprüft
        Assert.assertTrue(basePage.loginVerify().getText().contains("Gülhan"));

        // Kategorien-Tab "Computer" auswählen
        basePage.selectDropDown();

        // Computer-Kategorie ausgewählt und überprüft
        Assert.assertTrue(basePage.selectedCategoryVerify().contains("Computer"));

        // In die Suchleiste "msi" eingeben und Suche ausführen
        basePage.searchArea("msi");

        // Die Suchergebnisseite wird geöffnet und überprüft
        Assert.assertTrue(searchPage.searchText().contains("msi"));

        // Auf die 2. Seite der Suchergebnisse navigieren
        searchPage.seiteZweiClick();

        // 2. Seite wird geöffnet und überprüft
        Assert.assertTrue(searchPage.seiteZweiVerify().getText().contains("2"));

        // Wählen Sie das zweite Produkt aus
        searchPage.products().click();

        // Das zweite Produkt auf der Seite wird dem Warenkorb hinzugefügt.
        searchPage.addtoCart();
        Thread.sleep(2000);

        // Überprüfen Sie, ob das Produkt zum Warenkorb hinzugefügt wurde.
        Assert.assertTrue(searchPage.hinzufugen().contains("hinzugefügt"));

        // Überprüfen Sie, ob die Warenkorbseite geöffnet ist.
        searchPage.einkaufswagwen();

        // Die Anzahl der im Warenkorb gekauften {amount} Artikel wurde erhöht
        cartPage.mengeDropDown();

        // Der Betrag im Warenkorb muss als Produktpreis*Betrag angegeben werden.
        System.out.println("Produktstückpreis = " + cartPage.price());
        System.out.println("Warenkorb-Gesamtpreis = " + cartPage.priceSumme());
        Assert.assertEquals(cartPage.price(), cartPage.priceSumme());

        // Das hinzugefügte Produkt wird aus dem Warenkorb gelöscht.
        Driver.getDriver().navigate().refresh();
        Thread.sleep(3000);
        cartPage.loschen().click();

        // Es wird geprüft, ob die Löschung erfolgt ist oder nicht.
        Assert.assertTrue(cartPage.loschenVerify().contains("Dein Amazon-Einkaufswagen ist leer."));

        // Melden Sie sich ab.
        basePage.abmelden();
        Thread.sleep(3000);

        // Überprüfen Sie, ob der Abmeldevorgang abgeschlossen ist.
        Assert.assertTrue(loginPage.abmeldenVerify().contains("Anmelden"));

        Driver.closeDriver();
    }
}



