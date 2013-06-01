/**
 * Created with IntelliJ IDEA.
 * User: Maksym
 * Date: 27.05.13
 * Time: 22:54
 * To change this template use File | Settings | File Templates.
 */
public class Locker {
    private int threadsCounter;

    public int getThreadsCounter() {
        return threadsCounter;
    }

    synchronized public void setThreadsCounter(int threadsCounter) {
        this.threadsCounter = threadsCounter;
    }

    synchronized public void decrementThreadsCounter() {
        threadsCounter--;
        if(threadsCounter == 0) {
            notify();
        }
    }
}
