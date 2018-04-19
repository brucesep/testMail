package testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

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
    static WebElement search = driver.findElement(By.className(".textinput__control"));
    static WebElement searchGo = driver.findElement(By.className(".button2.button2_view_classic.button2_size_m.button2_theme_normal.button2_pin_brick-round mail-SearchContainer-Button"));
    //static WebElement letterChoose = driver.findElement(By.className(".mail-MessageSnippet-Item.mail-MessageSnippet-Item_subject"));
    static WebElement authorChek = driver.findElement(By.className(".mail-Message-Sender-Email.mail-ui-HoverLink-Content"));
    static WebElement themeCheck = driver.findElement(By.className(".mail-Message-Toolbar-Subject-Wrapper"));
    static WebElement bodyChek = driver.findElement(By.className(".mail-Message-Body-Content"));

    public static void logIn(String login, String pass){

        logIn.clear();
        logIn.sendKeys(login);
        password.clear();
        password.sendKeys(pass);
        entering.click();
    }

    public static void checkingMail(String author, String theme, String bodyLetter){
        search.click();
        search.sendKeys(author);
        searchGo.click();
        WebElement chooseLetter = driver.findElement(By.linkText(theme));
        chooseLetter.click();
        //letterChoose.click();
        String mailUser = authorChek.getText();
        String themeLetter = themeCheck.getText();
        String bodyLet = bodyChek.getText();
        Assert.assertEquals(author, mailUser);
        Assert.assertEquals(theme, themeLetter);
        Assert.assertEquals(bodyLetter, bodyLet);
    }


    public static void loggingOut(){
        logOut.click();
        fullOut.click();
    }
}
