package shop.tests;

import framework.utils.Logger;
import framework.webdriver.BaseEntity;
import org.testng.Assert;
import org.testng.annotations.Test;
import shop.enums.*;
import shop.pages.*;
import shop.pages.forms.*;

public class ShopTest extends BaseEntity {

    @Test
    public void shopTest(){
        Logger.logStep(1,"OPENING SHOP.BY AND MOVING TO COMPUTERS MENU ITEM...");
        new MainPage().navigateToProductTypeMenuItem(ProductTypeMenuItem.COMPUTERS);

        Logger.logStep(2,"SELECTING LAPTOPS MENU ITEM IN COMPUTERS DIALOG FORM...");
        new ProductsDialogForm().selectProduct(ProductsFormMenuItem.LAPTOPS);

        Logger.logStep(3,"SORTING BY HP AND DELL MAKERS...");
        new ProductPage()
                .selectMaker(LaptopMaker.DELL)
                .selectMaker(LaptopMaker.HP);

        Logger.logStep(4,"SAVING RESULTS COUNT IN APPEARING DIALOG FORM AND CLICK SHOW BUTTON...");
        ProductsCountDialogForm productsCountDialogForm = new ProductsCountDialogForm();
        int productsCount = productsCountDialogForm.getProductsCount();
        productsCountDialogForm.clickShowProductsButton();

        Logger.logStep(5,"VERIFYING PREVIOUSLY PROPOSED PRODUCTS COUNT AND ACTUAL PRODUCTS COUNT...");
        Assert.assertEquals(new ProductPage().getFoundProductCount(), productsCount
                ,"Products count does not match the previously proposed!");
    }
}