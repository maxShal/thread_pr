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
        public void run() {
            synchronized (array)
            {
                while (array.size()<=10000-1)
                {
                    array.add((int) (Math.random()*(10)));
                }
                System.out.println("1 array: "+array);
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
        public void run() {
           synchronized (array)
           {
                while (!array.isEmpty())
                {
                    array.remove((int) (Math.random()*(array.size())));
                }
                System.out.println("2 array: "+array);
           }
        }
    }
    public static void main(String[] strings) throws InterruptedException {
        // num 1
        //System.out.println(Thread.currentThread());
        //num 4
        ArrayList<Integer> array= new ArrayList<>();
        Th1 th1=new Th1(array);
        Th2 th2 = new Th2(array);
        th1.start();
        th2.start();
    }
}
