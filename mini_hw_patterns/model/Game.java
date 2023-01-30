package model;

public class Game {
    final String title;
    final String achievements;
    final String info;
    final String data;
    public Game(final String t, final String ach, final String inf, final String d) {
        title = t;
        achievements = ach;
        info = inf;
        data = d;
    }
    public String getTitle() {
        return title;
    }
    public String getAchievements() {
        return achievements;
    }
    public String getInfo() {
        return info;
    }
    public String getData() {
        return data;
    }
}
