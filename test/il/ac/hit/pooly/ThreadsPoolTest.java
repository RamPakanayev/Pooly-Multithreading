package il.ac.hit.pooly;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ThreadsPoolTest {
    @Test
    void submit() {
        ThreadsPool pool = new ThreadsPool(2);
        Task task = new Task() {
            @Override
            public void perform() {
                System.out.println("Task performed");
            }

            @Override
            public void setPriority(int level) {}

            @Override
            public int getPriority() {
                return 0;
            }
        };
        pool.submit(task);
        pool.shutdown();
    }
}
