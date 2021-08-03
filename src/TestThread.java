import java.util.concurrent.*;

public class TestThread {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

      /*int number = 5;
      //  final long startTime = System.nanoTime();
        Thread newThread = new Thread(() -> {
            System.out.println("Factorial of " + number + " is: " + factorial(number));
        });
        newThread.start();
     //   final long time = System.nanoTime() - startTime;
    //    System.out.println("time to execute whole code: " + time);
    } */
      int number = 5;
       ExecutorService threadpool = Executors.newCachedThreadPool();
     //   ExecutorService threadpool = Executors.newFixedThreadPool(10);
        Future<Integer> futureTask = threadpool.submit(() -> factorial(number));
        final long startTime = System.nanoTime();
        while (!futureTask.isDone()) {
            System.out.println("FutureTask is not finished yet...");
        }
        int result = futureTask.get();
        final long time = System.nanoTime() - startTime;
        System.out.println("time to execute whole code: " + time);
        System.out.println("Task Complete" + result);
        threadpool.shutdown();
    }
    /*
        int number = 5;
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> factorial(number));
        while (!completableFuture.isDone()) {
            System.out.println("CompletableFuture is not finished yet...");
        }
        int result = completableFuture.get();
        System.out.println("Task Complete" + result);
    } */
    private static Integer factorial(int number) {
        int fact = 1;
        // ...
        for(int count = number; count > 1; count--) {
            fact = fact * count;
        }

        return fact;
    }

}

// Create Async progr - Threads- runnable, callable, future Interface , Executor Service, CompletableFuture // Promises
