package Java8;

import java.util.concurrent.*;
import java.util.stream.IntStream;

public class Run {
    public static void main(String[] args) {
        Thread thread=new Thread(new RunnableTask());
        thread.start();
        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("running inner class");
            }
        });
        thread1.start();
        Thread thread2=new Thread(()->{
            System.out.println("running from lambda");
        });
        thread2.start();
        ExecutorService executor= Executors.newSingleThreadExecutor();
        Runnable r=()->{
            IntStream.rangeClosed(1,4).forEach(System.out::println);

        };
        System.out.println("Before Executing");
        executor.execute(r);
        System.out.println("After executing");
        executor.shutdown();
        ExecutorService executor1=Executors.newSingleThreadExecutor();
        Runnable r1=()->{
            try{
                Thread.sleep(5000);
            }catch (InterruptedException e){
                System.out.println("Interrupted");
            }
        };
        executor1.execute(r1);
        executor1.shutdown();
        executor1.shutdownNow();

        ExecutorService executor2 = Executors.newSingleThreadExecutor();
        Runnable r2 = () -> {
            IntStream.range(1, 1_000_000).forEach(System.out::println);
        };
        Future<?> future = executor2.submit(r2);
        try {
            future.get(); // Blocks until the Runnable has finished
        } catch (InterruptedException | ExecutionException e) { /** ... */ }


    }
}
