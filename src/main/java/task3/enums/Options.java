package task3.enums;

public enum Options {
    SUPPORT("SUPPORT"),
    DATES("DATES"),
    COMPL_TBL("COMPLEX TABLE"),
    SIMP_TBL("SIMPLE TABLE"),
    PAGES_TBL("TABLE WITH PAGES"),
    DIFF_EL("DIFFERENT ELEMENTS");

    public final String text;

    Options(String text) {
        this.text = text;
    }
}

