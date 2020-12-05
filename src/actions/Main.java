package actions;

import game.GameClock;
import game.GameMaster;
import gui.Gui;

public class Main {

    public static void main(String[] args) {
        Gui g = new Gui();
        GameMaster gm = new GameMaster();
        GameClock gc = new GameClock();


        gm.setup();
        g.create();
        gc.start();
    }
}
