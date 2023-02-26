package task3;

public class HolidayAttribute extends TranslocatableObject {
    private HolidayAttributeType type;
    private LocationStatus locationStatus;

    public HolidayAttribute(HolidayAttributeType type) {
        this.type = type;
    }

    public void setLocationStatus(LocationStatus locationStatus) {
        this.locationStatus = locationStatus;
    }
}
