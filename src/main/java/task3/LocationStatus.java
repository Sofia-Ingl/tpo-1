package task3;


public enum LocationStatus {
    LOST_IN_UNIVERSE ("уплыл в даль Вселенной"),
    UNKNOWN ("статус неизвестен");

    private String description;

    LocationStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
