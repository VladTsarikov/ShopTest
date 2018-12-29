package shop.pages.forms;

import framework.utils.StringExtension;
import framework.webdriver.BaseForm;
import framework.webdriver.elements.*;
import org.openqa.selenium.By;

public class ProductsCountDialogForm extends BaseForm {

    private final static String MAIN_LOCATOR = "//div[@role='dialog' and contains(@class,'ModelFilter')]";
    private final Button btnShow =  new Button(By.xpath("//div[contains(@class,'NumModelBtn')]"),"Show Products Button");
    private final Label lblProductsCount =  new Label(By.id("count_item"),"Products Count Label");

    public ProductsCountDialogForm() {
        super(By.xpath(MAIN_LOCATOR),"Products Count Dialog Form");
    }

    public void clickShowProductsButton(){
        btnShow.click();
    }

    public int getProductsCount(){
        return Integer.parseInt(StringExtension.deleteAllSpaces(lblProductsCount.getText()));
    }
}