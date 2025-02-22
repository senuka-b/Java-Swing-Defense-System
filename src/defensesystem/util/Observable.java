/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package defensesystem.util;

import java.util.ArrayList;

/**
 *
 * @author senukab
 */

interface ObservableInterface {
    public boolean addObserver(Observer observer);
    public boolean removeObserver(Observer observer);
    public void notifyObservers(Event event);
    public void notify(int observerIndex, Event event);1
    public int getObserverIndex(Observer observer);
    public Observer[] toArray();
    public int getNextIndex();
    public Observer getObserver(int index);

    
}



public class Observable implements ObservableInterface {
    
    private final ArrayList<Observer> observerList = new ArrayList<>();

    @Override
    public boolean addObserver(Observer observer) {
        return observerList.add(observer);
    }
    
    @Override
    public boolean removeObserver(Observer observer) {
        return observerList.remove(observer);
    }

    @Override
    public void notify(int observerIndex, Event event) {
        Observer observer = getObserver(observerIndex);
        observer.update(event);
    }

    @Override
    public void notifyObservers(Event event) {
        for (Observer observer : observerList) {
            observer.update(event);
        }
    }

    @Override
    public int getObserverIndex(Observer observer) {
        return observerList.indexOf(observer);
    }
    
    @Override
    public Observer[] toArray() {
        return observerList.toArray(new Observer[0]);
    }
    
    @Override
    public int getNextIndex () {
        return observerList.size();
    }
    
    @Override
    public Observer getObserver(int index) {
        return observerList.get(index);
    }
    

    
}
