/**
 * Created with IntelliJ IDEA.
 * User: Maksym
 * Date: 26.05.13
 * Time: 16:53
 * To change this template use File | Settings | File Templates.
 */
public class FibonacciCalculationThread implements Runnable {

    private Locker lockObject;
    private int id;
    int limit;

    public FibonacciCalculationThread(int id, int limit) {
        this.limit = limit;
        this.id = id;
    }

    public FibonacciCalculationThread(int id, int limit, Locker lockObject) {
        this.lockObject = lockObject;
        this.limit = limit;
        this.id = id;
    }

    @Override
    public void run() {
        if(lockObject != null) {
            synchronized (lockObject) {
                System.out.println("[sync][" + id + "] Fibonacci numbers calculation thread start.");
                lockObject.decrementThreadsCounter();
                lockObject.notify();
            }
        } else {
            System.out.println("[" + id + "] Fibonacci numbers calculation thread start.");
        }
        System.out.println("    [" + id + "] Perform Fibonacci number's calculation");
        //System.out.println("Printing Fibonanacci number from 1 to " + limit);
        int curNumber = 0;
        for(int i = 0; i < limit; i++) {
            if(curNumber < limit) {
                curNumber = getFibonacciNumber(i);
                //System.out.print(curNumber + " ");
            }
        }
        System.out.println("[" + id + "] Fibonacci numbers calculation thread end.");
    }

    private int getFibonacciNumber(int n) {
        if(n < 2) {
            return n;
        }
        return getFibonacciNumber(n - 2) + getFibonacciNumber(n - 1);
    }
}
