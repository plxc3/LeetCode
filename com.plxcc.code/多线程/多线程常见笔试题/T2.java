package 多线程.多线程常见笔试题;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class T2 {
    public static void main(String[] args) {
        MyData myData = new MyData();
        ExecutorService executorService = new ThreadPoolExecutor(
                3,
                Runtime.getRuntime().availableProcessors(),
                3,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(90),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );
        for (int i = 0; i < 30; i++) {
            executorService.execute(()->myData.write());
            executorService.execute(()->myData.read());
        }
        executorService.shutdown();
    }
}

class MyData {
    private  int data = 0;
    private  Format format = new SimpleDateFormat("yyyy-DD-mm");

    private ReadWriteLock lock =  new ReentrantReadWriteLock();

    public void read(){
        lock.readLock().lock();
        try{
            System.out.println(Thread.currentThread().getName()+format.format(new Date())+"读取data值为："+data);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.readLock().unlock();
        }
    }

    public void write(){
        lock.writeLock().lock();
        try{
            data++;
            System.out.println(Thread.currentThread().getName()+format.format(new Date())+"修改data,现data值为:"+data);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.writeLock().unlock();
        }
    }

}
