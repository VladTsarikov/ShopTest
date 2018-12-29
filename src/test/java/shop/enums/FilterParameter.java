package shop.enums;

public enum FilterParameter {

    MAKER(1000),
    TYPE(56);

    private int id;

    FilterParameter(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}