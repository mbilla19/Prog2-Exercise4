package at.ac.fhcampuswien.fhmdb.observerPattern;

public interface Observable {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

