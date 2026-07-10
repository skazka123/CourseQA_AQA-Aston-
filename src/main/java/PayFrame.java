import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class PayFrame {

    private WebDriver driver;
    private WebDriverWait wait;

    public PayFrame (WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    By frameLocator = By.cssSelector("iframe[src*='bepaid']");
    By sumFrameLocator = By.xpath("//div[@class='pay-description__cost']/span");
    By phoneFrameLocator = By.xpath("//div[@class='pay-description__text']/span[contains(text(),'Номер:')]");
    By buttonPayLocator = By.cssSelector("div.card-page__card button");
    By logosPayLocator = By.cssSelector("div.cards-brands img");
    By numberCardLocator = By.xpath("//*[text()='Номер карты']");
    By expDateLocator = By.xpath("//*[text()='Срок действия']");
    By secretCodeLocator = By.xpath("//*[text()='CVC']");
    By nameSecondNameLocator = By.xpath("//*[text()='Имя и фамилия на карте']");

    public void goToPayFrame(){
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
    }

    public String getSumOnFrame(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(sumFrameLocator)).getText();
    }

    public String getNumOnFrame(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(phoneFrameLocator)).getText();
    }

    public String getNameButtonPay(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(buttonPayLocator)).getText();
    }

    public List<String> getNameLogosAndCheckDisplayed(){
        List<WebElement> logos = driver.findElements(logosPayLocator);
        List <String> nameLogos = new ArrayList<>();
        for (WebElement logo : logos){
            if (logo.isDisplayed()){
                String name = logo.getAttribute("src").replaceFirst(".*/([^/]+)", "$1");
                nameLogos.add(name);
            }
        }
        return nameLogos;
    }

    public String getTextNumberCard(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(numberCardLocator)).getText();
    }

    public String getExpDate(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(expDateLocator)).getText();
    }

    public String getSecretCode(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(secretCodeLocator)).getText();
    }

    public String getNameSecondName(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(nameSecondNameLocator)).getText();
    }

}
