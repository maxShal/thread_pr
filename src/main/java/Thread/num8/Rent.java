package Thread.num8;

import Thread.num5.SynList;

import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Rent implements Runnable
{
    private final ReentrantLock lock;
    private final Condition condition;

    private final List<Integer> list;
    private final int flag;

    public Rent(List<Integer> list, int flag, Condition condition, ReentrantLock lock) {
        this.list = list;
        this.flag =flag;
        this.condition=condition;
        this.lock=lock;
    }

    public void add()
    {

        int num=(int) (Math.random()*10);
        lock.lock();
        try
        {
            list.add(num);
            System.out.println("Added: "+num);
            condition.signal();
        }finally {
            lock.unlock();
        }
    }

    public  void remove()
    {
        int num=(int) (Math.random()* list.size());
        lock.lock();
        try
        {
            if(list.isEmpty())
            {
                condition.await();
            }
            list.remove(num);
            System.out.println("Removed: "+num);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            lock.unlock();
        }
    }
    @Override
    public void run()
    {
        if(flag==0)
        {
            for(int i=0;i<10;i++) {
                add();
            }

        }else
        {
            for(int i=0;i<10;i++) {
                remove();
            }
        }
    }
}
