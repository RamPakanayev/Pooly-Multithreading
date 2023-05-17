package il.ac.hit.pooly;

public class Main {
    public static void main(String[] args) {
        ThreadsPool pool = new ThreadsPool(2);

        Task task1 = new Task() {
            @Override
            public void perform() {
                System.out.println("Task 1 performed");
            }

            @Override
            public void setPriority(int level) {}

            @Override
            public int getPriority() {
                return 1;
            }
        };

        Task task2 = new Task() {
            @Override
            public void perform() {
                System.out.println("Task 2 performed");
            }

            @Override
            public void setPriority(int level) {}

            @Override
            public int getPriority() {
                return 2;
            }
        };

        pool.submit(task1);
        pool.submit(task2);

        pool.shutdown();
    }
}
