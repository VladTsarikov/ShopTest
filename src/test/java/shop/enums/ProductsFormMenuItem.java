package shop.enums;

public enum ProductsFormMenuItem {

    LAPTOPS("noutbuki"),
    MONITORS("monitory");

    private String hrefPart;

    ProductsFormMenuItem(String hrefPart) {
        this.hrefPart = hrefPart;
    }

    public String getHrefPart() {
        return hrefPart;
    }
}