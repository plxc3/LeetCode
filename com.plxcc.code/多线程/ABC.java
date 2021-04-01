package 多线程;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
class MyThread extends Thread{
    private static int  state = 1;
    private static Lock lock = new ReentrantLock();
    @Override
    public synchronized void run(){
        try {
            lock.lock();
            for (int i = 0; i < 10;) {
                if(state%3 == 1){
                    System.out.print("A");
                    state++;
                    i++;
                }else if(state%3 == 2){
                    System.out.print("B");
                    state++;
                    i++;
                }else {
                    System.out.println("C");
                    state++;
                    i++;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }

    }
}

public class ABC{
    public static void main(String[] args) {
        new MyThread().start();
        new MyThread().start();
        new MyThread().start();
    }
}