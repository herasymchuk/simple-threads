/**
 * Created with IntelliJ IDEA.
 * User: Maksym
 * Date: 26.05.13
 * Time: 16:45
 * To change this template use File | Settings | File Templates.
 */
public class PrimeCalculationThread implements Runnable {

    private Integer counter;

    public PrimeCalculationThread(Integer counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        synchronized (counter) {
            System.out.println("[1] Prime numbers calculation thread start.");
            counter--;
            counter.notify();
        }
        int limit = 100000;
        System.out.println("Printing prime number from 1 to " + limit);
        for(int number = 2; number<=limit; number++){
            if(isPrime(number)){
                //System.out.print(number + " ");
            }
        }
        System.out.println("[1] Prime numbers calculation thread end.");
    }

    private boolean isPrime(int number){
        for(int i=2; i<number; i++){
            if(number%i == 0){
                return false; //number is divisible so its not prime
            }
        }
        return true; //number is prime now
    }
}
