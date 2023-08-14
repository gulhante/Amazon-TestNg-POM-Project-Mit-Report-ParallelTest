package pages.parallelTestwithLocalDriver.trendyol;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.WebDriverFactoryStaticThreadLocal;

import java.util.List;

public class TrendyolSearchPage extends TrendyolBasePage {

    public TrendyolSearchPage() {
        PageFactory.initElements(WebDriverFactoryStaticThreadLocal.getDriver(), this);
    }

    @FindBy(className = "close")
    public WebElement xClose;

    public void xClose(){
        xClose.click();
    }


    @FindBy(xpath="//div[@class ='product']")  // //img[@class='s-image']
    public List<WebElement> products;


    JavascriptExecutor jsexecutor;

    public void products(int index) throws InterruptedException {
        // burada her 24. ü üründen sonra sayfanin yenilenmesi icin biraz bekleniyor ve
        // her sayfa her seferinde 24 ürün icerdigi icin diger sayfalara döngü ile ulasaabilmek icin size 24 arttiriliyor
        int x = products.size();
        for (int i = 0; i < x ; i++) {
            if (index<x) {
                jsexecutor = (JavascriptExecutor) WebDriverFactoryStaticThreadLocal.getDriver();
                jsexecutor.executeScript("arguments[0].scrollIntoView(true);", products.get(index));
                products.get(index).click();break;
            } else {
                jsexecutor = (JavascriptExecutor) WebDriverFactoryStaticThreadLocal.getDriver();
                jsexecutor.executeScript("arguments[0].scrollIntoView(true);", products.get(products.size() - 1));

                Thread.sleep(3000);
                x += 24;
            }
        }

    }

}
