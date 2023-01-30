package model;

public class Player extends User {
    public Player(String n) {
        super(n);
    }

    @Override
    public void notify(Game game) {
        System.out.println("My name is " + name + ". I am a player.\n" +
                "New game " + game.getTitle() + ". Achievements:\n" +
                game.getAchievements() + "\n");
    }
}
