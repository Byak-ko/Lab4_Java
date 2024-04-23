public class Philosopher implements Runnable {

    private final int id;
    private final Object leftFork;
    private final Object rightFork;

    Philosopher(Integer id, Fork left, Fork right) {
        this.id = id;
        this.leftFork = left;
        this.rightFork = right;
    }

    private void doAction(String action) throws InterruptedException {
        System.out.println("Philosopher" + id + " " + action);
        Thread.sleep(((int) (Math.random() * 3 * 1000)));
    }

    @Override
    public void run() {
        try {
            while (true) {
                doAction(": Thinking");
                synchronized (leftFork) {
                    doAction(": Picked up left fork");
                    synchronized (rightFork) {
                        doAction(": Picked up right fork - eating");
                        doAction(": Picked up right fork - eating");
                        doAction(": Put down right fork");
                    }
                    doAction(": Put down left fork. Returning to thinking");
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}