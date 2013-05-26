/**
 * Created with IntelliJ IDEA.
 * User: Maksym
 * Date: 26.05.13
 * Time: 16:53
 * To change this template use File | Settings | File Templates.
 */
public class FibonacciCalculationThread implements Runnable {

    private Integer counter;

    public FibonacciCalculationThread(Integer counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        synchronized (counter) {
            System.out.println("[2] Fibonacci numbers calculation thread start.");
            counter--;
            counter.notify();
        }
        int limit = 10000000;
        //System.out.println("Printing Fibonanacci number from 1 to " + limit);
        int curNumber = 0;
        for(int i = 0; i < limit; i++) {
            if(curNumber < limit) {
                curNumber = getFibonacciNumber(i);
                //System.out.print(curNumber + " ");
            }
        }
        System.out.println("[2] Fibonacci numbers calculation thread end.");
    }

    private int getFibonacciNumber(int n) {
        if(n < 2) {
            return n;
        }
        return getFibonacciNumber(n - 2) + getFibonacciNumber(n - 1);
    }
}
