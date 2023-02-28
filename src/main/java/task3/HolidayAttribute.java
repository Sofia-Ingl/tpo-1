package task3;

import lombok.Data;

@Data
public class HolidayAttribute extends TranslocatableObject {
    private HolidayAttributeType type;
    private LocationStatus locationStatus;

    public HolidayAttribute(HolidayAttributeType type) {
        this.type = type;
        this.locationStatus = LocationStatus.UNKNOWN;
    }

    public void setLocationStatus(LocationStatus locationStatus) {
        this.locationStatus = locationStatus;
    }
}
