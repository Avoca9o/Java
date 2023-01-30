package model;

import model.*;
import subject.Observer;

import java.util.ArrayList;
import java.util.List;

public class Console {
    Observer observer;
    List<Game> games;
    public Console() {
        observer = new Observer();
        games = new ArrayList<>();
        observer.attach(new Developer("Alex"));
        observer.attach(new Player("Tom"));
        observer.attach(new Journalist("Sam"));
        observer.attach(new Journalist("Steve"));
        observer.attach(new Developer("Franc"));
        observer.attach(new Player("Stan"));
    }

    public void addGame(Game game) {
        games.add(game);
        observer.notifyAll(game);
    }
}
