package shop.enums;

public enum ProductTypeMenuItem {

    COMPUTERS("kompyutery"),
    HOBBY("hobby"),
    AUTO("avto");

    private String hrefPart;

    ProductTypeMenuItem(String hrefPart) {
        this.hrefPart = hrefPart;
    }

    public String getHrefPart() {
        return hrefPart;
    }
}