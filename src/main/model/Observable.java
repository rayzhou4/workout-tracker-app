package model;

import java.util.ArrayList;
import java.util.List;

public abstract class Observable {
    protected List<Observer> observers;

    public Observable() {
        observers = new ArrayList<>();
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public abstract void notifyObservers();
}
