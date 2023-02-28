package task3;

//Когда она закрылась, из нее выпало множество бумажных колпаков и надувных шаров, и они уплыли в даль Вселенной.
//        Также из нее выпали семеро трехфутовых рыночных аналитиков и умерли отчасти от удушья, отчасти от удивления.
//        Еще из нее выпали двести тридцать девять тысяч поджаренных яиц и материализовались большой кучей на
//        пораженной голодом планете Погхрил в системе Пансел.


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class DomainModelTest {

    @BeforeAll
    static void createObjects() {
    }

    @Test
    void universeGreatHoleClosedAtStartTest() {

        Universe universe = new Universe();
        assertNotNull(universe.getGreatHole());
        assertFalse(universe.getGreatHole().isOpened());

    }

    @Test
    void universeStarSystemsAtStartTest() {

        Universe universe = new Universe();
        assertNotNull(universe.getStarSystems());
        assertEquals(universe.getStarSystems().size(), 1);

        StarSystem pancel = (StarSystem) universe.getStarSystems().toArray()[0];
        assertEquals(pancel.name, "Пансел");
        assertEquals(pancel.planets.size(), 1);

        Planet poghril = pancel.planets.get(0);
        assertEquals(poghril.name, "Погхрил");
        assertEquals(poghril.amountOfFood.size(), 0);
        assertEquals(poghril.hungerStatus, HungerStatus.HUNGRY);

    }

    @Test
    void universeAffectingObjectsTest() {

        Universe universe = new Universe();
        MarketAnalyst marketAnalyst = new MarketAnalyst(3);
        HolidayAttribute paperCap = new HolidayAttribute(HolidayAttributeType.PAPER_CAP);
        HolidayAttribute balloon = new HolidayAttribute(HolidayAttributeType.PAPER_CAP);
        FriedEgg friedEgg = new FriedEgg();

        assertEquals(marketAnalyst.getDeathCause(), DeathCause.NONE);
        universe.affectObject(marketAnalyst, 1);
        assertEquals(marketAnalyst.getDeathCause(), DeathCause.COMBINED);
        assertEquals(marketAnalyst.getAstonishmentLevel(), Integer.MAX_VALUE/2);
        assertEquals(marketAnalyst.getSuffocationLevel(), Integer.MAX_VALUE);

        assertEquals(paperCap.getLocationStatus(), LocationStatus.UNKNOWN);
        universe.affectObject(paperCap, 1);
        assertEquals(paperCap.getLocationStatus(), LocationStatus.LOST_IN_UNIVERSE);

        assertEquals(balloon.getLocationStatus(), LocationStatus.UNKNOWN);
        universe.affectObject(balloon, 1);
        assertEquals(balloon.getLocationStatus(), LocationStatus.LOST_IN_UNIVERSE);

        StarSystem pancel = (StarSystem) universe.getStarSystems().toArray()[0];
        Planet poghril = pancel.planets.get(0);
        assertEquals(poghril.hungerStatus, HungerStatus.HUNGRY);
        universe.affectObject(friedEgg, 1000);
        assertEquals(poghril.hungerStatus, HungerStatus.NOT_HUNGRY);

    }

    @Test
    void universeGreatHoleOpenCloseTest() {

        Universe universe = new Universe();
        assertFalse(universe.getGreatHole().isOpened());
        universe.openGreatHole();
        assertTrue(universe.getGreatHole().isOpened());
        universe.closeGreatHole();
        assertFalse(universe.getGreatHole().isOpened());

    }

    @Test
    void greatHoleOpenTest() {

        GreatHole greatHole = new GreatHole();
        assertFalse(greatHole.isOpened());
        greatHole.open();
        assertTrue(greatHole.isOpened());
    }


    @Test
    void greatHoleCloseTest() {

        GreatHole greatHole = new GreatHole();
        greatHole.open();
        assertTrue(greatHole.isOpened());
        Map<TranslocatableObject, Integer> emittedObjects = greatHole.close();
        assertFalse(greatHole.isOpened());

        int balloons = 0;
        int paperCaps = 0;
        int eggs = 0;
        int marketAnalysts = 0;
        MarketAnalyst marketAnalyst = null;
        FriedEgg egg = null;
        HolidayAttribute paperCap = null;
        HolidayAttribute balloon = null;

        for (TranslocatableObject obj: emittedObjects.keySet()) {

            if (obj.getClass() == FriedEgg.class) {
                eggs += emittedObjects.get(obj);
                egg = (FriedEgg) obj;
            } else if (obj.getClass() == MarketAnalyst.class) {
                marketAnalysts += emittedObjects.get(obj);
                marketAnalyst = (MarketAnalyst) obj;
            } else if (obj.getClass() == HolidayAttribute.class) {
                if (((HolidayAttribute) obj).getType() == HolidayAttributeType.BALLOON) {
                    balloons += emittedObjects.get(obj);
                    balloon = (HolidayAttribute) obj;
                } else {
                    paperCaps += emittedObjects.get(obj);
                    paperCap = (HolidayAttribute) obj;
                }
            }
        }

        assertEquals(emittedObjects.size(), 4);

        assertNotNull(marketAnalyst);
        assertNotNull(egg);
        assertNotNull(balloon);
        assertNotNull(paperCap);

        assertEquals(balloons, Integer.MAX_VALUE);
        assertEquals(paperCaps, Integer.MAX_VALUE);
        assertEquals(eggs, 239*1000);
        assertEquals(marketAnalysts, 7);

        assertEquals(marketAnalyst.getHeightInFt(), 3);
        assertEquals(balloon.getLocationStatus(), LocationStatus.UNKNOWN);
        assertEquals(paperCap.getLocationStatus(), LocationStatus.UNKNOWN);
    }

    @Test
    void greatHoleCloseIfClosedTest() {

        GreatHole greatHole = new GreatHole();
        assertFalse(greatHole.isOpened());
        Map<TranslocatableObject, Integer> emittedObjects = greatHole.close();
        assertFalse(greatHole.isOpened());
        assertNull(emittedObjects);

    }

    @Test
    void marketAnalystDeathCauseTest() {

        MarketAnalyst marketAnalyst = new MarketAnalyst(3);

        assertEquals(marketAnalyst.getAstonishmentLevel(), 0);
        assertEquals(marketAnalyst.getSuffocationLevel(), 0);
        assertEquals(marketAnalyst.getDeathCause(), DeathCause.NONE);

        marketAnalyst.setSuffocation(Integer.MAX_VALUE);

        assertEquals(marketAnalyst.getDeathCause(), DeathCause.SUFFOCATION);


        marketAnalyst = new MarketAnalyst(3);
        marketAnalyst.setAstonishment(Integer.MAX_VALUE);

        assertEquals(marketAnalyst.getDeathCause(), DeathCause.ASTONISHMENT);

        marketAnalyst = new MarketAnalyst(3);
        marketAnalyst.setAstonishment(Integer.MAX_VALUE/2);
        marketAnalyst.setSuffocation(Integer.MAX_VALUE/2);

        assertEquals(marketAnalyst.getDeathCause(), DeathCause.COMBINED);

        marketAnalyst = new MarketAnalyst(3);
        marketAnalyst.setAstonishment(Integer.MAX_VALUE/2);
        marketAnalyst.setSuffocation(Integer.MAX_VALUE);

        assertEquals(marketAnalyst.getDeathCause(), DeathCause.COMBINED);

        marketAnalyst = new MarketAnalyst(3);
        marketAnalyst.setAstonishment(Integer.MAX_VALUE/2 + 1);
        marketAnalyst.setSuffocation(0);

        assertEquals(marketAnalyst.getDeathCause(), DeathCause.NONE);

        marketAnalyst = new MarketAnalyst(3);
        marketAnalyst.setAstonishment(0);
        marketAnalyst.setSuffocation(Integer.MAX_VALUE/2 + 1);

        assertEquals(marketAnalyst.getDeathCause(), DeathCause.NONE);

        /*dead market analyst stability*/

        MarketAnalyst deadMarketAnalyst = new MarketAnalyst(3);
        deadMarketAnalyst.setDead(true);

        assertEquals(deadMarketAnalyst.getAstonishmentLevel(), 0);
        assertEquals(deadMarketAnalyst.getSuffocationLevel(), 0);
        assertEquals(deadMarketAnalyst.getDeathCause(), DeathCause.NONE);

        deadMarketAnalyst.setSuffocation(Integer.MAX_VALUE);
        assertEquals(deadMarketAnalyst.getSuffocationLevel(), 0);
        assertEquals(deadMarketAnalyst.getDeathCause(), DeathCause.NONE);

        deadMarketAnalyst.setAstonishment(Integer.MAX_VALUE);
        assertEquals(deadMarketAnalyst.getAstonishmentLevel(), 0);
        assertEquals(deadMarketAnalyst.getDeathCause(), DeathCause.NONE);

    }

    @Test
    void planetFoodMaterializationTest() {

        Planet hungryPlanet = new Planet("_", HungerStatus.HUNGRY);

        hungryPlanet.materializeFoodInAHeap("eggs", 200);

        assertEquals(hungryPlanet.amountOfFood.get("eggs"), 200);
        assertEquals(hungryPlanet.hungerStatus, HungerStatus.HUNGRY);

        hungryPlanet.materializeFoodInAHeap("eggs", 800);

        assertEquals(hungryPlanet.amountOfFood.get("eggs"), 1000);
        assertEquals(hungryPlanet.hungerStatus, HungerStatus.NOT_HUNGRY);

        Planet planet = new Planet("_", HungerStatus.UNKNOWN);
        planet.materializeFoodInAHeap("eggs", 239*1000);

        assertEquals(planet.amountOfFood.get("eggs"), 239*1000);
        assertEquals(planet.hungerStatus, HungerStatus.NOT_HUNGRY);


    }


}
