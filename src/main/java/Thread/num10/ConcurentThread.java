package Thread.num10;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurentThread<K,V> implements Runnable{
    private final int flag;
    private ConcurrentHashMap<K,V> newHash;
    private K key;
    private V string;

    public ConcurentThread(ConcurrentHashMap<K,V> newHash,int flag, K key, V s) {
        this.flag = flag;
        this.key=key;
        this.string=s;
        this.newHash=newHash;
    }

    @Override
    public void run() {
        if(flag==0)
        {
            newHash.get(key);
            System.out.println("Readed ");
        }
        if(flag==1)
        {
            newHash.put(key,string);
            System.out.println("Puted ");
        }
        if (flag==2)
        {
            newHash.remove(key,string);
            System.out.println("Removed ");
        }
    }
}
