package 多线程.多线程常见笔试题;


import java.util.concurrent.TimeUnit;

public class T1 {
    public static void main(String[] args) throws InterruptedException {
        Thread a = new Thread(new MyThread(), "A");
        Thread b = new Thread(new MyThread(), "B");
        Thread c = new Thread(new MyThread(), "C");
        a.start();
        a.join();
        b.start();
        b.join();
        c.start();
        c.join();
    }
}

class MyThread implements Runnable{
    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName()+"开始执行");
        try {
            TimeUnit.SECONDS.sleep(1L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"执行完毕");
    }
}
