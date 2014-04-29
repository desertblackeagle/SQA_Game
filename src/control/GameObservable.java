package control;

import java.util.Observable;
import java.util.Observer;

public class GameObservable extends Observable {

	public void setChanged() {
		super.setChanged();
	}

	public void addObserver(Observer observer) {
		super.addObserver(observer);
	}

	public int countObservers() {
		return super.countObservers();
	}

	public void deleteObserver(Observer observer) {
		super.deleteObserver(observer);
	}

	public void deleteObservers() {
		super.deleteObservers();
	}

	public void notifyObservers() {
		super.notifyObservers();
	}

	public void notifyObservers(Object o) {
		super.notifyObservers(o);
	}

	public void notifyObservers(Observer observer) {
		super.notifyObservers(observer);
	}
}
