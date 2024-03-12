package Thread.num6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollSyn implements Runnable
{
    private List<Integer> list;
    private int flag;

    CollSyn(List<Integer> list, int flag)
    {
        this.list=list;
        this.flag=flag;
    }
    public void add()
    {
        int num=(int) (Math.random()*10);
        list.add(num);
        System.out.println("Added: "+num);
    }
    public int size()
    {
        return list.size();
    }
    public void remove()
    {
        int num=(int) (Math.random()* list.size());
        list.remove(num);
        System.out.println("Removed: "+num);
    }
    @Override
    public void run() {
       // List<Integer> synList = Collections.synchronizedList(new ArrayList<>());
        CollSyn collSyn=new CollSyn(list,flag);
        if(flag==0)
        {
            for(int i=0;i<10;i++)
            {
                collSyn.add();
                synchronized (list)
                {
                    list.notify();
                }
            }
        }else {
            for(int i=0;i<10;i++)
            {
                if(collSyn.size()==0)
                {
                    synchronized (list)
                    {
                        try {
                            list.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
                collSyn.remove();
            }
        }
    }
}
