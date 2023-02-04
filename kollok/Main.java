package org.example;

/*  Билет 1
    Реализация шаблона Адаптер
    Владимиров Дмитрий БПИ218   */

public class Main {
    public static void main(String[] args) {
        // Какой-то игрок
        Player player = new Player();

        // Шахматы, в них можно играть просто так
        Chess chess = new Chess();
        player.playSmth(chess);

        // Гитара, в нее нельзя просто так играть, играть можно на ней
        // Поэтому необходимо использовать адаптер, который представляет ее как игру
        Guitar guitar = new Guitar();
        player.playSmth((new GuitarToGameAdapter(guitar)));
    }
}
