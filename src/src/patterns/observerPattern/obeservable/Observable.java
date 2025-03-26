package patterns.observerPattern.obeservable;

import patterns.observerPattern.obeserver.Observer;

public interface Observable {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
    void setItemCount(int count);
    int getItemCount();
    String getItemName();
}
