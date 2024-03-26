package Thread.num8;

import Thread.num5.SynList;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Num8 {

    public static void main(String[] strings) throws InterruptedException {
        List<Integer> list = new ArrayList<>();
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        Thread t1 = new Thread(new Rent(list, 0, condition, lock));
        Thread t2 = new Thread(new Rent(list, 1, condition, lock));
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(list.size());

    }
}
