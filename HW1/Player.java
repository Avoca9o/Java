package org.example;

public abstract class Player {
    abstract Field makeMove(Field f, char colour) throws RuntimeException;

    public final void endOfMove(Field f) {
        System.out.println("Новое поле:");
        System.out.println(f);
    }
}
