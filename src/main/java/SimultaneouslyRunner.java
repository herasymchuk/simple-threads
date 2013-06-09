/**
 * Created with IntelliJ IDEA.
 * User: Maksym
 * Date: 30.05.13
 * Time: 0:31
 * To change this template use File | Settings | File Templates.
 */
abstract public class SimultaneouslyRunner implements Runnable {

    private int id;
    private Locker lockObject;

    protected SimultaneouslyRunner(int id) {
        this.id = id;
    }

    protected SimultaneouslyRunner(int id, Locker lockObject) {
        this.id = id;
        this.lockObject = lockObject;
    }

    public int getId() {
        return id;
    }

    @Override
    public void run() {
        waitForStart();
        doJob();
        endProcess();
    }

    protected void waitForStart() {
        if(lockObject != null) {
            synchronized (lockObject) {
                try {
                    lockObject.wait();
                } catch (InterruptedException e) {}
            }
            System.out.println("[" + getId() + "] thread start.");
        }
    }

    abstract protected void doJob();

    protected void endProcess() {
        System.out.println("[" + getId() + "] thread end.");
        if(lockObject != null) {
            lockObject.decrementThreadsCounter();
        }
    }
}
