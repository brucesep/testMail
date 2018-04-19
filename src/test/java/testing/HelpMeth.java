package testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by alexeya on 19.04.2018.
 */



public class HelpMeth {

    static WebDriver driver = MailingTest.driver;

    static WebElement logIn = driver.findElement(By.name("login"));
    static WebElement password = driver.findElement(By.name("passwd"));
    static WebElement entering = driver.findElement(By.className(".passport-Button-Text"));
    static WebElement logOut = driver.findElement(By.className(".mail-User-Avatar.mail-User-Avatar_size_42.mail-User-Avatar_header.js-user-picture"));
    static WebElement fullOut = driver.findElement(By.className(".b-mail-dropdown__item__content.js-user-dropdown-item"));
    static List<WebElement> elements = driver.findElements(By.xpath("//span[@title='test.aleksey01@gmail.com']"));


    public static void logIn(String login, String pass){

        logIn.clear();
        logIn.sendKeys(login);
        password.clear();
        password.sendKeys(pass);
        entering.click();
    }

    public static void checkingMail(String author, String theme, String bodyLetter){

    }

    public static void loggingOut(){
        logOut.click();
        fullOut.click();
    }
}
