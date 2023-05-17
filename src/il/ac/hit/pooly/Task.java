package il.ac.hit.pooly;

public interface Task extends Runnable, Comparable<Task> {
    void perform();
    void setPriority(int level);
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
        return Integer.compare(other.getPriority(), this.getPriority());
    }
}
