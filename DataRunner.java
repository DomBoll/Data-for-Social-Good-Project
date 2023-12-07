/**
 * Begins and enacts each step of the program, including: creating the list of books with all of their reviews,
 * creating a QuestionAsker object, and telling that QuestionAsker object to run the keyword search.
 *
 * @author Dominic Bollettieri
 */
public class DataRunner {
  
  public static void main(String[] args) {

    //Creates a BookList from the titles, publication dates, and ratings in the text files
    BookList books = new BookList(FileReader.toStringArray("Titles.txt"), 
                                  FileReader.toIntArray("Years.txt"), 
                                  FileReader.toDoubleArray("Ratings.txt"));


    //Adds Reviews to the BookList with text files for each review's title, body text, and the book it corresponds to
    books.addReviews(FileReader.toStringArray("ReviewBookTitles.txt"), 
                     FileReader.toStringArray("ReviewTitles.txt"), 
                     FileReader.toStringArray("Reviews.txt"));

    
    //Creates a basic QuestionAsker object in order to begin printing messages
    QuestionAsker questionAsker = new QuestionAsker();

    
    //Tells the questionAsker to print the introduction
    questionAsker.sayHi();


    //Tells the questionAsker to ask the user for a keyword and then print the books that contain that keyword
    questionAsker.printBooks(books.filterBooks(questionAsker.askForKeyword()));
    
  }
}