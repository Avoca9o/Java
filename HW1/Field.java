package org.example;

import java.util.ArrayList;

public final class Field {
    public Field() {
        base = new char[8][8];
        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                base[i][j] = ' ';
            }
        }
        base[3][3] = '2';
        base[4][4] = '2';
        base[3][4] = '1';
        base[4][3] = '1';
    }

    public Field(Field f) {
        base = new char[8][8];
        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                base[i][j] = f.getChar(i, j);
            }
        }
    }

    @Override
    public String toString() {
        System.out.println("Текущий счет:\nPlayer1: " + count('1') +
                "\nPlayer2: " + count('2'));
        System.out.println("\n ------------------------------ ");
        for (int i = 0; i < 8; ++i) {
            System.out.print("| ");
            for (int j = 0; j < 8; ++j) {
                System.out.print(base[i][j] + " | ");
            }
            System.out.println();
        }
        System.out.print(" ------------------------------ ");
        return "";
    }

    /**
     * Подсчитывает количество фишек одного из игроков на поле
     *
     * @param ch цвет игрока
     * @return количество фишек
     */
    public int count(char ch) {
        int ans = 0;
        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                if (ch == base[i][j]) {
                    ++ans;
                }
            }
        }
        return ans;
    }

    /**
     * Высчитывает список возможных ходов для данного игрока
     *
     * @param colour цвет игрока
     * @return список ходов в виде списка точек
     */
    public ArrayList<Point> getMoves(char colour) {
        char other;
        if (colour == '1') {
            other = '2';
        } else {
            other = '1';
        }
        ArrayList<Point> out = new ArrayList<>();
        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                if (base[i][j] != colour) {
                    continue;
                }
                int x, y;
                for (int k = 0; k < 8; ++k) {
                    x = i;
                    y = j;
                    while (MyLib.isInField(x + kx[k], y + ky[k])
                            && base[x + kx[k]][y + ky[k]] == other) {
                        x += kx[k];
                        y += ky[k];
                    }
                    if ((x != i || y != j) && MyLib.isInField(x + kx[k], y + ky[k])
                            && base[x + kx[k]][y + ky[k]] == ' ') {
                        Point temp = new Point(x + kx[k], y + ky[k]);
                        if (!MyLib.isPointInCollection(temp, out)) {
                            out.add(new Point(x + kx[k], y + ky[k]));
                        }
                    }
                }
            }
        }
        return out;
    }

    /**
     * Высчитывает список точек, которые нужно поменять при данном ходе для данного игрока
     *
     * @param i      линия
     * @param j      столбец
     * @param colour цвет игрока
     * @return списко точек
     */
    public ArrayList<Point> getChanges(int i, int j, char colour) {
        char other = MyLib.getOtherChar(colour);
        ArrayList<Point> changes = new ArrayList<>();
        changes.add(new Point(i, j));
        int x, y;
        for (int k = 0; k < 8; ++k) {
            x = i;
            y = j;
            while (MyLib.isInField(x + kx[k], y + ky[k])
                    && base[x + kx[k]][y + ky[k]] == other) {
                x += kx[k];
                y += ky[k];
            }
            if ((x != i || y != j) && MyLib.isInField(x + kx[k], y + ky[k])
                    && base[x + kx[k]][y + ky[k]] == colour) {
                while (x != i || y != j) {
                    changes.add(new Point(x, y));
                    x -= kx[k];
                    y -= ky[k];
                }
            }
        }
        return changes;
    }

    public void change(int i, int j, char colour) {
        if (colour != '2' && colour != '1') {
            base[i][j] = colour;
            return;
        }

        ArrayList<Point> changes = getChanges(i, j, colour);

        for (Point p : changes) {
            base[p.x][p.y] = colour;
        }
    }

    public char getChar(int i, int j) {
        return base[i][j];
    }

    private final char[][] base;
    private final static int[] kx = {-1, -1, -1, 0, 1, 1, 1, 0};
    private final static int[] ky = {-1, 0, 1, 1, 1, 0, -1, -1};
}
