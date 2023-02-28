package task3;

import lombok.Data;

import java.util.List;

@Data
public class StarSystem {

    String name;
    List<Planet> planets;

    public StarSystem(String name, List<Planet> planets) {
        this.name = name;
        this.planets = planets;
    }
}
