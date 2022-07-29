import java.util.Scanner;

import javax.print.DocFlavor.STRING;

public class Quiz {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int score = 0;

        System.out.println("1. Which country held the 2016 Summer Olympics?");
        System.out.println("\ta) China\n\tb) Ireland\n\tc) Brazil\n\td) Italy\n");
        String a=scan.nextLine();
        if(a.equals("c"))
        {
            score+=5;
        }


        //store answer 1

        System.out.println("\n2. Which planet is the hottest?");
        System.out.println("\ta) Venus\n\tb) Saturn\n\tc) Mercury\n\td) Mars\n");
        String b=scan.nextLine();
        if(b.equals("a")){
            score+=5;
        }

        //store answer 2

        System.out.println("\n3. What is the rarest blood type?");
        System.out.println("\ta) O\n\tb) A\n\tc) B\n\td) AB-Negative\n");
        String c=scan.nextLine();
        if(c.equals("d")){
            score+=5;
        }

        //store answer 3

        System.out.println("\n4. Which one of these characters is friends with Harry Potter?");
        System.out.println("\ta) Ron Weasley\n\tb) Hermione Granger\n\tc) Draco Malfoy\n");
        String d=scan.nextLine();
        if(d.equals("a") || d.equals("b")){
            score+=5;
        }
        //store answer 4

        


        //Task 2: Check each answer - For each correct answer, add 5 points to the score. 
        
        System.out.println("\nYour final score is: " + score + "/20");
        if(score>=15)
        {
            System.out.println("Wow you know your stuff");
        }
        else if (score>=5 && score <15)
        {
            System.out.println("Not bad");
        }
        else{
            System.out.println("Better Luck Next Time");
        }
 

        //Task 3: print a message depending on the score

        // if the score is 15 or higher, print: "Wow, you know your stuff!";
        // if the score is between 5 and 15, print "Not bad!";
        // else, better luck next time. 


        scan.close();

    }
}