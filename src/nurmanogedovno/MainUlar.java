package nurmanogedovno;

import java.util.LinkedList;
import java.util.Scanner;

public class MainUlar {

    private static int arah = 4;//1= Nort; 2 = East; 3 = South; 4 = West

    private static int[][] papan = {
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
    };

    static LinkedList<Posisi> ular = new LinkedList<>();

    private static void bikinUlar() {
        ular.add(new Posisi(2, 4));
        ular.add(new Posisi(2, 5));
        ular.add(new Posisi(2, 6));
    }

    private static void bergerak() {
        Posisi kepala = ular.get(0);
        Posisi posisiBaru = kepala;
        if (arah == 1) {
            int newX = kepala.x - 1;
            int newY = kepala.y;
            posisiBaru = new Posisi(newX, newY);
        } else if (arah == 2) {
            int newX = kepala.x;
            int newY = kepala.y + 1;
            posisiBaru = new Posisi(newX, newY);
        } else if (arah == 3) {
            int newX = kepala.x + 1;
            int newY = kepala.y;
            posisiBaru = new Posisi(newX, newY);
        } else if (arah == 4) {
            int newX = kepala.x;
            int newY = kepala.y - 1;
            posisiBaru = new Posisi(newX, newY);
        }
        ular.addFirst(posisiBaru);
        ular.removeLast();
    }

    private static void letakkanUlarDiPapan() {
        for (int k = 0; k < ular.size(); k++) {
            Posisi posisiUlar = ular.get(k);
            int x = posisiUlar.x;
            int y = posisiUlar.y;
            papan[x][y] = 1;
        }
    }

    private static void cetakPapan() {
        for (int i = 0; i < papan.length; i++) {
            for (int j = 0; j < papan[i].length; j++) {
                int value = papan[i][j];
                if (value == 0) {
                    System.out.print(" - ");
                } else if (value == 1) {
                    System.out.print(" O ");
                }
            }
            System.out.println();
        }
    }

    private static void resetPapan() {
        for (int i = 0; i < papan.length; i++) {
            for (int j = 0; j < papan[i].length; j++) {
                papan[i][j] = 0;
            }
        }
    }

    public static void main(String[] args) {
        bikinUlar();
        letakkanUlarDiPapan();
        cetakPapan();
        boolean running = true;
        while (running) {
            Scanner sc = new Scanner(System.in);
            System.out.print("OPTION (W|A|S|D): ");
            String pilihan = sc.nextLine();
            if (pilihan.equalsIgnoreCase("W")) {
                arah = 1;
            } else if (pilihan.equalsIgnoreCase("D")) {
                arah = 2;
            } else if (pilihan.equalsIgnoreCase("S")) {
                arah = 3;
            } else if (pilihan.equalsIgnoreCase("A")) {
                arah = 4;
            }

            resetPapan();
            bergerak();
            letakkanUlarDiPapan();
            cetakPapan();

        }
    }
}
