package Thread.num9;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class num9
{
    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        Thread th1=new Thread(new Ping(lock,condition));
        Thread th2=new Thread(new Pong(lock,condition));
        th1.start();
        th2.start();
        th1.join();
        th2.join();
    }
}
