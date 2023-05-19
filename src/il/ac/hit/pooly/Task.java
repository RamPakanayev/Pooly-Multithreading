package il.ac.hit.pooly;

/**
 * The Task interface for tasks that can be run in a thread pool.
 */
public interface Task extends Runnable, Comparable<Task> {
    /**
     * Perform the task.
     * @throws Exception if an error occurs while performing the task
     */
    void perform() throws Exception;

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
        try {
            perform();
        } catch (Exception e) {
            // Handle exception or rethrow as appropriate
            e.printStackTrace();
        }
    }

    @Override
    default int compareTo(Task other) {
        if(other == null) {
            throw new IllegalArgumentException("Other task cannot be null");
        }
        return Integer.compare(other.getPriority(), this.getPriority());
    }
}
