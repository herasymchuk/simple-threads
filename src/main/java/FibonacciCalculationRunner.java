/**
 * Created with IntelliJ IDEA.
 * User: Maksym
 * Date: 26.05.13
 * Time: 16:53
 * To change this template use File | Settings | File Templates.
 */
public class FibonacciCalculationRunner extends SimultaneouslyRunner {

    private int limit;

    public FibonacciCalculationRunner(int id, int limit) {
        super(id);
    }

    public FibonacciCalculationRunner(int id, int limit, Locker lockObject) {
        super(id, lockObject);
        this.limit = limit;
    }

    @Override
    protected void doJob() {
        System.out.println("    [" + getId() + "] Perform Fibonacci number's calculation");
        //System.out.println("Printing Fibonanacci number from 1 to " + limit);
        int curNumber = 0;
        for(int i = 0; i < limit; i++) {
            if(curNumber < limit) {
                curNumber = getFibonacciNumber(i);
                //System.out.print(curNumber + " ");
            }
        }
    }

    private int getFibonacciNumber(int n) {
        if(n < 2) {
            return n;
        }
        return getFibonacciNumber(n - 2) + getFibonacciNumber(n - 1);
    }
}
