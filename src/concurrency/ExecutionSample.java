package concurrency;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @see https://www.baeldung.com/java-util-concurrent
 */
public class ExecutionSample {

    public static void main(String[] args)
    {
        // Direct task execution
        execute();
        // Better
        execute1();

    }


    public static void execute() {
        Executor executor = new Invoker();
        executor.execute( () -> {
            System.out.println("Hello");
        });
    }

    static void execute1() {
        // Service pooling
        ExecutorService executor = Executors.newFixedThreadPool(10);
        executor.submit(new Task());
    }
}

class Invoker implements Executor {
    @Override
    public void execute(Runnable r) {
        r.run();
    }
}

class Task implements Runnable {
    @Override
    public void run() {
        // task details
        System.out.println("Here we are...");
    }
}