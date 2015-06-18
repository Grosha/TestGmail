import Page.BasePage;
import Page.HomePage;
import Page.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

/**
 * Открыть gmail.
 * Залогиниться в аккаунт (предварительно создан).
 * Вылогиниться.
 * Проверить, что пользователь вышел из своего аккаунта.
 */
public class LogInAndLogOutTest {
    private WebDriver browser;
    private WebDriverWait wait;
    private LoginPage loginPage;
    private HomePage homePage;

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
        loginPage.loginToGmailAccount(BasePage.login, BasePage.password);

        //open form 'My account'
        homePage.openMenuMyAcc();

        //check my opens name account with text, which consists with login and domain
        loginPage.checkTrueAccount();

        //logout (click on button 'quit')
        homePage.logOutFromGmAcc();
    }

    @AfterClass
    public void setDown() throws InterruptedException {
        //checks title login page
        loginPage.checkTitleLoginPage();

        browser.close();
        browser.quit();
    }
}
