package pages.parallelTestwithLocalDriver.trendyol;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactoryStaticThreadLocal;

public class TrendyolHomePage extends TrendyolBasePage {


    public void akzeptClick(){
        WebElement akzeptieren = WebDriverFactoryStaticThreadLocal.getDriver().findElement(By.id("onetrust-accept-btn-handler"));
        akzeptieren.click();
    }
    // test imiz icin gerekli locate ler zaten AmazonBasePage de var
    // home page ile ilgili diger elementler locate edilebilir

}
