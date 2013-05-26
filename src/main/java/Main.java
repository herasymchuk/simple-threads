/**
 * Created with IntelliJ IDEA.
 * User: Maksym
 * Date: 26.05.13
 * Time: 16:39
 * To change this template use File | Settings | File Templates.
 */
public class Main {

    static private Integer threadsCount = new Integer(2);

    static public void main(String[] args) {
        synchronized (threadsCount) {
            Thread prime = new Thread(new PrimeCalculationThread(threadsCount));
            Thread fibonacci = new Thread(new FibonacciCalculationThread(threadsCount));

            prime.start();
            fibonacci.start();

            try {
                while(threadsCount > 0) {
                    threadsCount.wait();
                }
                System.out.println("All threads started!");
                prime.join();
                fibonacci.join();
            } catch (InterruptedException e) {
                System.out.println("Error!");
            }



        }

    }
}
