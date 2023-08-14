package pages.parallelTestwithLocalDriver.trendyol;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactoryStaticThreadLocal;

public class TrendyolBasePage {


    public void search(String searchWord){
        WebElement textSearch = WebDriverFactoryStaticThreadLocal.getDriver().findElement(By.className("search-bar"));
        textSearch.sendKeys(searchWord + Keys.ENTER);
    }


    public void cart(){
        WebElement cartButton = WebDriverFactoryStaticThreadLocal.getDriver().findElement(By.className("basket-preview-icon"));
        cartButton.click();
    }


}
