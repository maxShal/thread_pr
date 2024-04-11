package Thread.num10;

import java.util.List;

public class HashThread<K,V> implements Runnable{

    private final int flag;

    private NewHash<K,V> newHash;
    private K key;
    private V string;

    public HashThread(NewHash<K,V> newHash,int flag, K key, V s) {
        this.key=key;
        this.string=s;
        this.newHash=newHash;
        this.flag = flag;
    }


    @Override
    public void run() {
        if(flag==0)
        {
            newHash.readGet(key);
            System.out.println("Readed ");
        }
        if(flag==1)
        {
            newHash.writePut(key,string);
            System.out.println("Puted ");
        }
        if (flag==2)
        {
            newHash.writeRemove(key,string);
            System.out.println("Removed ");
        }
    }
}
