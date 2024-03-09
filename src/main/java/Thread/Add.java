package Thread;

import java.util.ArrayList;

public class Add extends Thread
{
    private ArrayList<Integer> array;

    Add(ArrayList<Integer> array){this.array=array;}
    @Override
    public void run() {
        int i=0;
        while(i<10000)
        {
            synchronized (array)
            {
                array.add((int) (Math.random()*10));
                System.out.println("Added: "+i);
                array.notify();
                i++;
            }
        }
    }
}
