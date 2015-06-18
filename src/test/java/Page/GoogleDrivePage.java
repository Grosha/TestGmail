package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class GoogleDrivePage {
    private final WebDriver driver;
    Actions actions;
    public static final String nameNewFolder = "Dinamo Kiev";
    public static final By locatorAirGoogleDrive = By.xpath(".//*[@class='a-Gg-s']");
    public static final By locatorForNameNewFolder = By.xpath("//div[2]/div/input");
    public static final By locatorForAcceptNewFolder = By.name("ok");
    public static final By locatorForDelFoldMouse = By.xpath("//div[text()='Вилучити']");

    public GoogleDrivePage(WebDriver driver) {
        this.driver = driver;
    }

    //checks url Google Drive page
    public void checkUrlGDPage() throws InterruptedException {
        Thread.sleep(500);
        if (!"https://drive.google.com/drive/my-drive".equals(driver.getCurrentUrl())) {
            System.out.println(driver.getCurrentUrl());
            throw new IllegalStateException("This is not the Google Drive page");
        }
    }

    //click right button on mouse on air and choose "Creat new folder"
    public void clickRMAndCreatFolder() {
        WebElement allAir = driver.findElement(GoogleDrivePage.locatorAirGoogleDrive);
        actions = new Actions(driver);
        actions.contextClick(allAir)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ENTER)
                .perform();
    }

    //writing folders name
    public void writeNameNewFolder(String nameFolder) {
        driver.findElement(locatorForNameNewFolder).sendKeys(nameFolder);
    }

    //accept creating folder
    public void acceptingNewFolder() throws InterruptedException {
        driver.findElement(locatorForAcceptNewFolder).click();
        Thread.sleep(1000);
    }

    //Creat new folder
    public void creatNewFolder() throws InterruptedException {
        this.clickRMAndCreatFolder();
        this.writeNameNewFolder(nameNewFolder);
        this.acceptingNewFolder();
    }


    public void deleteNewFolder() throws InterruptedException {
        while (driver.findElements(HomePage.findFolderInGoogleDrive).size() != 0) {
            WebElement newFolder = driver.findElement(HomePage.findFolderInGoogleDrive);
            actions = new Actions(driver);
            actions.contextClick(newFolder).build().perform();
            driver.findElement(locatorForDelFoldMouse).click();
        }
    }
}
