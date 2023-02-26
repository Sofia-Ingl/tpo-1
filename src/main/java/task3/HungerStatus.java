package task3;

public enum HungerStatus {

    HUNGRY ("пораженный голодом"),
    NOT_HUNGRY ("сытый и процветающий"),
    UNKNOWN ("статус неизвестен");

    private String description;

    HungerStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
