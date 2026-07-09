import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class TestPayForm {
    public static WebDriverWait wait;
    public static WebDriver driver;
    public static final String PAGE_URL = "http://mts.by";
    public static PayForm payForm;

    @BeforeAll
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        payForm = new PayForm(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(PAGE_URL);
        WebElement buttonCancelCookie = payForm.searchButtonCookie();
        buttonCancelCookie.click();
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void testBlock_name() {
        WebElement block_name = payForm.searchBlockName();
        String text_name = block_name.getText().replaceAll("\\r\\n|\\r|\\n", " ");
        try {
            assertEquals("ОНЛАЙН ПОПОЛНЕНИЕ БЕЗ КОМИССИИ", text_name);
            System.out.println("Найден текст заголовка: " + text_name);
        } catch (NoSuchElementException e) {
            assertTrue(false, "Текст заголовка не найден");
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"visa.svg", "visa-verified.svg", "mastercard.svg", "mastercard-secure.svg", "belkart.svg"})
    public void testPayLogo(String str) {
        List<WebElement> imgs = payForm.logos();
        boolean result = false;
        for (WebElement img : imgs){
            String name = img.getAttribute("src").replaceFirst(".*/([^/]+)", "$1");
            if (name.contains(str) & img.isDisplayed()){
                result = true;
                break;
            }
        }
        try {
            assertTrue(result);
            System.out.println("Картинка " + str + " отображается");
        } catch (NoSuchElementException e) {
            assertTrue(false, "Картинка " + str + " не отображается");
        }
    }

    @Test
    public void testLinkAboutService(){
        WebElement link = payForm.searchLinkAboutService();
        String thisUrl = link.getAttribute("href");
        String expectedUrl = "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";
        try {
            assertEquals(expectedUrl, thisUrl);
            System.out.println("Найдена ссылка: " + thisUrl);
        } catch (NoSuchElementException e) {
            assertTrue(false, "Ссылка работает неправильно или не работает вовсе");
        }
    }

    @Test
    public void testButtonClick(){
        WebElement numPhone = payForm.searchFieldNumber();
        WebElement sum = payForm.searchFieldSum();
        numPhone.click();
        numPhone.sendKeys("297777777");
        sum.click();
        sum.sendKeys("100");
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id='pay-connection']//button")));
        button.click();
        WebElement bepaidDiv = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class*='bepaid']")));
        assertTrue(bepaidDiv.isDisplayed());

    }
}