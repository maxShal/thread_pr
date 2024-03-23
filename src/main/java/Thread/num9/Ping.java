package Thread.num9;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Ping implements Runnable
{
    ReentrantLock lock;
    Condition condition;

    Ping(ReentrantLock lock, Condition condition)
    {
        this.lock=lock;
        this.condition=condition;
    }
    @Override
    public void run() {
        while(true)
        {
            lock.lock();
            try
            {
                System.out.println("Ping");
                condition.signal();
                condition.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }finally {
                lock.unlock();
            }
        }
    }
}
