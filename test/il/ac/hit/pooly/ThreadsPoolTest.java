package il.ac.hit.pooly;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ThreadsPoolTest {
    @Test
    void submit() {
        ThreadsPool pool = new ThreadsPool(2);
        Task task1 = new Task() {
            private int myPriority = 1;

            @Override
            public void perform() {
                System.out.println("Task 1 performed");
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
        Task task2 = new Task() {
            private int myPriority = 2;

            @Override
            public void perform() {
                System.out.println("Task 2 performed");
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
        pool.submit(task1);
        pool.submit(task2);
        // AddApologies for the abrupt cut-off in the previous message. Here's the continuation of the unit test:

```java
        // Add a delay to allow tasks to finish
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        pool.shutdown();
    }
}
