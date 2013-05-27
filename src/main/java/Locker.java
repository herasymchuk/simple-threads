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

    public void setThreadsCounter(int threadsCounter) {
        this.threadsCounter = threadsCounter;
    }

    public void decrementThreadsCounter() {
        threadsCounter--;
    }
}
