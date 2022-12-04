package org.example;

import java.util.ArrayList;
import java.util.Random;

public final class FoolishComputer extends Computer {
    @Override
    Field makeMove(Field f, char colour) {
        // Сначала находит все возможные ходы
        ArrayList<Point> moves = f.getMoves(colour);
        if (moves.isEmpty()) {
            throw new CantMakeMoveException();
        }

        int posOfChosenMove = MyLib.findBestMove(f, colour, moves);
        // По формуле высчитывает лучший ход и возвращает его
        Point chosenMove = moves.get(posOfChosenMove);
        var newField = new Field(f);
        newField.change(chosenMove.x, chosenMove.y, colour);
        System.out.println("Компьютер сходил");
        super.endOfMove(newField);
        return newField;
    }
}
