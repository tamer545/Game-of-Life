package game;


public class GameClock extends Thread {

    public static boolean running = true;

    public void run() {
        while (running) {
            try {
                sleep(50);
                GameMaster.nextGen();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}
