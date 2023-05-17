package il.ac.hit.pooly;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadsPool {
    private final ThreadPoolExecutor executor;

    public ThreadsPool(int numberOfThreads) {
        executor = new ThreadPoolExecutor(numberOfThreads, numberOfThreads, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue<>());
    }

    public void submit(Task task) {
        executor.execute(task);
    }

    // Add shutdown method to properly close the executor
    public void shutdown() {
        executor.shutdown();
    }
}
