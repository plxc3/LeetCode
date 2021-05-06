package 多线程;

import java.util.concurrent.*;

public class ThreadPoolTest {
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
        ExecutorService threadPool = new ThreadPoolExecutor(
                2,
                Runtime.getRuntime().availableProcessors(),
                3,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(30),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );
        for (int i = 0; i < 8; i++) {
            threadPool.execute(()-> System.out.println(Thread.currentThread().getName()));
        }
        threadPool.shutdown();
    }
}
