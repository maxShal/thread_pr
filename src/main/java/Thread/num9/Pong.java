package Thread.num9;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Pong implements Runnable {
    ReentrantLock lock;
    Condition condition;
    Ping ping;

    Pong(ReentrantLock lock, Condition condition, Ping ping) {
        this.lock = lock;
        this.condition = condition;
        this.ping = ping;
    }

    @Override
    public void run() {
        lock.lock();
        try {
            condition.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
        while (true) {
            lock.lock();
            try {
                condition.signal();
                System.out.println("      Pong");
                condition.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        }
    }
}
