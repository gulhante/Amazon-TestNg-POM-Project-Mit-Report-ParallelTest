package pages.parallelTestwithLocalDriver.amazon;

import org.openqa.selenium.By;
import utilities.WebDriverFactoryStaticThreadLocal;

public class AmazonLoginPageLocal extends AmazonBasePageLocal {

    // Login Email auf der Website
    public void loginEmail(){
        WebDriverFactoryStaticThreadLocal.getDriver().findElement(By.xpath("//input[@type='email']")).sendKeys("xxxx");
        WebDriverFactoryStaticThreadLocal.getDriver().findElement(By.xpath("//input[@id='continue']")).click();
    }

    // Login Password auf der Website
    public void loginPassword(){
        WebDriverFactoryStaticThreadLocal.getDriver().findElement(By.xpath("//input[@type='password']")).sendKeys("xxxx");
    }

    // Anmelden click
    public void login(){
        WebDriverFactoryStaticThreadLocal.getDriver().findElement(By.id("signInSubmit")).click();
    }


    // Überprüfen Sie, ob der Abmeldevorgang abgeschlossen ist.
    public String abmeldenVerify(){
        return WebDriverFactoryStaticThreadLocal.getDriver().findElement(By.xpath("//h1[@class='a-spacing-small']")).getText();
    }
}
