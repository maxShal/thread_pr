package Thread.num5;

import java.util.ArrayList;
import java.util.List;

public class Num5
{
    public static void main(String[] strings) throws InterruptedException {
        List<Integer> list=new ArrayList<>();
        Thread t1=new Thread(new SynList(list,0));
        Thread t2 =new Thread(new SynList(list,1));
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(list.size());
    }

}
