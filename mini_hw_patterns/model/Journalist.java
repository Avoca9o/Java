package model;

public class Journalist extends User {
    public Journalist(String n) {
        super(n);
    }

    @Override
    public void notify(Game game) {
        System.out.println("My name is " + name + ". I am a journalist.\n" +
                "New game " + game.getTitle() + ". Some info:\n" +
                game.getInfo() + "\n");
    }
}
