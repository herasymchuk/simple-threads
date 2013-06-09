import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Maksym
 * Date: 30.05.13
 * Time: 0:06
 * To change this template use File | Settings | File Templates.
 */
public class SimultaneouslyExecutor {

    private ArrayList<Thread> threads = new ArrayList<Thread>();
    private final Locker lockObject;


    public SimultaneouslyExecutor(Locker lockObject, SimultaneouslyRunner... runners) {
        this.lockObject = lockObject;
        for(SimultaneouslyRunner runner : runners) {
            this.threads.add(new Thread(runner));
        }
    }

    public void execute() {
        for(Thread t : threads) {
            t.start();
        }
        try {
            Thread.sleep(50);
        } catch (InterruptedException ignored) {}
        synchronized (lockObject) {
            lockObject.notifyAll();
        }
    }
}
