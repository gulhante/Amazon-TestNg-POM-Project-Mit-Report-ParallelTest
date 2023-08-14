package pages.parallelTestwithLocalDriver.trendyol;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactoryStaticThreadLocal;

import java.util.List;

public class TrendyolCartPage extends TrendyolBasePage {


    public void cartList() {
        List<WebElement> checkboxCart= WebDriverFactoryStaticThreadLocal.getDriver().findElements(By.id("checkbox-"));
        for (WebElement element : checkboxCart) {
            if(element.isSelected()) {
                System.out.println("ürün sepette eklidir");
                break;
            }   else System.out.println("ürün sepette ekli degildir");     }
    }

//    @FindBy(xpath="//span[@class='checkbox-label active']")
//    public WebElement checkboxCart;
}
