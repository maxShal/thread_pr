package Thread.num9;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Pong implements Runnable
{
    ReentrantLock lock;
    Condition condition;

    Pong(ReentrantLock lock, Condition condition)
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
                condition.signal();
                System.out.println("      Pong");
                condition.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }finally {
                lock.unlock();
            }
        }
    }
}
