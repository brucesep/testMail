package task.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import task.pages.LoginPage;
import task.pages.MailPage;

import java.util.concurrent.TimeUnit;

/**
 * Created by alexeya on 27.01.2020.
 */
public class CheckMailTest {

    WebDriver driver;
    LoginPage loginPage;
    MailPage mailPage;

    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://mail.yandex.ru/");

        loginPage = new LoginPage(driver);
        mailPage = new MailPage(driver);
    }

    @Test
    public void checkMail(){
         loginPage.enterToPost("test.aleksey01", "testpp00--");
        try {
            Assert.assertTrue(loginPage.postPage.isDisplayed());
        } catch (WebDriverException e) {
            System.out.println("Enter failed! Wrong password or login!");
        }
        mailPage.checkMail("test.aleksey01@gmail.com", "тестовое письмо", "текст письма для проверки");
    }

    @AfterTest
    public void logginOut(){
        loginPage.logOut();
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
