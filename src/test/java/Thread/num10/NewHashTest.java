package Thread.num10;

import org.junit.Test;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;

import static org.junit.Assert.*;

public class NewHashTest {
    HashMap<Integer,String> map1;
    HashMap<Integer,String> map2;
    HashMap<Integer,String> map3;
    HashMap<Integer,String> map4;

    List<HashMap<Integer,String>> list= new ArrayList<>();

    ArrayList<Integer> list1;
    NewHash newHash=new NewHash(list);

    Thread thread1 = new Thread(new HashThread(newHash, 1,2, "thread1"));
    Thread thread2 = new Thread(new HashThread(newHash, 2,2, "thread2"));
    Thread thread3 = new Thread(new HashThread(newHash, 0,2, "thread3"));
    Thread thread4 = new Thread(new HashThread(newHash, 1,6, "thread4"));
    Thread thread5 = new Thread(new HashThread(newHash, 2,6, "thread5"));
    Thread thread6 = new Thread(new HashThread(newHash, 0,6, "thread6"));
    Thread thread7 = new Thread(new HashThread(newHash, 0,8, "thread7"));
    Thread thread8 = new Thread(new HashThread(newHash, 1,8, "thread8"));
    Thread thread9 = new Thread(new HashThread(newHash, 2,8, "thread9"));
    Thread thread10 = new Thread(new HashThread(newHash, 0,5, "thread10"));
    Thread thread11 = new Thread(new HashThread(newHash, 0,4, "thread11"));

    @Test
    public void readGet() throws InterruptedException {
        map1=new HashMap<>();
        map1.put(1,"First");
        map1.put(2,"Second");
        map1.put(3,"Third");
        map2=new HashMap<>();
        map2.put(4,"Fired");
        map2.put(5,"Fife");
        map2.put(6,"Six");
        map3=new HashMap<>();
        map3.put(7,"Seven");
        map3.put(8,"Eight");
        map3.put(9,"Nine");
        map4=new HashMap<>();
        map4.put(10,"Ten");
        map4.put(11,"Eleven");
        map4.put(12,"Twelve");

        list.add(map1);
        list.add(map2);
        list.add(map3);
        list.add(map4);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        thread7.start();
        thread8.start();
        thread9.start();
        thread10.start();
        thread11.start();

        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();
        thread5.join();
        thread6.join();
        thread7.join();
        thread8.join();
        thread9.join();
        thread10.join();
        thread11.join();

    }
}