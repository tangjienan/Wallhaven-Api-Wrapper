package api;

import java.util.concurrent.*;

/**
 * Created by donezio on 2/8/19.
 */
public class Downloader {

    static int MAX_THREAD_SIZE = 24;
    static int MAX_QUEUE_SIZE = 24;


    static ExecutorService downloader() {
        BlockingQueue<Runnable> workingQueue = new ArrayBlockingQueue<Runnable>(MAX_QUEUE_SIZE);
        RejectedExecutionHandler rejectedExecutionHandler =
                new ThreadPoolExecutor.CallerRunsPolicy();
        ExecutorService threadPool = new ThreadPoolExecutor(MAX_THREAD_SIZE, MAX_QUEUE_SIZE, 0L, TimeUnit.MILLISECONDS,
                workingQueue, rejectedExecutionHandler);



        return threadPool;
    }
}
