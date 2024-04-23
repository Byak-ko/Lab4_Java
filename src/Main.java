public class Main {
    public static void main(String[] args) {
        Philosopher[] philosophers = new Philosopher[5];
        Fork[] forks = new Fork[5];
        for (int i = 0; i < forks.length; i++) {
            forks[i] = new Fork(i + "");
        }
        for (int i = 0; i < 5; i++) {
            Fork leftFork = forks[i];
            Fork rightFork = forks[(i + 1) % 5];

            if (i == philosophers.length - 1) {
                philosophers[i] = new Philosopher(i,rightFork, leftFork);
            } else {
                philosophers[i] = new Philosopher(i,leftFork, rightFork);
            }

            new Thread(philosophers[i]).start();
        }


    }
}