package Thread;

import java.util.ArrayList;

public class Remove extends Thread
{
    private ArrayList<Integer> array;
    Remove(ArrayList<Integer> array)
    {
        this.array=array;
    }
    @Override
    public void run()
    {
        int i=0;
        while(i<10000)
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
                System.out.println("Removed: "+i);
                i++;
            }
        }
    }
}
