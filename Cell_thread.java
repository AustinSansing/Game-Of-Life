public class Cell_thread extends Thread {
    public ICell Ithread;

    public Cell_thread (ICell cell) {
        Ithread = cell;
    }

    public void run() { // run functions needed for threading
        Ithread.run();
    }
}
