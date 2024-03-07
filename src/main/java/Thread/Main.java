package Thread;

import java.util.ArrayList;

public class Main
{

    public static class Th1 extends Thread
    {
        private ArrayList<Integer> array;
        Th1(ArrayList<Integer> array)
        {
            this.array=array;
        }
        @Override
        public void run()
        {
            int i=0;
                while (i<10000)
                {
                    synchronized (array)
                    {
                        array.add((int) (Math.random()*(10)));
                        System.out.println("Added: "+i);

                        array.notify();
                        i++;

                    }
                }

        }
    }

    public static class Th2 extends Thread
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
    public static void main(String[] strings) throws InterruptedException {
        //num 1
        //System.out.println(Thread.currentThread());
        //num 4
        ArrayList<Integer> array= new ArrayList<>();
        Th1 th1=new Th1(array);
        Th2 th2 = new Th2(array);
        th2.start();
        th1.start();

    }
}
