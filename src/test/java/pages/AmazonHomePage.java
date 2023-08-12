package pages;

import org.openqa.selenium.By;
import utilities.Driver;

public class AmazonHomePage extends AmazonBasePage {

    // Cookies akzeptieren
    public void cerezAccept(){
        Driver.getDriver().findElement(By.id("a-autoid-0")).click();
    }


}

