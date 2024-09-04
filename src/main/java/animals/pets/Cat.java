package animals.pets;
import animals.Animals;

public class Cat extends Animals {

    public Cat (String name, int age, int weight, String color) {
        super(name, age, weight, color);
    }

    @Override
    public void say() {
        System.out.println("Мяу");
    }
}