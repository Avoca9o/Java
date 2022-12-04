package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public final class Person extends Player {

    @Override
    Field makeMove(Field f, char colour) throws EndOfGameException,
            LastMoveCancelledException, CantMakeMoveException {
        // Сначала подтягивает все возможные ходы
        ArrayList<Point> moves = f.getMoves(colour);
        if (moves.isEmpty()) {
            throw new CantMakeMoveException();
        }

        // Создаем новое поле и для визуализации добавляем туда прописные буковки
        char cur = 'a';
        Field temp = new Field(f);
        for (Point p : moves) {
            temp.change(p.x, p.y, cur);
            cur++;
        }
        System.out.println(temp);
        System.out.println("""
                Сделайте ход (введите только строчную латинскую букву)
                Отменить ход - введите "zz"
                """);

        // Считываем ход, который хочет сделать пользователь
        String move;
        var scanner = new Scanner(System.in);
        move = scanner.nextLine();
        while (!MyLib.isRightMove(move, cur)) {
            System.out.println("Неправильный ввод, попробуйте еще раз");
            move = scanner.nextLine();
        }
        if (move.equals("zz")) {
            throw new LastMoveCancelledException();
        }

        // Меняем в исходном поле данные согласно выбранному ходу и возвращаем новое поле
        Point chosenMove = moves.get(move.charAt(0) - 'a');
        var newField = new Field(f);
        newField.change(chosenMove.x, chosenMove.y, colour);
        super.endOfMove(newField);
        return newField;
    }
}
