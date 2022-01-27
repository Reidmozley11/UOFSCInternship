import java.util.ArrayList;
/**
 * Initializes the Review List class
 */
public class ReviewList {
    private static ArrayList<Review> reviews;
    private static ReviewList list;

    /**
     * Constructs the ReviewList using the DataLoader to load
     */
    private ReviewList(){
        reviews = DataLoader.loadReview();
    }

    /**
     * Checks to see if there is an instance of the Review List and 
     * creates one if there isn't one, then returns the list either way.
     *
     * @return 
     */
    public static ReviewList getInstance() {
        if(list==null)
        list = new ReviewList();
        return list;
    }

    /**
     * Returns the Array List of reviews
     */
    public ArrayList<Review> getReviews() {
        return reviews;
    }

    /**
     * Adds a review to the ArrayList of reviews.
     *
     * @param Review
     */
    public static void addReview(Review review){
        reviews.add(review);
    }

    /**
     * Removes a review from the ArrayList when given the reviewID and a studentID.
     *
     * @param reviewID
     * @param studentID
     */
    public void deleteReview(String reviewID, String studentID){
        try {
            for (int i = 0; i < reviews.size(); i++) {
                if (reviews.get(i).toString().contains(reviewID) && reviews.get(i).toString().contains(studentID))
                  reviews.remove(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
