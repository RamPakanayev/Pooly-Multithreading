
package il.ac.hit.pooly;

/**
 * The Task interface for tasks that can be run in a thread pool.
 */
public interface Task extends Runnable, Comparable<Task> {
    /**
     * Perform the task.
     */
    void perform();

    /**
     * Set the priority of the task.
     * @param level the priority level
     */
    void setPriority(int level);

    /**
     * Get the priority of the task.
     * @return the priority level
     */
    int getPriority();

    @Override
    default void run() {
        perform();
    }

    @Override
    default int compareTo(Task other) {
        return Integer.compare(other.getPriority(), this.getPriority());
    }
}