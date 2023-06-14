two test files: TaskTest.java and ThreadsPoolTest.java.

TaskTest.java is designed to test the Task interface and its implementations. The specific tests in this file are:

testSetAndGetPriority(): This test checks whether the setPriority() and getPriority() methods of a Task work correctly. It sets a priority for a task and then gets the priority to check if it matches the set value.
testCompareTo(): This test checks the compareTo() method of a Task. It creates two tasks with different priorities and checks if the compareTo() method correctly determines which task has a higher priority.
ThreadsPoolTest.java is designed to test the ThreadsPool class. The specific tests in this file are:

testSubmit(): This test checks the submit() method of a ThreadsPool. It submits a task to the pool and then checks if the task has been executed.
testShutdown(): This test checks the shutdown() method of a ThreadsPool. It submits a task, waits for it to be executed, shuts down the pool, and then checks if the pool is shut down.
These tests ensure that the main functionalities of your Task and ThreadsPool classes work as expected.
