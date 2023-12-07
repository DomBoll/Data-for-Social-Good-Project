import java.util.Scanner;

/**
 * Prints all text that the user sees, and regulates the Scanner used for all user input.
 *
 * @author Dominic Bollettieri
 */
public class QuestionAsker {
  
  Scanner scanner = new Scanner(System.in);

  /**
   * Prints informational text about the data sets and algorithm. Only called at the very beginning of the program.
   */
  public void sayHi() {
    
    System.out.println("This is a data set containing all 100 bestselling books on Amazon, as well as a few reviews for each book.");
    System.out.println("With this program, you are able to search for books by keyword, and then see a list of books whose titles ");
    System.out.println("or reviews match that keyword.\n");
    
  }

  /**
   * Prompts the user for their search term and returns the user's response.
   * 
   * @return       the next line the user types in the form of a String
   */
  public String askForKeyword() {
    
    System.out.println("What word would you like to search for within titles or reviews?\n");
    
    return scanner.nextLine();
  }

  /**
   * Prints an array of books along with text telling the user that these are the results to their search.
   * 
   * @param books   the filtered array of books to be printed
   */
  public void printBooks(Book[] filteredBooks) {

    //Prints intro to the list of books
    System.out.println("\nHere are all Amazon bestselling books that contained your keyword either in their titles or reviews:");
    
    //For each book, prints a line saying what number in the list it is and then prints the book
    for (int i = 1; i<=filteredBooks.length; i++) {
      
      System.out.println("\n\n\n\n------   Book #"+ i + "   ------\n");
      System.out.println(filteredBooks[i-1]);
      
    }
    
  }
  
}