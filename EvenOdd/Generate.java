
public  class Generate {
 
    
        int even=-2;
        int odd=-1;
        int value = 0;

    public void generateEven() throws InterruptedException
    {   
        while (true) {
            synchronized (this)
            {
                
                if(value%2==0)
                wait();
                even+=2;
                value=even+2;
                System.out.println("No Genrated is Even  "
                                   + value);

                
                notify();
                Thread.sleep(1000);
            }
        }
    }

    public void generateOdd() throws InterruptedException
    {
        while (true) {
            synchronized (this)
            {
                
                if(value%2!=0)
                    wait();

               odd+=2;
               value=odd;
                System.out.println("No Genrated is odd "
                                   + value);
                notify();
                Thread.sleep(1000);
            }
        }
    }
}
