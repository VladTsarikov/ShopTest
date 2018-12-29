package framework.webdriver.waitings;

import framework.enums.LogType;
import framework.utils.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

class Condition {

    private static PropertyReader filesProperty = new PropertyReader("files.properties");

    static ExpectedCondition<Boolean> JQueryLoadCondition(){
        int jQueryValue = 0;
        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    String jSCode = FileUtils.readFromFile(new StringBuilder(filesProperty.getProperty("jsCommonFilesPath"))
                            .append(filesProperty.getProperty("jsGetJQueryValueFileName")).toString());
                    return ((Long) ((JavascriptExecutor)driver).executeScript(jSCode) == jQueryValue);
                }
                catch (Exception e) {
                    Logger.log(LogType.DEBUG, e);
                    return true;
                }
            }
        };
        return jQueryLoad;
    }

    static ExpectedCondition<Boolean> JStoLoadCondition() {
        String jSStatus = "complete";
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                String jSCode = FileUtils.readFromFile(new StringBuilder(filesProperty.getProperty("jsCommonFilesPath"))
                        .append(filesProperty.getProperty("jsGetJSStatusFileName")).toString());
                return ((JavascriptExecutor)driver).executeScript(jSCode)
                        .toString().equals(jSStatus);
            }
        };
        return jsLoad;
    }
}