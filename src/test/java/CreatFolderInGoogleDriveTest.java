import Page.BasePage;
import Page.GoogleDrivePage;
import Page.HomePage;
import Page.LoginPage;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

/**
 * Открыть gmail.
 * Залогиниться в аккаунт (предварительно создан).
 * Перейти на гугл-диск.
 * Создать папку.
 * Проверить, что папка создана.
 * Если все ок - удалить папку, как @AfterTest
 */
public class CreatFolderInGoogleDriveTest {

    private WebDriver browser;
    private Actions actions;
    private LoginPage loginPage;
    private HomePage homePage;
    private BasePage basePage;
    private GoogleDrivePage googleDrivePage;

    @BeforeClass
    public void setUp() {
        browser = new FirefoxDriver();
        browser.manage().window().maximize();
        browser.get(BasePage.loginLink);
        actions = new Actions(browser);
        homePage = new HomePage(browser);
        googleDrivePage = new GoogleDrivePage(browser);
        basePage = new BasePage(browser);
        loginPage = new LoginPage(browser);
    }

    @Test
    public void testing() throws InterruptedException {
        String handle = browser.getWindowHandle();

        //open page for authorization in account google
        loginPage.openPageForAoutorization();

        //check, that opens true page
        loginPage.checkTitleLoginPage();

        //loginning to gmail account
        loginPage.loginToGmailAccount(BasePage.login, BasePage.password);

        //open menu with all googles environment
        homePage.openMenuGoogle();

        //open Googledrive
        homePage.clickGoogleDrive();

        //go to new window
        basePage.goToNewWindow(handle);

        //checks Google Drive page
        googleDrivePage.checkUrlGDPage();

        //Creat new folder
        googleDrivePage.creatNewFolder();
    }

    @AfterClass
    public void setDown() throws InterruptedException {
        //delete folder
        googleDrivePage.deleteNewFolder();

        browser.close();
        browser.quit();
    }
}
