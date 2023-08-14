package pages.parallelTestwithLocalDriver.trendyol;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactoryStaticThreadLocal;

public class TrendyolProductPage extends TrendyolBasePage {


    public void addToCartButton(){
        WebElement addToCartBttn = WebDriverFactoryStaticThreadLocal.getDriver().findElement(By.xpath("//button[@class='default']"));
        addToCartBttn.click();
    }

}
