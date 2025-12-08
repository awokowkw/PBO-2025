import java.util.ArrayList;
import java.util.List;

public class Simulator {

    private Field field;
    private List<Animal> animals;

    public Simulator(int depth, int width) {
        field = new Field(depth, width);
        animals = new ArrayList<>();
        populate();
    }

    public void simulate(int steps) {

        for (int step = 1; step <= steps; step++) {
            System.out.println("\nSTEP: " + step + " ---");
            
            List<Animal> newAnimals = new ArrayList<>();

            for (Animal animal : animals) {
                animal.act(newAnimals);
            }

            animals.addAll(newAnimals);
            
            field.printField();
        }
    }

    private void populate() {
        animals.add(new Rabbit(field, new Location(1,1)));
        animals.add(new Rabbit(field, new Location(3,3)));
        animals.add(new Fox(field, new Location(2,2)));
    }

}
