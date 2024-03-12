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

    public void remove()
    {
        int num=(int) (Math.random()* list.size());
        list.remove(num);
        System.out.println("Removed: "+num);
    }
    @Override
    public void run() {
        List<Integer> synList = Collections.synchronizedList(list);
        CollSyn collist=new CollSyn(synList,flag);
        if(flag ==0)
        {
            for(int i=0;i<100;i++)
            {
                collist.add();
            }
        }
        //if
        if(!list.isEmpty())
        {
            for(int i=0;i<100;i++) {
                while (!list.isEmpty()){
                    collist.remove();
                }
            }
        }


    }
}
