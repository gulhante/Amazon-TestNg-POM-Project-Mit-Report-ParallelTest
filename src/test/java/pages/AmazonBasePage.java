package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.Driver;

public class AmazonBasePage {


    // Kategorien-Tab "Computer" auswählen
    public void selectDropDown() {
        WebElement searchDropdown = Driver.getDriver().findElement(By.id("searchDropdownBox"));
        Select select = new Select(searchDropdown);
        select.selectByVisibleText("Computer");
    }

    // Computer-Kategorie ausgewählt und überprüft
    public String selectedCategoryVerify() {
        WebElement searchDropdown = Driver.getDriver().findElement(By.id("searchDropdownBox"));
        return searchDropdown.getText();
    }

    // In die Suchleiste "msi" eingeben und Suche ausführen
    public void searchArea(String searchWord) {
        Driver.getDriver().findElement(By.id("twotabsearchtextbox")).sendKeys(searchWord + Keys.ENTER);
    }


    public void cartClick() {
        Driver.getDriver().findElement(By.className("nav-cart-icon nav-sprite")).click();
    }


    // Login click
    public void loginClick() {
        Driver.getDriver().findElement(By.xpath("//a[@data-nav-role='signin']")).click();
    }



    // Login-Seite wird geöffnet und überprüft
    public WebElement loginVerify() {
        WebElement loginVerify = Driver.getDriver().findElement(By.id("nav-link-accountList-nav-line-1"));
        return loginVerify;
    }


    // Melden Sie sich ab.
    public void abmelden() {
        WebElement abmelden = Driver.getDriver().findElement(By.xpath("//a[@data-nav-role='signin']"));
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(abmelden).perform();
        Driver.getDriver().findElement(By.xpath("//span[.='Abmelden']")).click();
    }
}




