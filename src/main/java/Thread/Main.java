package Thread;

import java.util.ArrayList;

public class Main
{
    public static class DoubleSynch extends Thread
    {
        private ArrayList<Integer> array;

        DoubleSynch(ArrayList<Integer> array){this.array=array;}

        @Override
        public void run()
        {
            Add add=new Add(array);
            Remove remove=new Remove(array);
            add.start();
            remove.start();
        }

    }
    public static void main(String[] strings) throws InterruptedException {
        //num 1
        //System.out.println(Thread.currentThread());
        //num 4
        ArrayList<Integer> array= new ArrayList<>();
        /*Th1 th1=new Th1(array);
        Th2 th2 = new Th2(array);
        th2.start();
        th1.start();
*/
        //num5
        DoubleSynch doubleSynch=new DoubleSynch(array);
        doubleSynch.start();
    }
}
