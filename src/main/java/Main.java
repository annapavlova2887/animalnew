import animals.Animals;
import data.Comands;
import java.util.ArrayList;
import java.util.Scanner;
import data.ListOfAnimals;
import factory.AnimalFactory;
import utils.ValidateNumber;


public class Main extends Animals {

    public Main(String name, int age, int weight, String color) {
        super(name, age, weight, color);
    }

    public static void main(String[] args) {

        ValidateNumber validateNumber = new ValidateNumber();
        Scanner console = new Scanner(System.in);
        ArrayList<Animals> newAnimals = new ArrayList<>();


        while (true) {
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
                    ListOfAnimals animal = null;

                    System.out.println("Какое вы животное? (Cat/Dog/Duck)");
                    while (!chekAninal) {
                        String input2 = console.next();
                        animal = ListOfAnimals.fromString(input2);
                        if (animal == null) {
                            System.out.println("У нас нет такого животного, попробуйте еще раз");
                        } else {
                            chekAninal = true;
                          }
                    }    

                        System.out.println("Введите имя");
                        String nameconsole = console.next();

                    int ageconsole = 0;
                    System.out.println("Введите возраст целым числом, до 3 знаков включительно");
                    String ageString = null;

                    while (true) {
                        ageString = console.next();
                        if (!validateNumber.isNumber(ageString) || ageString.length() > 3) {
                            System.out.println("Неверно введен возраст, попробуйте еще раз");
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
                        System.out.println("Введите вес целым числом, до 3 знаков включительно");
                        String waString = null;

                        while (true) {
                            waString = console.next();
                            if (!validateNumber.isNumber(waString) || waString.length() > 3) {
                                System.out.println("Неверно введен вес, попробуйте еще раз");
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

                    Animals animals = new AnimalFactory(nameconsole, ageconsole, waСonsole, colconsole).create(animal);
                    newAnimals.add(animals);
                    animals.say();

                    break;
                case LIST:
                    if (newAnimals.isEmpty()) {
                        System.out.println("Пока нет ни одного животного");
                    } else {
                        for (Animals item : newAnimals) {
                            System.out.println(item.toString());
                        }
                    }
                    break;
                case EXIT:
                    System.out.println("Вы ввели Exit, сейчас программа завершит работу");
                    console.close();
                    System.exit(0);
            }
        }
    }
}

