import java.util.Scanner;

public class TicTacToe {

    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        
            System.out.println("\nLet's play tic tac toe\n");
            String[][] ttt={{"_","_","_"} , {"_","_","_"},{"_","_","_"}};
            print(ttt);
            playGame(ttt);
            scan.close();
        }
     public static void print(String[][] table)
     {
      for(int i =0;i<3;i++)
      { System.out.print("\t");
        for(int j=0;j<3;j++)
        {
          System.out.print(table[i][j]+" ");

        }
        System.out.print("\n");

      }
      System.out.print("\n");
     }
     public static boolean check(String[][] table,int i, int j,String value)
     {
      boolean result=false;
      if(i==1 && j==1 )
      {
        if((table[i-1][j].equals(value) && table[i+1][j].equals(value)) || ((table[i][j-1].equals(value) && table[i][j+1].equals(value))) || (table[i-1][j-1].equals(value) && table[i+1][j+1].equals(value))||((table[i-1][j+1].equals(value) && table[i+1][j-1].equals(value))))
        {
result = true;
        }}
        else if(i==0 && j==0)
        {
          if((table[i+1][j].equals(value) && table[i+2][j].equals(value)) || (table[i][j+1].equals(value) && table[i][j+1].equals(value) ) || (table[i+1][j+1].equals(value) && table[i+2][+2].equals(value)))
          {
            result=true;
          }
        }
        else if(i==2&& j==0)
        {if((table[i-1][j].equals(value) && table[i-2][j].equals(value))|| (table[i][j+1].equals(value) && table[i][j+2].equals(value)) || (table[i-1][j+1].equals(value) && table[i-2][j+2].equals(value)))
        {
          result=true;
        }}
        else if(i==2 && j==2)
        {if((table[i][j-1].equals(value) && table[i][j-2].equals(value))|| (table[i-1][j].equals(value) && table[i-2][j].equals(value))|| (table[i-1][j-1].equals(value) && table[i-2][j-2].equals(value))){
          result=true;
        }}
        else if(i==0 && j==2)
        {if((table[i][j-1].equals(value) && table[i][j-2].equals(value))|| (table[i+1][j].equals(value) && table[i+2][j].equals(value))|| (table[i+1][j-1].equals(value) && table[i+2][j-2].equals(value))){
          result=true;
        }}
        else if(i==0 && j==1)
        {if((table[i][j-1].equals(value) && table[i][j+1].equals(value))|| (table[i+1][j].equals(value) && table[i+2][j].equals(value))){
          result=true;
        }}
        else if(i==1&& j==0)
        {if((table[i][j+1].equals(value) && table[i][j+2].equals(value))|| (table[i-1][j].equals(value) && table[i+1][j].equals(value))){
          result=true;
        }}
        else if(i==2 && j==1)
        {if((table[i][j-1].equals(value) && table[i][j+1].equals(value))|| (table[i-1][j].equals(value) && table[i-2][j].equals(value))){
          result=true;
        }}
        else if(i==0 && j==2)
        {if((table[i-1][j].equals(value) && table[i+1][j].equals(value))|| (table[i][j-1].equals(value) && table[i][j-2].equals(value))){
          result=true;
        }}
        else{
          System.out.println("You Have Entered Wrong index , Closing the game .... ");
          System.exit(0);
        }
        
      
      return result;
     }
     public static void playGame(String[][] table)
     { int input1=-1;
       int input2=-1;
      for(int i=0;i<9;i++)
      {  String value="O";
        if(i%2==0)
        {
         value="X";
        }
        System.out.println("Turn: "+value);
        System.out.print(" .pick a row and column number: ");
        input1=scan.nextInt();
        input2=scan.nextInt();
        table[input1][input2]=value;

        System.out.print("\n");
        print(table);
        Boolean result=check(table,input1,input2,value);
        if(result)
        {
          System.out.println(value + " wins congratulations ");
          System.exit(0);
        }

      
      }
     }

    /** Task 2 - Write a function that prints the board.
     * Function name - printBoard()
     * @param board (char[][])
     * 
     * Inside the function:
     *   1. print a new line.
     *   2. print the board.
     *      • separate each row by two lines. 
     *      • each row precedes a tab of space
     *      • each character in the grid has one space from the other character
     */        

   /** Task 4 - Write a function that lets the user choose a spot
     * Function name – askUser
     * @param board (char[][] board)
     * @return spot (int[])
     * 
     * Inside the function
     *   1. Asks the user: - pick a row and column number: 
     *   2. Check if the spot is taken. If so, let the user choose again.
     *   3. Return the row and column in an int[] array.
     * 
     */

    /** Task 6 - Write a function that determines the winner
     * Function name - checkWin 
     * @param board (char[][])
     * @return count (int)
     * 
     * Inside the function:
     *   1. Make a count variable that starts at 0.
     *   2. Check every row for a straight X or straight O (Task 7).
     *   3. Check every column for a straight X or straight O (Task 8).
     *   4. Check the left diagonal for a straight X or straight O (Task 9).
     *   5. Check the right diagonal for a straight X or straight O (Task 10).
     */


}
