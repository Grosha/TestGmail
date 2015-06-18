package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPage {
    private final WebDriver browser;

    public static final By btnGoToLogIn = By.id("link-signin");
    public static final By btnGoToPasswPage = By.id("next");
    public static final By btnAuthorization = By.id("signIn");
    public static final By checkButtonAlwaysStayLogin = By.id("PersistentCookie");

    public LoginPage(WebDriver browser) {
        this.browser = browser;
    }

    //checks title login page
    public void checkTitleLoginPage() throws InterruptedException {
        Thread.sleep(300);
        if (!"Gmail".equals(browser.getTitle())){
            throw new IllegalStateException("This is not the login page");
        }
    }

    //enter login
    public void typeUserName(String username){
        browser.findElement(BasePage.loginLocator).sendKeys(username);
    }

    //enter password
    public void typePassword(String passsword){
        browser.findElement(BasePage.passwordLocator).sendKeys(passsword);
    }

    //have taken tick - always remain in the system
    public void stayAlwaysLogIn(By checkButtonLocator){
        WebElement persistentCookie = browser.findElement(checkButtonLocator);
        if (persistentCookie.isSelected()) persistentCookie.click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //loginning to gmail account
    public void loginToGmailAccount(String strLogin,String strPassword) throws InterruptedException {
        //enter login
        typeUserName(strLogin);

        //go to password page
        browser.findElement(btnGoToPasswPage).click();
        Thread.sleep(500);

        //enter password
        typePassword(strPassword);

        //have taken tick - always remain in the system
        stayAlwaysLogIn(checkButtonAlwaysStayLogin);

        //authorization
        browser.findElement(btnAuthorization).click();
    }

    //open page for authorization in account google
    public void openPageForAoutorization(){
        browser.findElement(btnGoToLogIn).click();
    }

    //check that it is true account
    public void checkTrueAccount(){
        Assert.assertEquals(browser.findElement(HomePage.nameLogin).getText(), BasePage.email);
    }
}
