package 多线程;

/**
 * 测试线程礼让，礼让不一定成功
 */
public class TestYield {
    static class MyYield implements Runnable{
        @Override
        public void run(){
            System.out.println(Thread.currentThread().getName()+"start");
//            Thread.yield();
            System.out.println(Thread.currentThread().getName()+"end");
        }
    }

    public static void main(String[] args) {
        MyYield myYield1 = new MyYield();
        MyYield myYield2 = new MyYield();
        new Thread(myYield1,"A").start();
        new Thread(myYield2,"B").start();
    }
}
