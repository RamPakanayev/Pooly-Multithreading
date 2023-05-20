package il.ac.hit.pooly;

/**
 * The Main class for running the application.
 */
public class Main {
    /**
     * The main method for running the application.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ThreadsPool pool = new ThreadsPool(10);

        for (int i = 0; i < 100; i++) {
            Task task = new Task() {
                private int myPriority;

                @Override
                public void perform() {
                    try {
                        System.out.println("Performing task with priority " + myPriority);
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
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
            task.setPriority(i);
            pool.submit(task);
        }

        pool.shutdown();
    }
}