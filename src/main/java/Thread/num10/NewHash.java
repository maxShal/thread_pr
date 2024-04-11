package Thread.num10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.locks.*;

public class NewHash<K,V>
{
    List<HashMap<K,V>> list;

    List<Lock> locksWrite=new ArrayList<>();
    List<Lock> locksRead=new ArrayList<>();


    NewHash(List<HashMap<K,V>> list)
    {
        this.list=list;
        for(int i=0;i<4;i++)
        {
            ReadWriteLock lock = new ReentrantReadWriteLock();
            locksWrite.add(i, lock.writeLock());
        }
        for(int i=0;i<4;i++)
        {
            ReadWriteLock lock = new ReentrantReadWriteLock();
            locksRead.add(i, lock.readLock());
        }
    }

    public V readGet(K key)
    {
        int hash = Objects.hashCode(key);
        int index = hash%list.size();
        HashMap<K,V> map=list.get(index);

        try
        {
            locksRead.get(index).lock();
            return map.get(key);

        }finally {
            locksRead.get(index).unlock();
        }
    }

    public void writePut(K key, V s)
    {
        int hash = Objects.hashCode(key);
        int index = hash%list.size();
        HashMap<K,V> map=list.get(index);
        try {
            locksWrite.get(index).lock();
            //writeLock.lock();
            map.put(key, s);
        }finally {
            locksWrite.get(index).unlock();
            //writeLock.unlock();
        }
    }

    public V writeRemove(K key, V s)
    {
        int hash = Objects.hashCode(key);
        int index = hash%list.size();
        HashMap<K,V> map=list.get(index);
        try{
            locksWrite.get(index).lock();
            return map.put(key, s);
        }finally {
            locksWrite.get(index).unlock();
        }
    }
}
