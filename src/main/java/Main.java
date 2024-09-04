import animals.Animals;
import animals.birds.Duck;
import animals.pets.Cat;
import animals.pets.Dog;
import data.Comands;
import java.util.ArrayList;
import java.util.Scanner;
import data.ListOfAnimals;
import utils.ValidateNumber;


public class Main extends Animals {

    public Main(String name, int age, int weight, String color) {
        super(name, age, weight, color);
    }

    public static void main(String[] args) {

        ValidateNumber validateNumber = new ValidateNumber();
        Scanner console = new Scanner(System.in);
        boolean menue = true;
        ArrayList<Animals> newAnimals = new ArrayList<>();


        while (menue) {
            System.out.println("Введите команду: add/list/exit");
            String input = console.next();
            Comands command = Comands.fromString(input);

            if (command==null) {
                System.out.println("Введена неверная команда");
                continue;
            }

            switch (command) {
                case ADD:
                    boolean chekAninal = false;
                    ListOfAnimals command2 = null;

                    System.out.println("Какое вы животное? (Cat/Dog/Duck)");
                    while (!chekAninal) {
                        String input2 = console.next();
                        command2 = ListOfAnimals.fromString(input2);
                        if (command2 == null) {
                            System.out.println("У нас нет такого животного, попробуйте еще раз");
                            continue;
                        } else {
                            chekAninal = true;
                          }
                    }    

                        System.out.println("Введите имя");
                        String nameconsole = console.next();

                    int ageconsole = 0;
                    System.out.println("Введите возраст целым числом");
                    String ageString = null;

                    while (true) {
                        ageString = console.next();
                        if (!validateNumber.isNumber(ageString)) {
                            System.out.println("Неверно введен возраст, попробуйте еще раз");
                            continue;
                        } else {
                            ageconsole = Integer.parseInt(ageString);
                            if (ageconsole==0) {
                                System.out.println("Возраст не должен быть равен 0, попробуйте еще раз");
                                continue;
                            }
                            break;
                        }
                    }

                        int waСonsole = 0;
                        System.out.println("Введите вес целым числом");
                        String waString = null;

                        while (true) {
                            waString = console.next();
                            if (!validateNumber.isNumber(waString)) {
                                System.out.println("Неверно введен вес, попробуйте еще раз");
                                continue;
                            } else {
                                waСonsole = Integer.parseInt(waString);
                                if (waСonsole==0) {
                                    System.out.println("Вес не должен быть равен 0, попробуйте еще раз");
                                    continue;
                                }
                                break;
                            }
                        }

                        System.out.println("Введите цвет");
                        String colconsole = console.next();

                        switch (command2) {
                            case CAT:
                                Cat cat = new Cat(nameconsole, ageconsole, waСonsole, colconsole);
                                newAnimals.add(cat);
                                cat.say();
                                break;
                            case DOG:
                                Dog dog = new Dog(nameconsole, ageconsole, waСonsole, colconsole);
                                newAnimals.add(dog);
                                dog.say();
                                break;
                            case DUCK:
                                Duck duck = new Duck(nameconsole, ageconsole, waСonsole, colconsole);
                                newAnimals.add(duck);
                                duck.say();
                                break;
                        }
                    break;
                case LIST:
                    for (Animals item : newAnimals) {
                        System.out.println(item.toString());
                    }
                    break;
                case EXIT:
                    System.out.println("Вы ввели Exit, сейчас программа завершит работу");
                    System.exit(0);
            }
        }
        console.close();
    }
}

