package Base;

import io.appium.java_client.MobileElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author  Burak Sami ŞAD
 * @version 1.0
 * @since   2021-10-29
 */

public class BasePage extends BaseTest{

    private static final Logger logger = LogManager.getLogger(BasePage.class);

    WebDriverWait wait = new WebDriverWait(appiumDriver, 60);

    public void waitForSecond(int x) throws InterruptedException {
        Thread.sleep(1000 * x);
        logger.info(x +"saniye beklenildi");
    }

    public void clickById(By id) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(id)).click();
        logger.info(id + "Elemente tıklanildi");
    }

    public void clickByXpath(By xpath) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath)).click();
        logger.info(xpath+ "Elemente tıklanildi");
    }

    public void check(String check, String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(check)));
        Assert.assertEquals(text, appiumDriver.findElementById(check).getText());
        logger.info("Check page");
    }

    public void checkXpath(String check, String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(check)));
        Assert.assertEquals(text, appiumDriver.findElementByXPath(check).getText());
        logger.info("Check page");
    }

    public void sendKeys(By by, String text) {
        findElement(by).sendKeys(text);
    }

    public MobileElement findElement(By by) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        return appiumDriver.findElement(by);

    }





}
