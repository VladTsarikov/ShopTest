package shop.pages;

import framework.webdriver.BaseForm;
import framework.webdriver.elements.*;
import shop.enums.*;
import org.openqa.selenium.By;

public class MainPage extends BaseForm {

    private final static String MAIN_LOCATOR = "//div[contains(@class,'SetTile') and contains(@class,'Home')]";
    private final static String FORMAT_PRODUCT_MENU_ITEM_LOCATOR = "//span[contains(@class,'Catalog')]//a[@href='/%s/']";

    public MainPage() { super(By.xpath(MAIN_LOCATOR),"Main Page"); }

    public void navigateToProductTypeMenuItem(ProductTypeMenuItem productTypeMenuItem){
        new Label(By.xpath(String.format(FORMAT_PRODUCT_MENU_ITEM_LOCATOR,productTypeMenuItem.getHrefPart()))
                ,String.format("Menu Item '%s' Label",productTypeMenuItem.toString())).moveToElementViaJS();
    }
}