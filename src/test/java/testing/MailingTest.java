package testing;


import org.omg.CORBA.PUBLIC_MEMBER;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

/**
 * Created by alexeya on 19.04.2018.
 */
public class MailingTest {

    static WebDriver driver = new ChromeDriver();

    @BeforeClass
    public static void setUp(){
        System.setProperty("webdriver.chrome.driver", "D:/JAVA/webdrvs/chromedriver.exe");
        driver.get("https://mail.yandex.ru/");
        //WebElement enter = driver.findElement(By.className(".button2.button2_size_mail-big.button2_theme_mail-white button2_type_link.HeadBanner-Button.HeadBanner-Button-Enter.with-shadow"));
        WebElement enter = driver.findElement(By.xpath("//button2__text[text()='Войти'"));
        enter.click();
    }

    @BeforeTest
    public static void logOn(){
        HelpMeth.logIn("test.aleksey01", "testpp00--");    }

    @Test
    public static void checkMail(){
        HelpMeth.checkingMail("Aleksey Testing", "тестовое письмо", "текст письма для проверки");
    }

    @AfterTest
    public static void logout(){
        HelpMeth.loggingOut();
    }

    @AfterClass
    public static void closeDriver(){
        driver.quit();
    }


}
