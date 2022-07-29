import java.util.Scanner;



public class Hangman {

    public static String[] words = {"ant", "baboon", "badger", "bat", "bear", "beaver", "camel",
    "cat", "clam", "cobra", "cougar", "coyote", "crow", "deer",
    "dog", "donkey", "duck", "eagle", "ferret", "fox", "frog", "goat",
    "goose", "hawk", "lion", "lizard", "llama", "mole", "monkey", "moose",
    "mouse", "mule", "newt", "otter", "owl", "panda", "parrot", "pigeon", 
    "python", "rabbit", "ram", "rat", "raven","rhino", "salmon", "seal",
    "shark", "sheep", "skunk", "sloth", "snake", "spider", "stork", "swan",
    "tiger", "toad", "trout", "turkey", "turtle", "weasel", "whale", "wolf",
    "wombat", "zebra"};

    public static String[] gallows = {"+---+\n" +
    "|   |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    "+---+\n" +
    "|   |\n" +
    "O   |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    "+---+\n" +
    "|   |\n" +
    "O   |\n" +
    "|   |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|   |\n" +
    "     |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" + //if you were wondering, the only way to print '\' is with a trailing escape character, which also happens to be '\'
    "     |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" +
    "/    |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" + 
    "/ \\  |\n" +
    "     |\n" +
    " =========\n"};

    public static void main(String[] args) {
    
Scanner scan=new Scanner(System.in);
System.out.println("Welcome to Hangman! , Computer is selecting random word for you\n");
String word=selectRandomword();
playGame(word);
scan.close();


 }
 public static void playGame(String word)
 {  Scanner scan=new Scanner(System.in);
    String[] predicted=new String[word.length()];
    for(int i=0;i<word.length();i++)
    {
        predicted[i]="_";
    }
    int correctGuess=0;
    int incorrectGuess=0;
    String miss="";
    System.out.println(gallows[incorrectGuess]);
    System.out.print("Word: ");
    printWord(predicted);
    System.out.print("\nMisses: "+miss);
    System.out.print("\nGuess : ");
    String guess=scan.nextLine();
    while(correctGuess!=word.length())
    { boolean bool =false;
      for(int i=0;i<word.length();i++)
      { 
        if(guess.equals(""+word.charAt(i)))
        { 
          predicted[i]=guess;  
          correctGuess++;
          bool=true;
        }
        }
        if(!bool)
        {
            incorrectGuess++;
            miss=miss+guess;
        }
        
    System.out.println(gallows[incorrectGuess]);
    System.out.print("Word: ");
    printWord(predicted);
    if(incorrectGuess==6)
    {
        System.out.println("\n\nRIP");
        System.out.print("The Word Was : "+word);
        System.exit(0);
    }
    if(correctGuess==6)
    {
        System.out.println("\nCongratulation!!! You have Guessed the word right ");
        System.exit(0);
    }
    System.out.print("\nMisses: "+miss);
    System.out.print("\nGuess : ");
    guess=scan.nextLine();

    }



 }
  public static void printWord(String[] predicted)
  {
    for(int i=0;i<predicted.length;i++)
    {
        System.out.print(predicted[i]+" ");
    }
  }


    public static  String selectRandomword(){
    double no=Math.random() * (words.length);
    int integer=(int)no;
    return words[integer]; 
    }

}






