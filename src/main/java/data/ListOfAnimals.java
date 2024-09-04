package data;

public enum ListOfAnimals {
    CAT,
    DOG,
    DUCK;

    public static ListOfAnimals fromString(String command2) {
        try {
            return ListOfAnimals.valueOf(command2.trim().toUpperCase());
        }
        catch (IllegalArgumentException e) {
            return null;
        }
    }
}