package Thread;

import static org.junit.Assert.*;

public class MainTest {

    @org.junit.Test
    public void num2() throws InterruptedException {
        //num2
        Thread thread=new Thread(()->{System.out.println("myThread");});
        thread.start();
        thread.join();
        assertFalse(thread.isAlive());
    }
    @org.junit.Test
    public void Num3() throws InterruptedException {
        Thread thread1=new Thread(new MyThread1());
        Thread thread2=new Thread(new MyThread2());
        Thread thread3=new Thread(new MyThread3());
        thread1.start();thread2.start();thread3.start();
        thread1.join();thread2.join();thread3.join();
        assertFalse(thread1.isAlive());assertFalse(thread2.isAlive());assertFalse(thread3.isAlive());
    }
}