package org.example;

import java.util.ArrayList;

public final class Game {
    public Game(String mode) {
        System.out.println("You've started a new game!");
        System.out.println("Лучший результат игрока в этой игровой сессии: " + MyLib.maxResult);
        if (mode.equals("1")) {
            player1 = new Person();
            player2 = new FoolishComputer();
        } else if (mode.equals("2")) {
            player1 = new Person();
            player2 = new SmartComputer();
        } else {
            player1 = new Person();
            player2 = new Person();
        }
        memory = new ArrayList<Field>();
        memory.add(new Field());
    }

    public void run() {
        boolean flag = true;
        while (flag) {
            try {
                if (MyLib.checkEnd(memory.get(memory.size() - 1))) {
                    throw new EndOfGameException();
                }
                Field temp;
                if (isFirst) {
                    System.out.println("Ход первого игрока\n");
                    temp = player1.makeMove(memory.get(memory.size() - 1), '1');
                    memory.add(temp);
                    Thread.sleep(1500);
                    isFirst = !isFirst;
                } else {
                    if (player2 instanceof Computer) {
                        System.out.println("Ход компьютера, ему надо подумать...");
                        Thread.sleep(1500);
                    } else {
                        System.out.println("Ход второго игрока\n");
                    }
                    temp = player2.makeMove(memory.get(memory.size() - 1), '2');
                    memory.add(temp);
                    Thread.sleep(1500);
                    isFirst = !isFirst;
                }

            } catch (EndOfGameException eog) {
                int x = memory.get(memory.size() - 1).count('1');
                int y = memory.get(memory.size() - 1).count('2');
                System.out.println("Игра закончена. Player 1: " + x + "  Player 2: " + y);
                if (x > y) {
                    System.out.println("Поздравляем! первый игрок победил");
                } else if (x < y) {
                    System.out.println("Поздравляем! второй игрок победил");
                } else {
                    System.out.println("Ничья!");
                }
                System.out.println("конец игры");
                if (player1 instanceof Person && x > MyLib.maxResult) {
                    MyLib.maxResult = x;
                }
                if (player2 instanceof Person && y > MyLib.maxResult) {
                    MyLib.maxResult = y;
                }
                flag = false;
            } catch (LastMoveCancelledException lmc) {
                if (memory.size() == 1) {
                    System.out.println("Ходов пока не было, отмена хода невозможна");
                    continue;
                }
                if (player2 instanceof Computer) {
                    memory.remove(memory.size() - 1);
                    memory.remove(memory.size() - 1);
                } else {
                    memory.remove(memory.size() - 1);
                    isFirst = !isFirst;
                }
                System.out.println("Ход успешно отменен");
            } catch (CantMakeMoveException cmm) {
                System.out.println("Нет возможных ходов, ход переходит другому игроку");
                isFirst = !isFirst;
            } catch (Throwable th) {
                flag = false;
                System.out.println("Something went wrong");
            }
        }

    }


    final private Player player1;
    final private Player player2;
    private boolean isFirst = true;
    private final ArrayList<Field> memory;
}
