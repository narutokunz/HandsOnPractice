package com.practice.week1.designpatterns;

import java.util.ArrayList;
import java.util.List;

/**
 * OBSERVER PATTERN
 * A subject maintains a list of observers and notifies them automatically
 * of any state changes (classic pub-sub, used heavily in event-driven systems).
 */
public class ObserverPatternDemo {

    interface Observer {
        void update(String event);
    }

    static class NotificationChannel implements Observer {
        private final String name;
        NotificationChannel(String name) { this.name = name; }
        public void update(String event) {
            System.out.println(name + " received event: " + event);
        }
    }

    static class Subject {
        private final List<Observer> observers = new ArrayList<>();
        void subscribe(Observer o) { observers.add(o); }
        void unsubscribe(Observer o) { observers.remove(o); }
        void notifyAll(String event) {
            for (Observer o : observers) o.update(event);
        }
    }

    public static void main(String[] args) {
        Subject orderSubject = new Subject();
        orderSubject.subscribe(new NotificationChannel("Email"));
        orderSubject.subscribe(new NotificationChannel("SMS"));

        orderSubject.notifyAll("Order Shipped");
    }
}
