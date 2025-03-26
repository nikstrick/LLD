package patterns.observerPattern;

import patterns.observerPattern.obeservable.IphoneObservable;
import patterns.observerPattern.obeservable.MacbookObservable;
import patterns.observerPattern.obeservable.Observable;
import patterns.observerPattern.obeserver.EmailObserver;
import patterns.observerPattern.obeserver.Observer;
import patterns.observerPattern.obeserver.PhoneObserver;

public class Main {
    public static void main(String[] args) {
        Observable observable = new IphoneObservable();
        Observable macObservable = new MacbookObservable();
        Observer observerPhoneForIphone = new PhoneObserver(observable);
        Observer observerPhoneForMac = new PhoneObserver(macObservable);
        Observer observerEmail = new EmailObserver(observable);
        //Iphone
        observable.addObserver(observerEmail);
        observable.addObserver(observerPhoneForIphone);
        observable.setItemCount(10);
        observable.removeObserver(observerEmail);
        observable.setItemCount(0);
        observable.setItemCount(100);
        //Macbook

        macObservable.addObserver(observerPhoneForMac);
        macObservable.setItemCount(100);
    }
}
