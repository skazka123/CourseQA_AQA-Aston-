import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.Collections;
import java.util.List;

public class PayForm {
    public WebDriver driver;
    public PayForm(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement searchButtonCookie(){
        return driver.findElement(By.className("cookie__cancel"));
    }

    public WebElement searchBlockName(){
        return driver.findElement(By.xpath("//div[@class=\"pay__wrapper\"]/h2"));
    }

    public List<WebElement> logos(){
        return driver.findElements(By.xpath("//div[@class=\"pay__partners\"]//img"));
    }

    public WebElement searchLinkAboutService(){
        return driver.findElement(By.xpath("//section[@class='pay']//a[contains(text(),'Подробнее о сервисе')]"));
    }

    public WebElement searchFieldNumber(){
        return driver.findElement(By.id("connection-phone"));
    }

    public WebElement searchFieldSum(){
        return driver.findElement(By.id("connection-sum"));
    }

    public WebElement searchButton(){
        return driver.findElement(By.xpath("//button[(text()='Продолжить')]"));
    }

    /*public boolean isDisplayedImg(WebElement payImage, String scr) {
        for (WebElement img : logos) {
            if (img.getAttribute("src").contains(scr)) {
                return img.isDisplayed();
            }
        }
        return false;
    }*/
}
