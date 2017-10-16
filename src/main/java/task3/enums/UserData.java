package task3.enums;

public enum UserData {
    USER("PITER CHAILOVSKII", "epam", "1234");

    public final String name;
    public final String login;
    public final String password;

    UserData(String name, String login, String password) {
        this.name = name;
        this.login = login;
        this.password = password;
    }
}

