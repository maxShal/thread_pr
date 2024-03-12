package Thread.num5;

import java.util.List;

public class SynList implements Runnable
{
    private final List<Integer> list;
    private int flag;

    SynList(List<Integer> list, int flag)
    {
        this.list=list;
        this.flag=flag;
    }

    public synchronized void add()
    {
        int num=(int) (Math.random()*10);
        list.add(num);
        System.out.println("Added: "+num);
    }

    public synchronized void remove()
    {
        int num=(int) (Math.random()* list.size());
        list.remove(num);
        System.out.println("Removed: "+num);
    }
    @Override
    public void run() {
        SynList list1=new SynList(list,flag);
        if(flag ==0)
        {
            for(int i=0;i<100;i++)
            {
                list1.add();
                synchronized (list)
                {
                    list.notify();
                }
            }

        }else {
            for (int i=0;i<100;i++){
                if(list.isEmpty())
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
                list1.remove();
            }
        }


    }
}
