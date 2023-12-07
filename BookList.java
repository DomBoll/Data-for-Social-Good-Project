/**
 * Represents all of Amazon's top 100 bestselling books, along with all of their reviews.
 *
 * @author Dominic Bollettieri
 */
public class BookList {

  public Book[] books;

  /**
   * Constructor that takes in three different arrays for titles, years, and ratings and creates a new 
   * array of Books[] using info from all three of those arrays.
   *
   * @param titles         all 100 books' titles
   * @param years          all 100 books' years of publication
   * @param averageRatings all 100 books' average ratings out of 5
   */
  public BookList(String[] titles, int[] years, double[] averageRatings) {
    
    //Initiallizes the books array to the right length
    books = new Book[titles.length];

    //For each book, it creates a new book using the elements of the other arrays at the same index
    for (int i = 0; i<books.length; i++){
      
      books[i] = new Book(titles[i], years[i], averageRatings[i]);
      
    }
    
  }

  /**
   * Takes in arrays of review titles and body texts, and adds each in the form of a Review to the book whose 
   * title corresponds to the indexed number in the bookTitles array.
   * 
   * @param bookTitles     the title of the book that each review corresponds to
   * @param reviewTitles   the title of each review
   * @param reviewBodies   the full text to every review
   */
  public void addReviews(String[] bookTitles, String[] reviewTitles, String[] reviewBodies) {

    //Does the following for each book:
    for (Book book : books){

      //Looks at the book title to every review and if it matches up with the title of the book:
      for (int i = 0; i<bookTitles.length; i++) {
        if (book.getTitle().equals(bookTitles[i])){
          
          //Then it adds a new Review to the Book that has all of the info from the same index number.
          book.addReview(new Review(reviewTitles[i], reviewBodies[i]));
          
        }
        
      }
      
    }
    
  }

  /**
   * Filter algorithm for the books that contain a specific keyword in their titles or reviews.
   * 
   * @param keyword  the keyword that the BookList searches for within its books
   * @return         the filtered list of all books that contain the keyword
   */
  public Book[] filterBooks(String keyword) {

    //Sets up the array that will be eventually returned along with the int used to set the length of the array and
    //the index used to traverse the filteredBooks array
    Book[] filteredBooks;
    int filteredBooksLength = 0;
    int filteredBooksIndex = 0;

    //Aggregator that finds how many books contain the keyword
    for (Book book : books){
      if (book.containsInInfo(keyword)){
        filteredBooksLength++;
      }
    }

    //Sets the filteredBooks array to a new empty array with the proper length to exactly fit all books that fit the filter
    filteredBooks = new Book[filteredBooksLength];

    //Traverses books again, this time filling up the filteredBooks array
    for (Book book : books){

      //When it sees a book that contains the keyword, it puts it in the filteredBooks array at the next open spot
      if (book.containsInInfo(keyword)){
        filteredBooks[filteredBooksIndex] = book;
        filteredBooksIndex++;
      }
      
    }

    return filteredBooks;
  }
}