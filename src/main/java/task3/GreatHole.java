package task3;

import java.util.HashMap;
import java.util.Map;

public class GreatHole {

    private boolean isOpened = false;

    public void open() {
        if (!isOpened) {
            isOpened = true;
        }
    }

    public Map<TranslocatableObject, Integer> close() {
        if (isOpened) {
            Map<TranslocatableObject, Integer> emittedObjects = emitObjects();
            isOpened = false;
            return emittedObjects;
        }
        return null;
    }

    private Map<TranslocatableObject, Integer> emitObjects() {
        Map<TranslocatableObject, Integer> objects = new HashMap<TranslocatableObject, Integer>();

        objects.put(new HolidayAttribute(HolidayAttributeType.PAPER_CAP), Integer.MAX_VALUE);
        objects.put(new HolidayAttribute(HolidayAttributeType.BALLOON), Integer.MAX_VALUE);
        objects.put(new MarketAnalyst(3), 7);
        objects.put(new FriedEgg(), 239*1000);

        return objects;
    }
}
