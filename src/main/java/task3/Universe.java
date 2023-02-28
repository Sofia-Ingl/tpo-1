package task3;

import lombok.Data;

import java.util.*;

@Data
public class Universe {

    private GreatHole greatHole;
    private Set<StarSystem> starSystems;

    public Universe() {

        this.greatHole = new GreatHole();

        starSystems = new HashSet<StarSystem>();
        List<Planet> pl = new LinkedList<Planet>();
        pl.add(new Planet("Погхрил", HungerStatus.HUNGRY));
        StarSystem ss = new StarSystem("Пансел", pl);
        starSystems.add(ss);
    }

    public void openGreatHole() {
        greatHole.open();
    }

    public Map<TranslocatableObject, Integer> closeGreatHole() {

        Map<TranslocatableObject, Integer> translocatedObjects = greatHole.close();

        for (TranslocatableObject obj : translocatedObjects.keySet()) {
            affectObject(obj, translocatedObjects.get(obj));
        }
        return translocatedObjects;

    }

    public void affectObject(TranslocatableObject object, Integer numberOfObjects) {
        Class cls = object.getClass();
        String clsName = cls.getName();
        if (clsName.contains("HolidayAttribute")) {

            ((HolidayAttribute) object).setLocationStatus(LocationStatus.LOST_IN_UNIVERSE);

        } else if (clsName.contains("MarketAnalyst")) {

            ((MarketAnalyst) object).setAstonishment(Integer.MAX_VALUE/2);
            ((MarketAnalyst) object).setSuffocation(Integer.MAX_VALUE);

        } else if (clsName.contains("FriedEgg")) {

            StarSystem pansel = null;
            Planet poghrill = null;

            for (StarSystem ss: starSystems) {
                if (ss.name.equals("Пансел")) {
                    pansel = ss;
                    break;
                }
            }
            if (pansel != null) {
                for (Planet p: pansel.planets) {
                    if (p.name.equals("Погхрил")) {
                        poghrill = p;
                        break;
                    }
                }
            }

            if (poghrill != null) {
                poghrill.materializeFoodInAHeap(clsName, numberOfObjects);
            }
        }
    }


}
