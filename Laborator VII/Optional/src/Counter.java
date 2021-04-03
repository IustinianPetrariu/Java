public class Counter extends Thread {
    public int secunde = 0; // Folosim o variabila de terminare
    public static boolean keepRunning = true;
    public int limit = 0;

    public Counter(int limit) {
        this.limit = limit;
    }

    public void run() {
        while (keepRunning) {
            try {
                Thread.sleep(1000);
                secunde++;
               // System.out.println("Au trecut: " + Integer.toString(secunde) + " sec");
                if (secunde > limit) {
                    System.out.println("time passed -> I will stop the game!");
                    keepRunning = false;
                }
            } catch (InterruptedException e) {
            }
        }
    }

}
