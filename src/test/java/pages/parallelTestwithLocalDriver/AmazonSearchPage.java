package pages.parallelTestwithLocalDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Driver;
import utilities.WebDriverFactoryStaticThreadLocal;

import java.util.ArrayList;
import java.util.List;

public class AmazonSearchPage extends AmazonBasePage {


    // Die Suchergebnisseite wird geöffnet und überprüft
    public String searchText() {
        WebElement searchText = WebDriverFactoryStaticThreadLocal.getDriver().findElement(By.xpath("//span[@class='a-color-state a-text-bold']"));
       return searchText.getText();
    }


    // Auf die 2. Seite der Suchergebnisse navigieren
    public void seiteZweiClick(){
        WebElement seiteZwei = WebDriverFactoryStaticThreadLocal.getDriver().findElement(By.xpath("//a[@aria-label='Zu Seite 2']"));
        seiteZwei.click();
    }


    // 2. Seite wird geöffnet und überprüft
    public WebElement seiteZweiVerify(){
        WebElement seiteZweiVerify = WebDriverFactoryStaticThreadLocal.getDriver().findElement(By.xpath("//span[@aria-label='Aktuelle Seite, Seite 2']"));
        return seiteZweiVerify;
    }


    // Wählen Sie das zweite Produkt aus
    public WebElement products(){
        List<WebElement> productsList = new ArrayList<>(WebDriverFactoryStaticThreadLocal.getDriver().findElements(By.className("s-image")));
        return productsList.get(1);
    }


    // Das zweite Produkt auf der Seite wird dem Warenkorb hinzugefügt.
    public void addtoCart() {
        WebDriverFactoryStaticThreadLocal.getDriver().findElement(By.xpath("(//input[@id='add-to-cart-button'])[1]")).click();
    }



    // Überprüfen Sie, ob das Produkt zum Warenkorb hinzugefügt wurde.
    public String hinzufugen(){
        return  WebDriverFactoryStaticThreadLocal.getDriver().findElement(By.xpath("//*[@id=\"NATC_SMART_WAGON_CONF_MSG_SUCCESS\"]/span")).getText();
    }


    // Überprüfen Sie, ob die Warenkorbseite geöffnet ist.
    public void einkaufswagwen(){
        WebDriverFactoryStaticThreadLocal.getDriver().findElement(By.xpath("//*[@id='sw-gtc']/span/a")).click();
    }

}
