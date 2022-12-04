package org.example;

import java.util.ArrayList;

public final class SmartComputer extends Computer {
    @Override
    Field makeMove(Field f, char colour) {
        // Для начала находит список всех возможных ходов
        ArrayList<Point> moves = f.getMoves(colour);
        if (moves.isEmpty()) {
            throw new CantMakeMoveException();
        }
        char other = MyLib.getOtherChar(colour);

        // подыскивает лучший ход с предсказанием возможных ответов противника
        Point chosenMove = moves.get(0);
        int maxPointsInMove = Integer.MIN_VALUE;
        // проходимся по всем возможным ходам
        for (Point p : moves) {
            int pointsInMove = MyLib.countPoints(f, colour, p);
            Field temp = new Field(f);
            temp.change(p.x, p.y, colour);
            // Для конкретного хода находим лучший возможный ответ противника
            ArrayList<Point> otherMoves = temp.getMoves(other);
            if (otherMoves.isEmpty()) {
                break;
            }
            Point tmp = otherMoves.get(MyLib.findBestMove(temp, other, otherMoves));
            int maxPointsInEnemyMove = MyLib.countPoints(f, other, tmp);
            // Таким образом находим ход, на котором противник не сможет получить большее преимущество
            if (pointsInMove - maxPointsInEnemyMove > maxPointsInMove) {
                maxPointsInMove = pointsInMove - maxPointsInEnemyMove;
                chosenMove = p;
            }
        }
        // создаем новое поле, делаем в нем полученный ход и возвращаем его
        var newField = new Field(f);
        newField.change(chosenMove.x, chosenMove.y, colour);
        System.out.println("Компьютер сходил");
        super.endOfMove(newField);
        return newField;
    }
}
