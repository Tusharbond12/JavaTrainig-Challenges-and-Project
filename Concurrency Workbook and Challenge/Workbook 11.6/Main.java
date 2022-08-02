import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import java.util.concurrent.locks.ReentrantLock;

public class Main {
 
    static String[] files = new String[] { "data/sales1.csv", "data/sales2.csv", "data/sales3.csv"};
   
    static int sampleSize = 0;
    static int quantitySold = 0;
    


    public static void main(String[] args) throws Exception {
     
            // execute tasks here
            
            Scanner scan = new Scanner(System.in);
            System.out.print("Please enter your name to access the Global Superstore data: ");
            String name = scan.nextLine();
            System.out.println("\nThank you " + name + ".\n");
            scan.close();
            ReentrantLock lock=new ReentrantLock();
            CountDownLatch latch=new CountDownLatch(3);
            ExecutorService executor=Executors.newFixedThreadPool(3);
            
            Future<Double> future1=executor.submit(()->increment(files[0], lock,latch));
            Future<Double> future2=executor.submit(()->increment(files[1], lock,latch));
            Future<Double> future3=executor.submit(()->increment(files[2], lock,latch));
            latch.await();
            executor.shutdown();
        
            // Thread thread1=new Thread(()->increment(files[0],lock));
            // Thread thread2=new Thread(()->increment(files[1],lock));
            // Thread thread3=new Thread(()->increment(files[2],lock));
            // thread1.start();
            // thread2.start();
            // thread3.start();
            // thread1.join();
            // thread2.join();
            // thread3.join();
            System.out.println("Quantity "+quantitySold);
            System.out.println("sampleSize "+sampleSize);
            
     
    }
   public static double increment(String file,ReentrantLock lock ,CountDownLatch latch)
   { 
    
   
    try{
     Path path = Paths.get(Thread.currentThread().getContextClassLoader().getResource(file).toURI());
     Files.lines(path)
     .skip(1)
     .map((line)->line.split(","))
     .mapToInt((value)->Integer.parseInt(value[2]))
     .forEach((quantity)->{
           lock.lock();
           sampleSize++;
           quantitySold+=quantity; 
           lock.unlock();      
     })
     ;
    }
    catch(Exception e)
    {
        System.out.println(e.getMessage());
    }
    latch.countDown();
    return 0;
   }
}
