package il.ac.hit.pooly;

public class Main {
    public static void main(String[] args) {
        ThreadsPool pool = new ThreadsPool(10);

        for (int i = 0; i < 100; i++) {
            Task task = new Task() {
                private int myPriority;

                @Override
                public void perform() throws InterruptedException {
                    System.out.println("Performing task with priority " + myPriority);
                    Thread.sleep(100);
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
