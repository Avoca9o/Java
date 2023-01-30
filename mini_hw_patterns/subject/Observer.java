package subject;

import model.Game;
import model.User;

import java.util.ArrayList;
import java.util.List;

public class Observer {
    List<User> users;
    public Observer() {
        users = new ArrayList<>();
    }

    public void attach(User user) {
        users.add(user);
    }

    public void notifyAll(Game g) {
        for (final var user : users) {
            user.notify(g);
        }
    }
}
