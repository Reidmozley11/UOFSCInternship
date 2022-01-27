import java.util.UUID;

/**
 * Initalizes the Review class
 */
public class Review {
    private String businessID, studentID,review;
    private int rating;
  

    /**
     * Constructor for a Review.
     *
     * @param reviewBusinessID
     * @param reviewStudentID
     * @param reviewReview
     * @param reviewRating
     */
    public Review(String BusinessID, String StudentID, String reviewReview, String reviewRating){
        this.businessID = BusinessID;
        this.studentID = StudentID;
        this.review = reviewReview;
        this.rating = Integer.parseInt(reviewRating);
    }
   
    /**
     * Returns the businessID associated with the review.
     *
     * @return
     */
    public String getBusinessID() {
        return this.businessID;
    }

    /**
     * Returns the studentID associated with the review.
     *
     * @return
     */
    public String getStudentID() {
        return this.studentID;
    }

    /**
     * Returns the review associated with the review.
     *
     * @return
     */
    public String getReview() {
        return this.review;
    }

    /**
     * Returns the rating associated with the review.
     *
     * @return
     */
    public int getRating() {
        return this.rating;
    }
}
