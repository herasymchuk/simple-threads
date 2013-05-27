/**
 * Created with IntelliJ IDEA.
 * User: Maksym
 * Date: 26.05.13
 * Time: 16:39
 * To change this template use File | Settings | File Templates.
 */
public class Main {

    static public Locker lockObject = new Locker();

    static public void main(String[] args) {
        lockObject.setThreadsCounter(3);
        Thread primeThread1 = new Thread(new PrimeCalculationThread(1, 100000));
        Thread primeThread2 = new Thread(new PrimeCalculationThread(2, 200000));
        Thread fibonacciThread = new Thread(new FibonacciCalculationThread(3, 100000000));

        Thread primeSyncThread1 = new Thread(new PrimeCalculationThread(4, 200000, lockObject));
        Thread primeSyncThread2 = new Thread(new PrimeCalculationThread(5, 50000, lockObject));
        Thread fibonacciSyncThread = new Thread(new FibonacciCalculationThread(6, 50000000, lockObject));

        primeThread1.start();
        primeThread2.start();
        fibonacciThread.start();

        try {
            primeThread1.join();
            primeThread2.join();
            fibonacciThread.join();

            primeSyncThread1.start();
            primeSyncThread2.start();
            fibonacciSyncThread.start();

            synchronized (lockObject) {
                try {
                    while(lockObject.getThreadsCounter() > 0) {
                        lockObject.wait();
                    }
                } catch (InterruptedException e) {
                    System.out.println("Error! " + e);
                }
            }
            System.out.println("All threads started!");

            primeSyncThread1.join();
            primeSyncThread2.join();
            fibonacciSyncThread.join();

        } catch (InterruptedException e) {
            System.out.println("Error! " + e);
        }
    }
}
