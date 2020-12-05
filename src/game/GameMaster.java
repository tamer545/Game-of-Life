package game;

import java.util.concurrent.ThreadLocalRandom;

public class GameMaster {

    public static final int CELLCOUNT = 512;
    public static boolean[][] cells = new boolean[CELLCOUNT][CELLCOUNT];

    int startCells = 10000;
    static int gen = 0;

    public void setup() {
        for (int i = 0; i < startCells; i++) {
            int x = random(0, CELLCOUNT);
            int y = random(0, CELLCOUNT);

            cells[x][y] = true;
        }
    }

    public static void nextGen() {
        gen++;
        System.out.println("Generation: " + gen);

        for (int x = 0; x < CELLCOUNT; x++) {
            for (int y = 0; y < CELLCOUNT; y++) {
                int neighbours = neighbours(x, y);

                //Regel 1: Wiederbeleben
                if (neighbours == 3 && !cells[x][y]) {
                    cells[x][y] = true;
                }

                //Regel 2: Unterbevölkerung
                if (neighbours < 2) {
                    cells[x][y] = false;
                }

                //Regel 3: Am Leben bleiben
                if (neighbours == 2 || neighbours == 3) {
                    //Zelle bleibt unverändert

                }

                //Regel 4: Überbevölkerung
                if (neighbours > 3) {
                    cells[x][y] = false;
                }
            }
        }

    }

    public static int neighbours(int x, int y) {
        int count = 0;

        //Starts middle right and goes on clockwise to check for neighbours
        int[] xoff = {1, 1, 0, -1, -1, -1, 0, 1};
        int[] yoff = {0, 1, 1, 1, 0, -1, -1, -1};

        for (int i = 0; i < 8; i++) {
            try {
                if (cells[x + xoff[i]][y + yoff[i]]) {
                    count++;
                }
            } catch (Exception e) {

            }
        }

        return count;
    }

    public static int random(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max);
    }

    public static int getGen() {
        return gen;
    }
}
