package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private final WebDriver browser;
    public static final By nameLogin = By.className("gb_E");
    public static final By accountMenu = By.cssSelector(".gb_k");
    public static final By googleDriveLocator = By.xpath("//a[@id='gb49']/span");
    public static final By findFolderInGoogleDrive = By.xpath(".//div[span='Dinamo Kiev']");

    public HomePage(WebDriver browser) {
        this.browser = browser;
    }

    public void openMenuMyAcc() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(browser, 10);
        wait.until(ExpectedConditions.elementToBeClickable(accountMenu));
        browser.findElement(accountMenu).click();
        Thread.sleep(500);
    }

    //open menu with all googles environment
    public void openMenuGoogle() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(browser, 10);
        wait.until(ExpectedConditions.elementToBeClickable(BasePage.menuProjectsGoogle));
        browser.findElement(BasePage.menuProjectsGoogle).click();
    }

    //open Googledrive
    public void clickGoogleDrive(){
        browser.findElement(googleDriveLocator).click();
    }

    public void logOutFromGmAcc(){
        browser.findElement(BasePage.logOutLocator).click();
    }
}
