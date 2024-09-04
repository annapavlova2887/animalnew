package factory;
import animals.Animals;
import animals.birds.Duck;
import animals.pets.Cat;
import animals.pets.Dog;
import data.ListOfAnimals;

public class AnimalFactory {

    private String name;
    private int age;
    private int weight;
    private String color;

    public AnimalFactory(String name, int age, int weight, String color) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.color = color;

    }

    public Animals create(ListOfAnimals animalData) {
        switch (animalData) {
            case CAT: {
                return new Cat(name, age, weight, color);
            }
            case DOG: {
                return new Dog(name, age, weight, color);
            }
            case DUCK: {
                return new Duck(name, age, weight, color);
            }
        }

        return null;
    }
}
