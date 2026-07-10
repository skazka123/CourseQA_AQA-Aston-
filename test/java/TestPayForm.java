import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        payForm.chooseCancelCookie();
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void testBlock_name() {
        String text_name = payForm.getBlockName();
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
        boolean result = false;
        List<String> imgs = payForm.getNameLogosAndCheckDisplayed();
        for (String img : imgs){
            if (img.contains(str)){
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
        String thisUrl = payForm.searchLinkAboutService();
        String expectedUrl = "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";
        try {
            assertEquals(expectedUrl, thisUrl);
            System.out.println("Найдена ссылка: " + thisUrl);
        } catch (NoSuchElementException e) {
            assertTrue(false, "Ссылка работает неправильно или не работает вовсе");
        }
    }

    @Test
    public void testTextPlaceholder(){
        payForm.selectOption("Услуги связи");

        assertEquals("Номер телефона", payForm.getPlaceholderByID("connection-phone"));
        assertEquals("Сумма", payForm.getPlaceholderByID("connection-sum"));
        assertEquals("E-mail для отправки чека", payForm.getPlaceholderByID("connection-email"));

        payForm.selectOption("Домашний интернет");

        assertEquals("Номер абонента", payForm.getPlaceholderByID("internet-phone"));
        assertEquals("Сумма", payForm.getPlaceholderByID("internet-sum"));
        assertEquals("E-mail для отправки чека", payForm.getPlaceholderByID("internet-email"));

        payForm.selectOption("Рассрочка");

        assertEquals("Номер счета на 44", payForm.getPlaceholderByID("score-instalment"));
        assertEquals("Сумма", payForm.getPlaceholderByID("instalment-sum"));
        assertEquals("E-mail для отправки чека", payForm.getPlaceholderByID("instalment-email"));

        payForm.selectOption("Задолженность");

        assertEquals("Номер счета на 2073", payForm.getPlaceholderByID("score-arrears"));
        assertEquals("Сумма", payForm.getPlaceholderByID("arrears-sum"));
        assertEquals("E-mail для отправки чека", payForm.getPlaceholderByID("arrears-email"));
    }

    @Test
    public void testButtonClick(){
        payForm.putConnectionNumber("297777777");
        payForm.putConnectionSum("100");
        payForm.clickButtonContinue();
        payForm.goToPayFrame();
        WebElement bepaidDiv = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class*='bepaid']")));
        assertTrue(bepaidDiv.isDisplayed());
    }
}