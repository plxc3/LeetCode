package 多线程;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ABC2 {
    public static void main(String[] args) {
        MySource source = new MySource();
        new Thread(()->{for(int i = 0;i<10;i++)source.printA();},"A").start();
        new Thread(()->{for(int i = 0;i<10;i++)source.printB();},"B").start();
        new Thread(()->{for(int i = 0;i<10;i++)source.printC();},"C").start();
    }
}

class MySource{
    private int state = 1;
    private  Lock lock  = new ReentrantLock();
    private  Condition condition1 = lock.newCondition();
    private  Condition condition2 = lock.newCondition();
    private  Condition condition3 = lock.newCondition();

    public void printA(){
        lock.lock();
        try {
            while(state!=1){
                condition1.await();  // except (the current thread is not the owner of the object's monitor.)
                condition1.wait();
            }
            state = 2;
            System.out.print("A");
            condition2.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void printB()  {
        lock.lock();
        try {
           while (state!=2){
               condition2.await();
           }
           System.out.print("B");
           state = 3;
           condition3.signal();
       }catch (Exception e){
           e.printStackTrace();
       }finally {
           lock.unlock();
       }
    }

    public void printC()  {
        lock.lock();
        try {
            while (state!=3){
                condition3.await();
            }
            System.out.println("C");
            state = 1;
            condition1.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }



}
