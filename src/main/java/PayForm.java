import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class PayForm {
    private final WebDriver driver;
    private WebDriverWait wait;
    public PayForm(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    By buttonCookieCancelLocator = By.className("cookie__cancel");
    By blockNamePayLocator = By.xpath("//div[@class='pay__wrapper']/h2");
    By logosLocator = By.xpath("//div[@class='pay__partners']//img");
    By linkAboutServiceLocator = By.xpath("//section[@class='pay']//a[contains(text(),'Подробнее о сервисе')]");
    By buttonSelectLocator = By.xpath("//button[@class='select__header']");

    By fieldConnectionNumberLocator = By.id("connection-phone");
    By fieldConnectionSumLocator = By.id("connection-sum");
    By buttonContinueLocator = By.xpath("//button[(text()='Продолжить')]");
    By frameLocator = By.cssSelector("iframe[src*='bepaid']");

    public void chooseCancelCookie(){
        driver.findElement(buttonCookieCancelLocator).click();
    }

    public String getBlockName(){
        return driver.findElement(blockNamePayLocator).getText().replaceAll("\\r\\n|\\r|\\n", " ");
    }

    public List<String> getNameLogosAndCheckDisplayed(){
        List<WebElement> logos = driver.findElements(logosLocator);
        List <String> nameLogos = new ArrayList<>();
        for (WebElement logo : logos){
            if (logo.isDisplayed()){
                String name = logo.getAttribute("src").replaceFirst(".*/([^/]+)", "$1");
                nameLogos.add(name);
            }
        }
        return nameLogos;
    }

    public String searchLinkAboutService(){
        return driver.findElement(linkAboutServiceLocator).getAttribute("href");
    }

    public void putConnectionNumber(String num){
        WebElement field_num = wait.until(ExpectedConditions.elementToBeClickable(fieldConnectionNumberLocator));
        field_num.click();
        field_num.sendKeys(num);
    }

    public void putConnectionSum(String sum){
        WebElement field_sum = wait.until(ExpectedConditions.elementToBeClickable(fieldConnectionSumLocator));
        field_sum.click();
        field_sum.sendKeys(sum);
    }

    public void selectOption(String optionText) {
        WebElement buttonSelect = wait.until(ExpectedConditions.elementToBeClickable(buttonSelectLocator));
        buttonSelect.click();

        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//p[@class='select__option'][contains(text(),'" + optionText + "')]")));
        option.click();
    }

    public String getPlaceholderByID(String idField) {
        return driver.findElement(By.id(idField)).getAttribute("placeholder");
    }

    public void clickButtonContinue(){
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(buttonContinueLocator));
        button.click();
    }

    public void goToPayFrame(){
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
    }
}
