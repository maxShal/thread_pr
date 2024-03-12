package Thread.num6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class num6 {
    public static void main(String[] strings) throws InterruptedException {
        //List<Integer> list =new ArrayList<>();
        List<Integer> synList = Collections.synchronizedList(new ArrayList<>());
        Thread t1=new Thread(new CollSyn(synList,0));
        Thread t2=new Thread(new CollSyn(synList,1));
        t1.start();
        t2.start();
        t1.join();
        t2.join();

    }

}
