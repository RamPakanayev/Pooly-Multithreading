package il.ac.hit.pooly;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TaskTest {
    private Task task;

    @Before
    public void setUp() {
        task = new Task() {
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
    }

    // Test to check if the setPriority and getPriority methods are working correctly
    @Test
    public void testSetAndGetPriority() {
        int priority = 5;
        task.setPriority(priority);
        assertEquals(priority, task.getPriority());
    }

    // Test to check if the compareTo method is working correctly
    @Test
    public void testCompareTo() {
        Task otherTask = new Task() {
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

        otherTask.setPriority(3);
        task.setPriority(5);
        assertTrue(task.compareTo(otherTask) < 0);

        otherTask.setPriority(5);
        task.setPriority(5);
        assertEquals(0, task.compareTo(otherTask));

        otherTask.setPriority(7);
        task.setPriority(5);
        assertTrue(task.compareTo(otherTask) > 0);
    }
}
