package models;

public class Dice {
    static int min = 1;
    static int max = 6;
    static int range = max - min + 1;
    public static int roll() {
        return (int)(Math.random() * range) + min;
    }
}
