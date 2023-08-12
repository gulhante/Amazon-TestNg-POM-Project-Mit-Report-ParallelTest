package pages;

import org.openqa.selenium.By;
import utilities.Driver;

public class AmazonLoginPage extends AmazonBasePage{

    // Login Email auf der Website
    public void loginEmail(){
        Driver.getDriver().findElement(By.xpath("//input[@type='email']")).sendKeys("xxxxx");
        Driver.getDriver().findElement(By.xpath("//input[@id='continue']")).click();
    }

    // Login Password auf der Website
    public void loginPassword(){
        Driver.getDriver().findElement(By.xpath("//input[@type='password']")).sendKeys("xxxxx*");
    }

    // Anmelden click
    public void login(){
        Driver.getDriver().findElement(By.id("signInSubmit")).click();
    }


    // Überprüfen Sie, ob der Abmeldevorgang abgeschlossen ist.
    public String abmeldenVerify(){
        return Driver.getDriver().findElement(By.xpath("//h1[@class='a-spacing-small']")).getText();
    }
}
