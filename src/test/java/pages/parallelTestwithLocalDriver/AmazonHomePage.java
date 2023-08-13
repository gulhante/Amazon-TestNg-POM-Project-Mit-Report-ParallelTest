package pages.parallelTestwithLocalDriver;

import org.openqa.selenium.By;
import utilities.Driver;
import utilities.WebDriverFactoryStaticThreadLocal;

public class AmazonHomePage extends AmazonBasePage {

    // Cookies akzeptieren
    public void cerezAccept(){
        WebDriverFactoryStaticThreadLocal.getDriver().findElement(By.id("a-autoid-0")).click();
    }


}

