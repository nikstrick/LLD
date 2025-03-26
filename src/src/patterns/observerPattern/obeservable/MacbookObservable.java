package patterns.observerPattern.obeservable;

import patterns.observerPattern.obeserver.Observer;

import java.util.ArrayList;

public class MacbookObservable implements Observable{
    private final ArrayList<Observer> observers;
    String itemName = "Macbook";
    int itemCount;

    public MacbookObservable() {
        this.observers = new ArrayList<>();
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
        if(prevCount == 0 && itemCount > 0){
            notifyObservers();
        }
    }

    @Override
    public String getItemName() {
        return itemName;
    }

    @Override
    public int getItemCount() {
        return itemCount;
    }
}
