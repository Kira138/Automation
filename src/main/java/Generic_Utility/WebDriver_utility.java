package Generic_Utility;


import java.io.File;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.nio.file.Paths;
import java.time.Duration;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriver_utility {

    public void waitForElementInDOM(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    public void waitForPage(WebDriver driver, String partialPageURL) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.urlContains(partialPageURL));
    }

    public void waitForElement(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void swithToWindow(WebDriver driver, String partialWindowTitle) {
        Set<String> set = driver.getWindowHandles();
        for (String wID : set) {
            driver.switchTo().window(wID);
            String currentWindowTitle = driver.getTitle();
            if (currentWindowTitle.contains(partialWindowTitle)) {
                break;
            }
        }
    }

    public void alertAccept(WebDriver driver) {
        driver.switchTo().alert().accept();
    }

    public void alertDismiss(WebDriver driver) {
        driver.switchTo().alert().dismiss();
    }

    public void swithToFrame(WebDriver driver, int index) {
        driver.switchTo().frame(index);
    }

    public void swithToFrame(WebDriver driver, String id_name_attribute) {
        driver.switchTo().frame(id_name_attribute);
    }

    public void select(WebElement element, int index) {
        Select sel = new Select(element);
        sel.selectByIndex(index);
    }

    public void select(WebElement element, String text) {
        Select sel = new Select(element);
        sel.selectByVisibleText(text);
    }

    public void mouseOverOnElement(WebDriver driver, WebElement elemnet) {
        Actions act = new Actions(driver);
        act.moveToElement(elemnet).perform();
    }

    public void rightClickOnElement(WebDriver driver, WebElement elemnet) {
        Actions act = new Actions(driver);
        act.contextClick(elemnet).perform();
    }

    public void passEnterKey(WebDriver driver) {
        Actions act = new Actions(driver);
        act.sendKeys(Keys.ENTER).perform();
    }

    public void moveToElement(WebDriver driver, WebElement ele) {
        Actions act = new Actions(driver);
        act.moveToElement(ele).perform();
    }

    public void maximizeWindow(WebDriver driver) {
        driver.manage().window().maximize();
    }

    // Define takeScreenShot1 method separately after closing the maximizeWindow method
    public static String takeScreenShot1(WebDriver driver, String screenShotName) throws Throwable {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File src = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File dst = new File("./ScreenShots/" + screenShotName + ".png");
        FileUtils.copyFile(src, dst);
        return dst.getAbsolutePath();
    }
}
