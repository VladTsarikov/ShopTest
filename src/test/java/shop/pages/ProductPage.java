package shop.pages;

import framework.utils.*;
import framework.webdriver.BaseForm;
import framework.webdriver.elements.*;
import org.openqa.selenium.By;
import shop.enums.*;

public class ProductPage extends BaseForm {

    private final static String MAIN_LOCATOR = "//div[contains(@class,'ModelList')]";
    private final static String FORMAT_PRODUCT_MAKER_LOCATOR = "//div[contains(@class,'ModelFilter')]//a[contains(@href,'%s')]";
    private final Label lblFoundProductsCount =  new Label(By.xpath("//div[contains(@class,'WapperPanel')]//div[contains(@class,'CountBlock')]"),"Found Products Count Label");

    public ProductPage() {
        super(By.xpath(MAIN_LOCATOR),"Product Page");
    }

    public ProductPage selectMaker(LaptopMaker laptopMaker){
        new CheckBox(By.xpath(String.format(FORMAT_PRODUCT_MAKER_LOCATOR, laptopMaker.getMaker()))
                , String.format("Maker '%s' CheckBox", laptopMaker.toString())).click();
        return this;
    }

    public int getFoundProductCount(){
        return Integer.parseInt(StringExtension.deleteAllSpaces(RegExpFinder
                .findByRegularExp(lblFoundProductsCount.getText(), RegExp.PRODUCTS_COUNT.getRegExp())));
    }
}