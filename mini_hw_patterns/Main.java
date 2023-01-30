package org.example;

import model.Console;
import model.Game;

public class Main {
    public static void main(String[] args) {
        Console console = new Console();
        console.addGame(new Game("Sudoku", "Easy done, Medium done, Hard done",
                "It's an interesting japan game",
                "9x9 field and unique digits in one row, column, and 3x3 square"));
        try {
            Thread.sleep(2000);
        } catch (Throwable throwable) {
            System.out.println("Something went wrong");
        }
        console.addGame(new Game("Chess", "Beginner, Amateur, Pro, Grandmaster",
                "Play chess with other players all over the World",
                "8x8 field, 6 kinds of figures, two players"));
    }
}