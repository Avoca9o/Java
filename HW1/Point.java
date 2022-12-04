package org.example;

public final class Point {
    public int x, y;

    public Point(int a, int b) {
        x = a;
        y = b;
    }

    /**
     * проверяет, является ли данная точка угловой
     *
     * @return да/нет
     */
    public boolean isEdge() {
        return x == 0 && y == 0 || x == 7 && y == 7 || x == 0 && y == 7 || x == 7 && y == 0;
    }

    /**
     * проверяет, является ли данная точка кромочной
     *
     * @return да/нет
     */
    public boolean isBorder() {
        return x == 0 || y == 0 || x == 7 || y == 7;
    }
}
