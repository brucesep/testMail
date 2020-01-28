package task.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * Created by alexeya on 27.01.2020.
 */
public class MailPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(css = ".textinput__control")
    public static WebElement search;
    @FindBy(css = ".control.button2.button2_view_default.button2_tone_mail-suggest-themed.button2_size_n.button2_theme_normal.button2_pin_clear-round.button2_type_submit.search-input__form-button")
    public static WebElement searchGo;
    @FindBy(css = ".mail-MessageSnippet-FromText")
    public static WebElement authorChek;
//    @FindBy(css = ".mail-MessageSnippet-Item.mail-MessageSnippet-Item_sender.js-message-snippet-sender")
//    public static WebElement mailbox;
    @FindBy(css = ".mail-MessageSnippet-Item.mail-MessageSnippet-Item_subject")
    public static WebElement themeCheck;
    @FindBy(css = ".mail-MessageSnippet-Item.mail-MessageSnippet-Item_firstline.js-message-snippet-firstline")
    public static WebElement bodyCheck;
    @FindBy(css = ".mail-MessagesSearchInfo.js-messages-header")
    public static WebElement searchresults;



    public MailPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void checkMail(String author, String theme, String bodyLetter){
        //WebElement explicitwait = (new WebDriverWait(driver, 30)).until(ExpectedConditions.visibilityOf(search));
        search.click();
        search.sendKeys(author);
        searchGo.click();
        WebElement explicitwait = (new WebDriverWait(driver, 30)).until(ExpectedConditions.visibilityOf(searchresults));
        try{
            Assert.assertEquals((authorChek.getAttribute("title")), author);
        } catch (WebDriverException e){
            System.out.println("No matches found!");
        }
        String mailUser = authorChek.getAttribute("title");
        String themeLetter = themeCheck.getText();
        String bodyLet = bodyCheck.getText();
        try{
            Assert.assertEquals(author, mailUser);
        } catch (WebDriverException exc1){
            System.out.println("No matches in author!");
        }
        try {
            Assert.assertEquals(theme, themeLetter);
        } catch (WebDriverException exc2){
            System.out.println("No matches in theme!");
        }
        try{
            Assert.assertEquals(bodyLetter, bodyLet);
        } catch (WebDriverException exc3){
            System.out.println("No matches in bodyletter!");
        }

    }

}
