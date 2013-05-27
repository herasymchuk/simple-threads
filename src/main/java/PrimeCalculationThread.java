/**
 * Created with IntelliJ IDEA.
 * User: Maksym
 * Date: 26.05.13
 * Time: 16:45
 * To change this template use File | Settings | File Templates.
 */
public class PrimeCalculationThread implements Runnable {

    private Locker lockObject;
    private int id;
    private int limit;

    public PrimeCalculationThread(int id, int limit) {
        this.limit = limit;
        this.id = id;
    }

    public PrimeCalculationThread(int id, int limit, Locker lockObject) {
        this.lockObject = lockObject;
        this.limit = limit;
        this.id = id;
    }

    @Override
    public void run() {
        if(lockObject != null) {
            synchronized (lockObject) {
                System.out.println("[sync][" + id + "] Prime numbers calculation thread start.");
                lockObject.decrementThreadsCounter();
                lockObject.notify();
            }
        } else {
            System.out.println("[" + id + "] Prime numbers calculation thread start.");
        }

        System.out.println("    [" + id + "] Perform prime number's calculation");
        //System.out.println("Printing prime number from 1 to " + limit);
        for(int number = 2; number<=limit; number++){
            if(isPrime(number)){
                //System.out.print(number + " ");
            }
        }
        System.out.println("[" + id + "] Prime numbers calculation thread end.");
    }

    private boolean isPrime(int number){
        for(int i=2; i<number; i++){
            if(number%i == 0){
                return false;
            }
        }
        return true;
    }
}
