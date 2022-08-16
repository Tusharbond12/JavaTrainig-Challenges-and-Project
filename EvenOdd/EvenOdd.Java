

public class EvenOdd{

    public static void main(String[] args)
    throws InterruptedException
{
    Generate no = new Generate();


    Thread t1 = new Thread(new Runnable() {
        @Override
        public void run()
        {
            try {
                no.generateOdd();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    });


    Thread t2 = new Thread(new Runnable() {
        @Override
        public void run()
        {
            try {
                no.generateEven();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    });

  
    t1.start();
    t2.start();

    
    
}}