package task3;

public enum DeathCause {

    SUFFOCATION ("от удушья"),
    ASTONISHMENT ("от удивления"),
    COMBINED ("отчасти от удушья, отчасти от удивления"),
    NONE ("персонаж жив");

    private String description;

    DeathCause(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
