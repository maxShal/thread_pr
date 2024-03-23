package Thread.num7;

public class Ping implements Runnable {
    private final Object obj;

    Ping(Object obj) {
        this.obj = obj;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (obj) {
                System.out.println("Ping");
                obj.notify();
                try {
                    obj.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
