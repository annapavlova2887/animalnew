package animals.pets;
import animals.Animals;

public class Dog extends Animals {
    public Dog(String name, int age, int weight, String color) {
        super(name, age, weight, color);
    }

    @Override
    public void say() {
        System.out.println("Гав");
    }
}