/**
 * Created with IntelliJ IDEA.
 * User: Maksym
 * Date: 26.05.13
 * Time: 16:39
 * To change this template use File | Settings | File Templates.
 */
public class Main {

    //static public Locker lockObject = new Locker();

    static public void main(String[] args) {
        Locker lockObject1 = new Locker();
        lockObject1.setThreadsCounter(3);

        Locker lockObject2 = new Locker();
        lockObject2.setThreadsCounter(3);

        SimultaneouslyExecutor executor1 = new SimultaneouslyExecutor(lockObject1,
                new PrimeCalculationRunner(1, 100000, lockObject1),
                new PrimeCalculationRunner(2, 20000, lockObject1),
                new FibonacciCalculationRunner(3, 40000000, lockObject1));

        SimultaneouslyExecutor executor2 = new SimultaneouslyExecutor(lockObject2,
                new PrimeCalculationRunner(4, 200000, lockObject2),
                new PrimeCalculationRunner(5, 50000, lockObject2),
                new FibonacciCalculationRunner(6, 50000000, lockObject2));

        try {
            executor1.execute();
            synchronized (lockObject1) {
                lockObject1.wait();
                System.out.println("All threads ended!");
            }

            executor2.execute();
            System.out.println("All threads started!");

        } catch (InterruptedException e) {
            System.out.println("Error! " + e);
        }
    }
}
