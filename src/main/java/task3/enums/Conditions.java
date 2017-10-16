package task3.enums;

public enum Conditions {
    WATER("Water"),
    EARTH("Earth"),
    WIND("Wind"),
    FIRE("Fire");

    public final String text;

    Conditions(String text) {
        this.text = text;
    }
}

