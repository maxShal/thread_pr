package Thread;

import java.util.ArrayList;

public class Th2 extends Thread
{
    private ArrayList<Integer> array;
    Th2(ArrayList<Integer> array)
    {
        this.array=array;
    }
    @Override
    public void run()
    {
        for (int i=10000;i>0;i--)
        {
            synchronized (array)
            {
                if(array.isEmpty())
                {
                    try {
                        array.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                array.remove((int) (Math.random()*(array.size())));
                System.out.println("Deleted: "+i);
            }
        }
    }
}
