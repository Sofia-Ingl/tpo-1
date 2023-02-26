package task3;

public enum HolidayAttributeType {

    PAPER_CAP("бумажный колпак"),
    BALLOON("надувной шар");

    private String description;

    HolidayAttributeType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
