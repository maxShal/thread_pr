package Thread.num7;

public class num7 {
    public static void main(String[] strings) throws InterruptedException {
        Object obj =new Object();
        Ping ping = new Ping(obj);
        Pong pong = new Pong(obj);
        Thread thread1 = new Thread(ping);
        Thread thread2 = new Thread(pong);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }

}
