package model;

public abstract class User {
    final String name;
    public void notify(Game game) {}
    public User(String n) {
        name = n;
    }
}
