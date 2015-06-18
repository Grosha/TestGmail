import Page.BasePage;
import Page.HomePage;
import Page.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

/**
 * Открыть gmail.
 * Залогиниться в аккаунт (предварительно создан).
 * Проверить, что пользователь залогинился.
 */

public class LoginOnGmailTest {
    WebDriver browser;
    LoginPage loginPage;
    HomePage homePage;

    @BeforeClass
    public void setUp() {
        browser = new FirefoxDriver();
        browser.manage().window().maximize();
        browser.get(BasePage.loginLink);
        homePage = new HomePage(browser);
        loginPage = new LoginPage(browser);
    }

    @Test
    public void testing() throws InterruptedException {

        //open page for authorization in account google
        loginPage.openPageForAoutorization();

        //check, that opens true page
        loginPage.checkTitleLoginPage();

        //loginning to gmail account
        loginPage.loginToGmailAccount(BasePage.login,BasePage.password);

        //open form 'My account'
        homePage.openMenuMyAcc();

        //check my opens name account with text, which consists with login and domain
        loginPage.checkTrueAccount();
    }

    @AfterClass
    public void setDown() throws InterruptedException {
        Thread.sleep(200);
        browser.quit();
    }
}
