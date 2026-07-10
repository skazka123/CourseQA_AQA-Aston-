import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public static void main(String[] args) {
    System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    PayForm payForm = new PayForm(driver);
    PayFrame payFrame = new PayFrame(driver);
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.get("https://www.mts.by/");

    //закрываем окно о куках
    payForm.chooseCancelCookie();

    // Шаг 1: получаем текст
    String actualText = payForm.getBlockName();
    // Шаг 2: выводим для отладки
    System.out.println("Найденный текст: " + actualText);

    //Ищем название логотипов платежных систем
    List<String> imgs = payForm.getNameLogosAndCheckDisplayed();
    for (String img : imgs){
            System.out.println("Найдено отображаемое изображение: " + img);
    }

    //ищем куда ведет ссылка
    String url = payForm.searchLinkAboutService();
    System.out.println("Адрес ссылки: " + url);

    //заполнение полей и клик по кнопке продолжить
    payForm.putConnectionNumber("297777777");
    payForm.putConnectionSum("100");
    payForm.clickButtonContinue();
    payFrame.goToPayFrame();

    List<String> logos = payFrame.getNameLogosAndCheckDisplayed();
    for (String img : logos){
        System.out.println("Найдено отображаемое изображение: " + img);
    }

    /*
    // Теперь ждём, пока всплывающее окно станет видимым
    WebDriverWait wait = new WebDriverWait(driver, 30);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class*='bepaid']")));
    // Проверяем, что окно действительно отображается
    boolean isDisplayed = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div[class*='bepaid']")))).isDisplayed();

    System.out.println("Всплывающее окно видно: " + isDisplayed);

     */
}

/*
1. Проверить название блока «Онлайн пополнение без комиссии»;

2. Проверить наличие логотипов платёжных систем;

3. Проверить работу ссылки «Подробнее о сервисе»;

4. Заполнить поля и проверить работу кнопки «Продолжить» (проверяем только вариант «Услуги связи», номер для теста 297777777)
*/