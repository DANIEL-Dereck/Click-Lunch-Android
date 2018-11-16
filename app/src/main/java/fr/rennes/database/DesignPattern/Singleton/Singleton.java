package fr.rennes.database.DesignPattern.Singleton;

public class Singleton {
    protected static Singleton instance;

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    protected Singleton() {
    }
}