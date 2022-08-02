import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;


public class Main {

    static final String SALES = "data/sales.csv"; //Use backslash Windows users
    static double furniture;
    static double officeSupplies;
    static double technology;
    static double totalAverage;
    public static void main(String[] args) {
        
        try {
            Path path = Paths.get(Thread.currentThread().getContextClassLoader().getResource(SALES).toURI());
            ExecutorService executor=Executors.newFixedThreadPool(1);
            Future<Double> future1=executor.submit(()->average(path, "Furniture"));
            Future<Double> future2=executor.submit(()->average(path, "Technology"));
            Future<Double> future3=executor.submit(()->average(path, "Office Supplies"));
            Future<Double> future4=executor.submit(()->totalAverage(path));
             
            // Callable<Double> callable1=()->average(path, "Furniture");
            // FutureTask<Double> future1=new FutureTask<>(callable1);
            // Callable<Double> callable2=()->average(path, "Technology");
            // FutureTask<Double> future2=new FutureTask<>(callable2);
            // Callable<Double> callable3=()->average(path, "Office Supplies");
            // FutureTask<Double> future3=new FutureTask<>(callable3);
            // Callable<Double> callable4=()->totalAverage(path);
            // FutureTask<Double> future4=new FutureTask<>(callable4);
            // Thread thread1=new Thread(future1);
            // Thread thread2=new Thread(future2);
            // Thread thread3=new Thread(future3);
            // Thread thread4=new Thread(future4);
            // thread1.start();
            // thread2.start();
            // thread3.start();
            // thread4.start();
            
            Scanner scan=new Scanner(System.in);
            System.out.print("Enter your name please : ");
            String name=scan.nextLine();
            System.out.println("\nThank you " +name+ ". The average sales for Global Superstore are:\n");
            furniture=future1.get();
            technology=future2.get();
            officeSupplies=future3.get();
            totalAverage=future4.get();
            executor.shutdown();
            
            
    System.out.println("Average Furniture Sales: " + furniture);
    System.out.println("Average Technology Sales: " + technology);
    System.out.println("Average Office Supplies Sales: " + officeSupplies);
    System.out.println("Total Average: " + totalAverage);
    System.out.println(Runtime.getRuntime().availableProcessors());
           
            // thread1.interrupt();
            // Thread.sleep(10);
            // System.out.println(thread1.getState());
            // thread1.interrupt();
            // System.out.println("Hello User !!! welcome to multiverse of madness ");
            

            //calculate average sales of "Furniture" here
            //calculate average sales of "Technology" here
            //calculate average sales of "Office Supplies" here
            //calculate total average of sales here


        } catch (URISyntaxException e) {
            System.out.println(e.getMessage());
        }
        catch(InterruptedException e)
        {
            System.out.println(e.getMessage());
        }
        catch(ExecutionException e)
        {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Function name: average
     * @param path (Path)
     * @param category (String)
     * @return Double
     * 
     * Inside the function:
     *   1. Runs through every line from the CSV file as a stream.
     *   2. Maps every element in the stream to an array of three String values.
     *   3. Filters every value by the @param category
     *   4. Map every element in the stream to a double (price * quantity).
     *   5. Applies the terminal operation average.
     *   6. Returns the average as double.
     * 
     */
    public static double average(Path path , String category)
    {   
        if(Thread.currentThread().isInterrupted())
         {
             return 0.;
        }
        try{
           return Files.lines(path).skip(1)
           .map((line)->line.split(","))
           .filter((values)->values[0].equals(category))
           .mapToDouble((values)-> Double.parseDouble(values[1])*Double.parseDouble(values[2]))
            .average().getAsDouble();

        }
        catch(IOException e)
        {
           System.out.println(e.getMessage());
           return 0;
        }
    }


    /**
     * Function name: totalAverage
     * @param path (Path)
     * @return Double
     * 
     * Inside the function:
     *   1. Runs through every line from the CSV file as a stream.
     *   2. Maps every element in the stream to an array of three values.
     *   3. Maps every element in the stream to a double: (price * quantity).
     *   4. Applies the terminal operation average.
     *   5. Returns the average as double.
     */
    public static double totalAverage(Path path)
    {
      try{
        return Files.lines(path)
        .skip(1)
        .map((lines)->lines.split(","))
        .mapToDouble((values)->Double.parseDouble(values[1])*Double.parseDouble(values[2]))
        .average()
        .getAsDouble();
      }
      catch(IOException e)
      {
        System.out.println(e.getMessage());
        return 0;
      }
    }

}
