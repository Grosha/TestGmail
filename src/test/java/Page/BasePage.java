package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {
    public final WebDriver driver;
    public static final String login = "fedmanruin";
    public static final String password = "Hyperion4";
    public static final String email = login + "@gmail.com";

    public static final String loginLink = "https://accounts.google.com/SignUp?service=mail&hl=ru" +
            "_ua&continue=http%3A%2F%2Fmail.google.com%2Fmail%2F%3Fpc%3Dru-ha-emea-ua-bk&utm_campa" +
            "ign=ru&utm_source=ru-ha-emea-ua-bk&utm_medium=ha";

    public static final By loginLocator = By.id("Email");
    public static final By passwordLocator = By.id("Passwd");
    public static final By logOutLocator = By.xpath("//a[@href='https://mail.google.com/mail/logout?hl=uk']");
    public static final By menuProjectsGoogle = By.xpath("//a[@href='http://www.google.com.ua/intl/uk/options/']");

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    //go to new window
    public void goToNewWindow(String handle){
        for (String winHandle : driver.getWindowHandles()) {
            if (winHandle != handle) {
                driver.switchTo().window(winHandle);
                driver.switchTo().activeElement();
            }
        }
    }


}
