package Thread.num7;

public class Pong implements Runnable {
    private final Object obj;
    private boolean flag;

    public Pong(Object obj) {
        this.obj = obj;
    }

    @Override
    public void run() {
        //flag =true;
        while (true) {
            synchronized (obj) {
                obj.notify();
                System.out.println("   Pong");
                try {
                    obj.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                /*if(flag)
                {
                }*/
                //flag=true;
            }
        }
    }
}
