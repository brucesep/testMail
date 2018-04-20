package testing;

import com.sun.org.apache.xpath.internal.SourceTree;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.sql.Driver;
import java.util.List;

/**
 * Created by alexeya on 19.04.2018.
 */



public class HelpMeth {

    private WebDriver driver;

    @FindBy(name = "login")
    WebElement logIn;
    @FindBy(name = "passwd")
    WebElement password;
    @FindBy(xpath = "//span[text()='Войти']")
    WebElement entering;
    @FindBy(css = ".textinput__control")
    WebElement search;
    @FindBy(css = ".button2.button2_view_classic.button2_size_m.button2_theme_normal.button2_pin_brick-round.mail-SearchContainer-Button")
    WebElement searchGo;
    @FindBy(css = ".mail-Message-Sender-Email.mail-ui-HoverLink-Content")
    WebElement authorChek;
    @FindBy(css = ".mail-Message-Toolbar-Subject-Wrapper")
    WebElement themeCheck;
    @FindBy(css = ".mail-Message-Body-Content")
    WebElement bodyCheck;
    @FindBy(css = ".mail-User-Avatar.mail-User-Avatar_size_42.mail-User-Avatar_header.js-user-picture")
    WebElement logOut;
    @FindBy(css = ".b-mail-dropdown__item__content.js-user-dropdown-item")
    WebElement fullOut;
    @FindBy(xpath = "//span[text()='тестовое письмо']")
    WebElement chooseLetter;


    public HelpMeth(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    public void logIn(String login, String pass) {
        logIn.clear();
        logIn.sendKeys(login);
        password.clear();
        password.sendKeys(pass);
        entering.click();
    }
    public  void checkingMail(String author, String theme, String bodyLetter){
        search.click();
        search.sendKeys(author);
        searchGo.click();
        chooseLetter.click();
        String mailUser = authorChek.getText();
        String themeLetter = themeCheck.getText();
        String bodyLet = bodyCheck.getText();
        Assert.assertEquals(author, mailUser);
        Assert.assertEquals(theme, themeLetter);
        Assert.assertEquals(bodyLetter, bodyLet);
    }
    public  void loggingOut(){
        logOut.click();
        fullOut.click();
    }
}
