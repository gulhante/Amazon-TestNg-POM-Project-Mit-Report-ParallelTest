package pages.parallelTestwithLocalDriver.amazon;

import org.openqa.selenium.By;
import utilities.WebDriverFactoryStaticThreadLocal;

public class AmazonHomePageLocal extends AmazonBasePageLocal {

    // Cookies akzeptieren
    public void cerezAccept(){
        WebDriverFactoryStaticThreadLocal.getDriver().findElement(By.id("a-autoid-0")).click();
    }


}

