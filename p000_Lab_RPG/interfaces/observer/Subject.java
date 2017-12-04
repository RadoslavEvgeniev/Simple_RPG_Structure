package p000_Lab_RPG.interfaces.observer;

public interface Subject {

    void register(Observer observer);
    void unregister(Observer observer);
    void notifyObservers();

}
