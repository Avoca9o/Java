package org.example;

import java.util.ArrayList;

public class MyLib {
    /**
     * Проверяет, корректно ли вводится строчная буква для выбора хода пользователем
     *
     * @param s      входная строка
     * @param border максимально возможный символ для выбора хода
     * @return да или нет
     */
    public static boolean isRightMove(String s, char border) {
        if (s.equals("zz")) {
            return true;
        }
        if (s.length() != 1) {
            return false;
        }
        return s.charAt(0) >= 'a' && s.charAt(0) < border;
    }

    /**
     * Проверяет, попадает ли точка в игровое поле для избежания IndexOutOfBoundException
     *
     * @param x линия
     * @param y столбец
     * @return да или нет
     */
    public static boolean isInField(int x, int y) {
        return x >= 0 && x < 8 && y >= 0 && y < 8;
    }

    /**
     * Возвращает цвет игрока, обратный данному
     *
     * @param ch цвет игрока
     * @return обратный цвет
     */
    public static char getOtherChar(char ch) {
        if (ch == '1') {
            return '2';
        }
        return '1';
    }

    /**
     * Проверяет, не закончилась ли игра
     *
     * @param f поле
     * @return закончилась игра или нет
     */
    public static boolean checkEnd(Field f) {
        return f.getMoves('2').isEmpty() && f.getMoves('1').isEmpty();
    }

    /**
     * Проверяет, существует ли точка в коллекции
     *
     * @param p    точка, которую нужно проверить
     * @param base коллекция, в которой нужно проверить
     * @return да или нет
     */
    public static boolean isPointInCollection(Point p, ArrayList<Point> base) {
        for (Point cmp : base) {
            if (cmp.x == p.x && cmp.y == p.y) {
                return true;
            }
        }
        return false;
    }

    public static int maxResult = 0;

    /**
     * Находит лучший ход для глупого компьютера согласно формуле
     *
     * @param f      поле
     * @param colour цвет игрока
     * @param moves  список возможных ходов
     * @return лучший ход
     */
    public static int findBestMove(Field f, char colour, ArrayList<Point> moves) {
        int posOfChosenMove = 0;
        int maximumPointsInMove = 0;
        for (int i = 0; i < moves.size(); ++i) {
            int pointsInMove = countPoints(f, colour, moves.get(i));
            if (pointsInMove > maximumPointsInMove) {
                maximumPointsInMove = pointsInMove;
                posOfChosenMove = i;
            }
        }
        return posOfChosenMove;
    }

    /**
     * Высчитывает количество набранных очков для конкретного хода
     *
     * @param f      поле
     * @param colour цвет игрока
     * @param p      точка, куда хотим сделать ход
     * @return количество очков
     */
    public static int countPoints(Field f, char colour, Point p) {
        int pointsInMove = 0;
        if (p.isEdge()) {
            pointsInMove -= 12;
        } else if (p.isBorder()) {
            pointsInMove -= 16;
        }
        for (Point tmp : f.getChanges(p.x, p.y, colour)) {
            if (tmp.isBorder()) {
                pointsInMove += 20;
            } else {
                pointsInMove += 10;
            }
        }
        return pointsInMove;
    }
}
