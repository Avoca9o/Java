package model;

public class Developer extends User {
    public Developer(String n) {
        super(n);
    }

    @Override
    public void notify(Game game) {
        System.out.println("My name is " + name + ". I am a developer.\n" +
                "New game " + game.getTitle() + ". Some technical info:\n" +
                game.getData() + "\n");
    }
}
