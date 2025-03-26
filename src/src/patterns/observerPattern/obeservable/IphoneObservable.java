package patterns.observerPattern.obeservable;

import patterns.observerPattern.obeserver.Observer;

import java.util.ArrayList;
import java.util.List;

public class IphoneObservable implements Observable{
    String itemName = "Iphone 16";
    int itemCount;
    private final List<Observer> observers;
    
    public IphoneObservable() {
        this.observers = new ArrayList<Observer>();
        this.itemCount = 0;
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    @Override
    public void setItemCount(int itemCount) {
        int prevCount = this.itemCount;
        this.itemCount = itemCount;
        if(prevCount == 0 && itemCount > 0) {
            notifyObservers();
        }
    }

    @Override
    public int getItemCount() {
        return itemCount;
    }

    @Override
    public String getItemName() {
        return itemName;
    }

}