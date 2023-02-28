package task3;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Planet {

    String name;
    HungerStatus hungerStatus;
    Map<String, Integer> amountOfFood;

    public Planet(String name, HungerStatus hungerStatus) {
        this.name = name;
        this.hungerStatus = hungerStatus;
        this.amountOfFood = new HashMap<String, Integer>();
    }

    public Planet(String name, HungerStatus hungerStatus, Map<String, Integer> food) {
        this.name = name;
        this.hungerStatus = hungerStatus;
        this.amountOfFood = food;
    }

    public void materializeFoodInAHeap(String foodType, Integer amount) {
        if (!amountOfFood.containsKey(foodType)) {
            amountOfFood.put(foodType, amount);
        } else {
            amountOfFood.put(foodType, amountOfFood.get(foodType) + amount);
        }
        if (( amountOfFood.get(foodType) >= 1000) && (hungerStatus != HungerStatus.NOT_HUNGRY)) {
            hungerStatus = HungerStatus.NOT_HUNGRY;
        }

    }

}
