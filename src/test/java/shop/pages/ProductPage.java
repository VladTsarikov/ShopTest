package shop.pages;

import framework.utils.*;
import framework.webdriver.BaseForm;
import framework.webdriver.elements.*;
import org.openqa.selenium.By;
import shop.enums.*;

import java.util.List;

public class ProductPage extends BaseForm {

    private final static String MAIN_LOCATOR = "//div[contains(@class,'ModelList')]";
    private final static String FORMAT_PRODUCT_MAKER_LOCATOR = "//div[contains(@class,'ModelFilter')]//a[contains(@href,'%s')]";
    private final static String FORMAT_ALL_FILTER_VALUES_LOCATOR = "//div[contains(@id,'prof_%s')]//span[contains(@class,'OpenHide') and contains(@class,'hidden')]/preceding-sibling::span";
    private final Label lblFoundProductsCount =  new Label(By.xpath("//div[contains(@class,'WapperPanel')]//div[contains(@class,'CountBlock')]"),"Found Products Count Label");

    public ProductPage() {
        super(By.xpath(MAIN_LOCATOR),"Product Page");
    }

    private void selectMaker(LaptopMaker laptopMaker){
        new CheckBox(By.xpath(String.format(FORMAT_PRODUCT_MAKER_LOCATOR, laptopMaker.getMaker()))
                , String.format("Maker '%s' CheckBox", laptopMaker.toString())).click();
    }

    public void selectMakers(List<LaptopMaker> laptopMakers){
        openAllFilterValues(FilterParameter.MAKER);
        for(LaptopMaker laptopMaker: laptopMakers){
            selectMaker(laptopMaker);
        }
    }

    public int getFoundProductCount(){
        return Integer.parseInt(StringExtension.deleteAllSpaces(RegExpFinder
                .findByRegularExp(lblFoundProductsCount.getText(), RegExp.PRODUCTS_COUNT.getRegExp())));
    }

    private void openAllFilterValues(FilterParameter filterParameter){
        new Label(By.xpath(String.format(FORMAT_ALL_FILTER_VALUES_LOCATOR, filterParameter.getId()))
                ,"More Maker Label").clickByActions();
    }
}