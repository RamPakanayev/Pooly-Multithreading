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

    @Test
    public void testSubmit() throws InterruptedException {
        Task task = new Task() {
            private int myPriority;

            @Override
            public void perform() {
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

    @Test
    public void testShutdown() throws InterruptedException {
        Task task = new Task() {
            private int myPriority;

            @Override
            public void perform() {
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
}
