import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestPayFrame {
    public static WebDriverWait wait;
    public static WebDriver driver;
    public static final String PAGE_URL = "http://mts.by";
    public static PayForm payForm;
    public static PayFrame payFrame;

    @BeforeAll
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        payForm = new PayForm(driver);
        payFrame = new PayFrame(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(PAGE_URL);
        payForm.chooseCancelCookie();
        wait = new WebDriverWait(driver, 10);
        payForm.putConnectionNumber("297777777");
        payForm.putConnectionSum("100");
        payForm.clickButtonContinue();
        payFrame.goToPayFrame();
    }

    @Test
    public void testSumFrame(){
        try {
            String actualValue = payFrame.getSumOnFrame();
            assertEquals("100.00 BYN", actualValue, "Сумма не совпадает");
            System.out.println("Сумма совпадает: " + payFrame.getSumOnFrame());
        } catch (NoSuchElementException e) {
            assertTrue(false, "Сумма не найдена");
        }
    }

    @Test
    void testPhoneFrame() {
        try {
            String actualValue = payFrame.getNumOnFrame();
            assertEquals("Оплата: Услуги связи Номер:375297777777", actualValue, "Номер не совпадает");
            System.out.println("Номер совпадает: " + actualValue);
        } catch (NoSuchElementException e) {
            assertTrue(false, "Номер не найден");
        }
    }

    @Test
    void testButtonText() {
        try {
            String actualValue = payFrame.getNameButtonPay();
            assertEquals("Оплатить 100.00 BYN", actualValue, "Название кнопки не совпадает");
            System.out.println("Название кнопки совпадает: " + actualValue);
        } catch (NoSuchElementException e) {
            assertTrue(false, "Название кнопки  не найдено");
        }
    }


    @ParameterizedTest
    @ValueSource(strings = {"mastercard-system.svg", "visa-system.svg", "belkart-system.svg", "mir-system-ru.svg", "maestro-system.svg"})
    void payPics(String str) {
        boolean result = false;
        List<String> imgs = payFrame.getNameLogosAndCheckDisplayed();
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
    void testTextPlaceholder() {
        assertEquals("Номер карты", payFrame.getTextNumberCard());
        assertEquals("Срок действия", payFrame.getExpDate());
        assertEquals("CVC", payFrame.getSecretCode());
        assertEquals("Имя и фамилия на карте", payFrame.getNameSecondName());
    }
}
