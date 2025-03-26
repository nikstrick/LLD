package patterns.observerPattern.obeserver;

import patterns.observerPattern.obeservable.Observable;

public class PhoneObserver implements Observer {
    Observable observable;

    public PhoneObserver(Observable observable) {
        this.observable = observable;
    }

    @Override
    public void update() {
        System.out.println("Phone Observer update: for " + observable.getItemName() +" "+ observable.getItemCount());
    }
}
