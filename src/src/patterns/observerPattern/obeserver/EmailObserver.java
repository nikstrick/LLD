package patterns.observerPattern.obeserver;

import patterns.observerPattern.obeservable.Observable;


public class EmailObserver implements Observer{
    Observable observable;

    public EmailObserver(Observable observable) {
        this.observable = observable;
    }

    @Override
    public void update() {
        System.out.println("EmailObserver update: for " + observable.getItemName() +" "+ observable.getItemCount());
    }
}
