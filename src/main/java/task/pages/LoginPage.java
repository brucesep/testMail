package task.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by alexeya on 27.01.2020.
 */
public class LoginPage {

    private static WebDriver driver;
    private WebDriverWait wait;

    @FindBy(css = ".button2.button2_size_mail-big.button2_theme_mail-white.button2_type_link.HeadBanner-Button.HeadBanner-Button-Enter.with-shadow")
    public static WebElement enterButton;
    @FindBy(name = "login")
    public static WebElement logIn;
    @FindBy(css = ".control.button2.button2_view_classic.button2_size_l.button2_theme_action.button2_width_max.button2_type_submit.passp-form-button")
    public static WebElement enterButtonLogin;
    @FindBy(name = "passwd")
    public static WebElement password;
    @FindBy(css = ".mail-Logo-Service.ns-action")
    public static  WebElement postPage;
    @FindBy(css = ".mail-User-Avatar.mail-User-Avatar_size_42.mail-User-Avatar_header.js-user-picture")
    public static WebElement menuButton;
    @FindBy(linkText = "Выйти из сервисов Яндекса")
    public static WebElement logOutButton;

    public LoginPage(WebDriver driver){
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    public static void enterToPost(String loginName, String passWord){
        WebElement explicitWait = (new WebDriverWait(driver, 30)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".button2.button2_size_mail-big.button2_theme_mail-white.button2_type_link.HeadBanner-Button.HeadBanner-Button-Enter.with-shadow")));
        enterButton.click();
        try{
            logIn.isDisplayed();
        } catch (WebDriverException e){
            System.out.println("Check button locator!");
        }
        logIn.clear();
        logIn.sendKeys(loginName);
        enterButtonLogin.click();
        explicitWait = (new WebDriverWait(driver, 30)).until(ExpectedConditions.visibilityOf(password));
        try{
            password.isDisplayed();
        } catch (WebDriverException e){
            System.out.println("Something goes wrong! Chech button locator or else!");
        }
        password.clear();
        password.sendKeys(passWord);
        enterButtonLogin.click();
    }

    public static void logOut(){
        menuButton.click();
        logOutButton.click();
    }

}
