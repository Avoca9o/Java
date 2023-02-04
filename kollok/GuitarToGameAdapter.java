package org.example;

final public class GuitarToGameAdapter implements Game {
    final Guitar guitar;
    public GuitarToGameAdapter(final Guitar g) {
        guitar = g;
    }
    @Override
    public void play() {
        guitar.playOn();
    }
}
