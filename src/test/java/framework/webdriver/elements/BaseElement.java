package framework.webdriver.elements;

import framework.enums.LogType;
import framework.utils.FileUtils;
import framework.utils.Logger;
import framework.utils.PropertyReader;
import framework.webdriver.BaseEntity;
import framework.webdriver.Browser;
import framework.webdriver.waitings.Waiting;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static org.testng.Assert.assertTrue;

public class BaseElement extends BaseEntity {

    protected String name;
    protected By locator;
    private static PropertyReader filesProperty = new PropertyReader("files.properties");

    protected BaseElement(final By locator, String name) {
        this.locator = locator;
        this.name = name;
    }

    protected WebElement getElement() {
        return driver.findElement(locator);
    }

    public void click(){
        Waiting.waitForPageIsReady();
        waitingBeforeClick();
        assertIsPresent();
        Logger.log(String.format("Clicking on %s", name));
        getElement().click();
    }

    public void clickAndWait(){
        click();
        Logger.log(String.format("Clicking on %s", name));
        Waiting.waitForPageIsReady();
    }

    public void clickViaJS() {
        Waiting.waitForPageIsReady();
        waitingBeforeClick();
        assertIsPresent();
        Logger.log(String.format("Clicking on %s", name));
        String jSCode = FileUtils.readFromFile(new StringBuilder(filesProperty.getProperty("jsCommonFilesPath"))
                .append(filesProperty.getProperty("jsClickFileName")).toString());
        ((JavascriptExecutor) Browser.getDriver()).executeScript(jSCode, getElement());
    }

    public void clickByActions(){
        Waiting.waitForPageIsReady();
        waitingBeforeClick();
        Logger.log(String.format("Clicking on %s", name));
        new Actions(driver).moveToElement(getElement()).click().build().perform();
    }

    public void moveToElement(){
        Waiting.waitForPageIsReady();
        Waiting.waitFor(ExpectedConditions.visibilityOf(getElement()));
        Waiting.waitFor(ExpectedConditions.presenceOfElementLocated(locator));
        Logger.log(String.format("Moving to %s", name));
        new Actions(driver).moveToElement(getElement()).build().perform();
    }

    public void moveToElementViaJS() {
        Waiting.waitForPageIsReady();
        Waiting.waitFor(ExpectedConditions.visibilityOf(getElement()));
        Waiting.waitFor(ExpectedConditions.presenceOfElementLocated(locator));
        String jSCode = FileUtils.readFromFile(new StringBuilder(filesProperty.getProperty("jsCommonFilesPath"))
                .append(filesProperty.getProperty("jsMoveToElementFileName")).toString());
        ((JavascriptExecutor)driver).executeScript(jSCode, getElement());
    }

    public String getText(){
        Waiting.waitForPageIsReady();
        Waiting.waitFor(ExpectedConditions.visibilityOf(getElement()));
        assertIsPresent();
        Logger.log(String.format("Getting text of %s", name));
        return getElement().getText();
    }

    public String getAttribute(String attributeName){
        assertIsPresent();
        Waiting.waitFor(ExpectedConditions.presenceOfElementLocated(locator));
        Logger.log(String.format("Getting attribute '%s' of %s", attributeName, name));
        return getElement().getAttribute(attributeName);
    }

    public boolean isPresent() {
        boolean status = false;
        try{
            if(getElement().isEnabled()){
                status = true;
            }
        }catch (Exception e){
            Logger.log(LogType.DEBUG,e);
        }
        return status;
    }

    private void waitingBeforeClick(){
        Waiting.waitFor(ExpectedConditions.visibilityOf(getElement()));
        Waiting.waitFor(ExpectedConditions.elementToBeClickable(getElement()));
    }

    private void assertIsPresent(){
        assertTrue(isPresent(),String.format("Element '%s' has not found", name));
    }
}