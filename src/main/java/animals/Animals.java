package animals;

public abstract class Animals {

    String name;
    int age;
    int weight;
    String color;

    public Animals(String name, int age, int weight, String color) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void say() {
        System.out.println("Я говорю");
    }

    public void go() {
        System.out.println("Я иду");
    }

    public void drink() {
        System.out.println("Я пью");
    }

    public void eat() {
        System.out.println("Я ем");
    }

    @Override
    public String toString () {

        String let;
        int ostDel = age % 10;


        if (ostDel == 1) {
            let = " год";
        } else if (ostDel >= 2 && ostDel <= 4 && (age < 10 || age > 20)) {
            let = " года";
        } else {
            let = " лет";
        }
        return "Привет! меня зовут "
                + name + ", мне " + age  + let + ", я вешу - "
                + weight + " кг, мой цвет - " + color;
    }

}
