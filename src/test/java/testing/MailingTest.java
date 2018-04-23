package testing;


import org.omg.CORBA.PUBLIC_MEMBER;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

/**
 * Created by alexeya on 19.04.2018.
 */
public class MailingTest {

    WebDriver driver;
    HelpMeth helpMeth;

    @BeforeTest
    public  void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        helpMeth = new HelpMeth(driver);

        driver.get("https://mail.yandex.ru/");
        WebElement enter = driver.findElement(By.linkText("Войти"));
        enter.click();
    }

    @Test
    public void logOn() {
        helpMeth.logIn("test.aleksey01", "testpp00--123");
        helpMeth.checkingMail("test.aleksey01@gmail.com", "тестовое письмо", "текст письма для проверки");
        helpMeth.loggingOut();
    }

    @AfterClass
    public void closeDriver(){
        driver.quit();
    }


}
