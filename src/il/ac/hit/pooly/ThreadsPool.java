package il.ac.hit.pooly;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * The ThreadsPool class for managing a pool of threads.
 */
public class ThreadsPool {
    private final ThreadPoolExecutor executor;

    /**
     * Create a new ThreadsPool.
     * @param numberOfThreads the number of threads in the pool
     */
    public ThreadsPool(int numberOfThreads) {
        if (numberOfThreads <= 0) {
            throw new IllegalArgumentException("Number of threads must be greater than 0");
        }
        executor = new ThreadPoolExecutor(numberOfThreads, numberOfThreads, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue<>());
    }

    /**
     * Submit a task to be executed by the thread pool.
     * @param task the task to execute
     */
    public void submit(Task task) {
        if (executor.isShutdown()) {
            throw new IllegalStateException("Cannot submit task after shutdown");
        }
        if (task == null) {
            throw new IllegalArgumentException("Task cannot be null");
        }
        executor.execute(task);
    }

    /**
     * Shutdown the thread pool.
     */
    public void shutdown() {
        executor.shutdown();
    }

    /**
     * Get the number of completed tasks.
     * @return the number of completed tasks
     */
    public long getCompletedTaskCount() {
        return executor.getCompletedTaskCount();
    }

    /**
     * Check if the thread pool is shut down.
     * @return true if the thread pool is shut down, false otherwise
     */
    public boolean isShutdown() {
        return executor.isShutdown();
    }
}
