package il.ac.hit.pooly;

import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class ThreadsPoolTest {
    private ThreadsPool pool;

    @Before
    public void setUp() {
        pool = new ThreadsPool(2);
    }

    // Test to check if the submit method is working correctly
    @Test
    public void testSubmit() throws InterruptedException {
        Task task = new Task() {
            private int myPriority;

            @Override
            public void perform() throws Exception {
                System.out.println("Performing task with priority " + myPriority);
            }

            @Override
            public void setPriority(int level) {
                myPriority = level;
            }

            @Override
            public int getPriority() {
                return myPriority;
            }
        };

        task.setPriority(5);
        pool.submit(task);

        // Allow time for the task to be executed
        TimeUnit.SECONDS.sleep(1);

        // The pool should have executed the task
        assertTrue(pool.getCompletedTaskCount() > 0);
    }

    // Test to check if the shutdown method is working correctly
    @Test
    public void testShutdown() throws InterruptedException {
        Task task = new Task() {
            private int myPriority;

            @Override
            public void perform() throws Exception {
                System.out.println("Performing task with priority " + myPriority);
            }

            @Override
            public void setPriority(int level) {
                myPriority = level;
            }

            @Override
            public int getPriority() {
                return myPriority;
            }
        };

        task.setPriority(5);
        pool.submit(task);

        // Allow time for the task to be executed
        TimeUnit.SECONDS.sleep(1);

        pool.shutdown();

        // The pool should be shut down
        assertTrue(pool.isShutdown());
    }

    // Test to check if the ThreadsPool constructor throws an exception when the number of threads is 0
    @Test(expected = IllegalArgumentException.class)
    public void testCreatePoolWithZeroThreads() {
        new ThreadsPool(0);
    }

    // Test to check if the ThreadsPool constructor throws an exception when the number of threads is negative
    @Test(expected = IllegalArgumentException.class)
    public void testCreatePoolWithNegativeThreads() {
        new ThreadsPool(-1);
    }

    // Test to check if the submit method throws an exception when the task is null
    @Test(expected = IllegalArgumentException.class)
    public void testSubmitNullTask() {
        pool.submit(null);
    }

    // Test to check if the submit method throws an exception after the pool is shut down
    @Test(expected = IllegalStateException.class)
    public void testSubmitTaskAfterShutdown() throws InterruptedException {
        Task task = new Task() {
            private int myPriority;

            @Override
            public void perform() throws Exception {
                System.out.println("Performing task with priority " + myPriority);
            }

            @Override
            public void setPriority(int level) {
                myPriority = level;
            }

            @Override
            public int getPriority() {
                return myPriority;
            }
        };

        task.setPriority(5);
        pool.shutdown();
        pool.submit(task);  // This should throw an exception
    }
}
