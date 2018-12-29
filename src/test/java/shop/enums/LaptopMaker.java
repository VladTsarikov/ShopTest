package shop.enums;

public enum LaptopMaker {

    HP("hp"),
    DELL("dell");

    private String maker;

    LaptopMaker(String maker) {
        this.maker = maker;
    }

    public String getMaker() {
        return maker;
    }
}