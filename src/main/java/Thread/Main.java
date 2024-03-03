package Thread;

import java.util.ArrayList;

public class Main
{
    public static void main(String[] strings) throws InterruptedException {
        // num 1
        System.out.println(Thread.currentThread());

        //num 2
        //впринципе тут это нне надо, смотреть надо тест
        Thread thread=new Thread(()->{System.out.println("myThread");});
        thread.start();
        thread.join();

        //num 3
        MyThread1 thread1=new MyThread1();
        MyThread2 thread2=new MyThread2();
        MyThread3 thread3=new MyThread3();
        /*
        thread1.start();thread1.join();
        thread2.start();thread2.join();
        thread3.start();thread3.join();
        ArrayList<Integer> arrayList= new ArrayList<>();*/

    }
}
