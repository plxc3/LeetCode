package 多线程.vol;

import java.util.concurrent.TimeUnit;

/**
 * @PackgeName: 多线程.vol
 * @ClassName: VolatileDemo
 * @Author: plxc
 * Date: 2021/5/6 15:51
 * project name: LeetCode
 * @Version:
 * @Description:
 */
public class VolatileDemo {

    private static volatile boolean flag = true;

    public static void main(String[] args) {
        new Thread(()->{
            while (flag){

            };
            System.out.println("Thread is End");
        }).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("turn flag off");
        flag = false;
    }
}
