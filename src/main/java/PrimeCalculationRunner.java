/**
 * Created with IntelliJ IDEA.
 * User: Maksym
 * Date: 26.05.13
 * Time: 16:45
 * To change this template use File | Settings | File Templates.
 */
public class PrimeCalculationRunner extends SimultaneouslyRunner {

    private int limit;

    public PrimeCalculationRunner(int id, int limit) {
        super(id);
        this.limit = limit;
    }

    public PrimeCalculationRunner(int id, int limit, Locker lockObject) {
        super(id, lockObject);
        this.limit = limit;
    }

    @Override
    protected void doJob() {
        System.out.println("    [" + getId() + "] Perform prime number's calculation");
        //System.out.println("Printing prime number from 1 to " + limit);
        for(int number = 2; number<=limit; number++){
            if(isPrime(number)){
                //System.out.print(number + " ");
            }
        }
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
