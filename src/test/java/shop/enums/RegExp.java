package shop.enums;

public enum RegExp {

    PRODUCTS_COUNT("(\\w[\\d*\\s?]{1,})"),
    NUMBER("([0-9]{1,})");

    private String regularExpression;

    RegExp(String regularExpression) {
        this.regularExpression = regularExpression;
    }

    public String getRegExp() {
        return regularExpression;
    }
}