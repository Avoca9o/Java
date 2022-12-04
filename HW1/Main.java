package org.example;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        printMenu();
        var scanner = new Scanner(System.in);
        Game game;
        String s = scanner.nextLine();
        while (s.equals("1") || s.equals("2") || s.equals("3")) {
            game = new Game(s);
            game.run();
            printMenu();
            s = scanner.nextLine();
        }
        System.out.println("Всего хорошего!\n");
    }

    private static void printMenu() {
        System.out.println("""
                Игра "Реверси".\s
                Выберите режим
                1 - против компьютера (легкий уровень)
                2 - против компьютера (продвинутый уровень)
                3 - игрок против игрока
                любой другой ввод - выход""");
    }
}