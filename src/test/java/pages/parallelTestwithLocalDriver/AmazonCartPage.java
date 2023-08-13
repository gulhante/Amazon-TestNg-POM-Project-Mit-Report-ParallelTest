package pages.parallelTestwithLocalDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.Driver;

public class AmazonCartPage extends AmazonBasePage {


    // Die Anzahl der im Warenkorb gekauften {amount} Artikel wurde erhöht
    public void mengeDropDown() {
        WebElement mengeDropdown = Driver.getDriver().findElement(By.id("quantity"));
        Select select = new Select(mengeDropdown);
        select.selectByVisibleText("3");
    }


    // Der Betrag im Warenkorb muss als Produktpreis*Betrag angegeben werden.
    public double price(){
        WebElement productPrice = Driver.getDriver().findElement(By.xpath("//div[@class='sc-badge-price-to-pay']"));
        String pp = productPrice.getText().replace("$", "").replace(" ", "").replace(",", ".");
        return Double.parseDouble(pp);
    }


    // Der Betrag im Warenkorb muss als Produktpreis*Betrag angegeben werden.
    public double priceSumme(){
        WebElement productPriceSumme = Driver.getDriver().findElement(By.xpath("//*[@id='sc-subtotal-amount-activecart']/span"));
        String ppS = productPriceSumme.getText().replace("$", "").replace(" ", "").replace(",", ".");
        return Double.parseDouble(ppS);
    }


    // Das hinzugefügte Produkt wird aus dem Warenkorb gelöscht.
    public WebElement loschen(){
       return Driver.getDriver().findElement(By.xpath("//input[@value='Löschen']"));
    }


    // Es wird geprüft, ob die Löschung erfolgt ist oder nicht.
    public String loschenVerify(){
        return Driver.getDriver().findElement(By.xpath("//h1[@class='a-spacing-mini a-spacing-top-base']")).getText();
    }
}
