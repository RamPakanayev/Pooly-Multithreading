package il.ac.hit.pooly;

public class Main {
    public static void main(String[] args) {
        // Create a new thread pool with 2 threads
        ThreadsPool pool = new ThreadsPool(2);

        // Create a few tasks
        Task task1 = new Task() {
            private int myPriority = 1;

            @Override
            public void perform() throws Exception {
                System.out.println("Performing task 1 with priority " + myPriority);
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
            public void perform() throws Exception {
                System.out.println("Performing task 2 with priority " + myPriority);
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

        // Submit the tasks to the thread pool
        pool.submit(task1);
        pool.submit(task2);

        // Wait for a bit to allow the tasks to be executed
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Shut down the thread pool
        pool.shutdown();
    }
}
