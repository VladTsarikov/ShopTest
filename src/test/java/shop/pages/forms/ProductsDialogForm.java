package shop.pages.forms;

import framework.webdriver.BaseForm;
import framework.webdriver.elements.*;
import org.openqa.selenium.By;
import shop.enums.ProductsFormMenuItem;

public class ProductsDialogForm extends BaseForm {

    private final static String MAIN_LOCATOR = "//div[contains(@class,'Catalog') and contains(@class,'TableCol')]";
    private final static String FORMAT_PRODUCT_MENU_ITEM_LOCATOR = "//span[contains(@class,'Catalog')]//a[contains(@href,'/%s/')]";

    public ProductsDialogForm() {
        super(By.xpath(MAIN_LOCATOR),"Products Dialog Form");
    }

    public void selectProduct(ProductsFormMenuItem productsFormMenuItem){
        new Label(By.xpath(String.format(FORMAT_PRODUCT_MENU_ITEM_LOCATOR, productsFormMenuItem.getHrefPart()))
                , String.format("Menu Item '%s' Label",productsFormMenuItem.toString())).clickViaJS();
    }
}