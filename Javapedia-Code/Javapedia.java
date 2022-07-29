import java.util.Scanner;

public class Javapedia {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("\n**********Javapedia**********");
        System.out.println("How many historical figures will you register?");
        int noOfFigure=scan.nextInt();
        String[][] database=new String[noOfFigure][3];
        scan.nextLine();

        for(int i=0;i<noOfFigure;i++)
        {   System.out.println("\n\tFigure " + (i+1)); 
            for(int j=0;j<=2;j++)
            {
            if(j==0){
                System.out.print("\t - Name: ");
                
            }
            else if(j==1)
            {
                System.out.print("\t - Date of birth: ");   
            }
            else
            {
                System.out.print("\t - Occupation: ");
            }
            database[i][j]=scan.nextLine();

            }
            System.out.print("\n");
        }
        

        //Task 1 – Ask the user: how many historical figures will you register?
        //       – Store the value.
        
        //Task 2 – Create a 2D array with a variable number of rows, and 3 values per row.         
         
        //Watch out for the nextLine() pitfall. 
        /* Task 3 
        for (____) {

            System.out.println("\n\tFigure " + (i+1)); 

            System.out.print("\t - Name: ");
            pick up and store figure's name.   

            System.out.print("\t - Date of birth: ");
            pick up and store figure's birthday.

            System.out.print("\t - Occupation: ");
            pick up and store figure's occupation. 

            System.out.print("\n");

        }
        
        */
        System.out.println("These are the values you stored:\n"); 
        //Task 4: call print2DArray. 
        print2DArray(database);

        System.out.print("\nWho do you want information on? ");  
        String poi=scan.nextLine();
        find(poi,database);
        /*Task 5: Let the user search the database by name. 
            If there's a match:
              print(    tab of space    Name: <name>)
              print(    tab of space    Date of birth: <date of birth>)
              print(    tab of space    Occupation: <occupation>)

        */        

        scan.close();
    }

    /**
     * Function name: print2DArray
     * @param array (String[][])
     * 
     * Inside the function
     *  1. print the database
     *     • a tab of space precedes each row.
     *     • each value in database has one space from the other value. 
     *     • print a new line.
     */
    public static void print2DArray(String [][] database )
    {
        for(int i=0;i<database.length;i++)
        {   System.out.print("\t");
            for(int j=0;j<3;j++)
            {

                System.out.print(database[i][j]+" ");
            }
            System.out.print("\n");
        }
    }
    public static void find(String poi, String [][] data)
    {
        for(int i=0;i<data.length;i++)
        {
            if(data[i][0].equals(poi))
            {
                System.out.print("\tname: "+data[i][0]+"\n\tDate of Birth: "+data[i][1]+"\n\tOccupation: "+ data[i][2]);
                System.exit(0);
            }
        }
        System.out.println("Not available in the database ");
    }



}
