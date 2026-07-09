import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public static void main(String[] args) {
    System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    PayForm payForm = new PayForm(driver);
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.get("https://www.mts.by/");

    //закрываем окно о куках
    WebElement buttonCancelCookie = payForm.searchButtonCookie();
    buttonCancelCookie.click();

    // Шаг 1: получаем элемент
    WebElement block_name = payForm.searchBlockName();
    // Шаг 2: получаем текст
    String actualText = block_name.getText().replaceAll("\\r\\n|\\r|\\n", " ");
    // Шаг 3: выводим для отладки
    System.out.println("Найденный текст: " + actualText);

    //Ищем название логотипов платежных систем
    List<WebElement> imgs = payForm.logos();
    for (WebElement img : imgs){
        if (img.isDisplayed()){
            String name = img.getAttribute("src").replaceFirst(".*/([^/]+)", "$1");
            System.out.println("Найдено отображаемое изображение: " + name);
        }
    }

    //ищем куда ведет ссылка
    WebElement link = payForm.searchLinkAboutService();
    String thisUrl = link.getAttribute("href");
    System.out.println("Адрес ссылки: " + thisUrl);

    //заполнение полей и клик по кнопке продолжить
    WebElement button = payForm.searchButton();
    WebElement numPhone = payForm.searchFieldNumber();
    WebElement sum = payForm.searchFieldSum();
    numPhone.click();
    numPhone.sendKeys("297777777");
    sum.click();
    sum.sendKeys("100");
    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    button.click();
    // Теперь ждём, пока всплывающее окно станет видимым
    WebDriverWait wait = new WebDriverWait(driver, 30);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class*='bepaid']")));
    // Проверяем, что окно действительно отображается
    boolean isDisplayed = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div[class*='bepaid']")))).isDisplayed();

    System.out.println("Всплывающее окно видно: " + isDisplayed);
}

/*
1. Проверить название блока «Онлайн пополнение без комиссии»;

2. Проверить наличие логотипов платёжных систем;

3. Проверить работу ссылки «Подробнее о сервисе»;

4. Заполнить поля и проверить работу кнопки «Продолжить» (проверяем только вариант «Услуги связи», номер для теста 297777777)
*/