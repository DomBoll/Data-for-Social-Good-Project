/**
 * Represents a single Amazon review of a top 100 bestselling book.
 *
 * @author Dominic Bollettieri
 */
public class Review {
  
  private String title;
  private String body;

  /**
   * Constructor that creates a new Review. Has parameters for both of a Review's instance variables.
   * 
   * @param bookTitle the title of the book that the review is for
   * @param title     the title of the review
   * @param body      the actual text of the review
   */
  public Review(String title, String body) {
    this.title = title;
    this.body = body;
  }
  
  /**
   * Accessor method for the title of a Review.
   *
   * @return   the title of the review
   */
  public String getTitle() {
    return title;
  }
  
  /**
   * toString() method for a Review. Does not include the full body of text because that would be a lot of text.
   *
   * @return   "Review: " with the title of the review surrounded by quotes
   */
  public String toString() {
    return "\nReview: \"" + title + "\"";
  }

  /**
   * Searches the Review's body text and title for anything that matches the keyword. Not case sensitive.
   * 
   * @param  keyword  the search term it is looking for in the review
   * @return          whether the review contains that keyword
   */
  public boolean containsInInfo(String keyword) {
    String fullText = title +" "+ body;
    
    fullText = fullText.toLowerCase();
    
    return (fullText.contains(keyword.toLowerCase()));
  }
  
}