import java.io.FileReader;
import java.util.ArrayList;
import java.util.UUID;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
/**
 * Initializes the DataLoader class
 */
public class DataLoader extends DataConstants {
    /**
     * Loads the students from the Student JSON file and returns an ArrayList of students.
     * @return
     */
    public static ArrayList<Student> loadStudents() {
        ArrayList<Student> student = new ArrayList<Student>();
        try {
            FileReader reader = new FileReader(STUDENT_FILE_NAME);
            JSONArray studentsJSON = (JSONArray) new JSONParser().parse(reader);
            for (int i = 0; i < studentsJSON.size(); i++) {
                JSONObject studentJSON = (JSONObject) studentsJSON.get(i);
                String StudentName = (String) studentJSON.get(STUDENT_NAME);
                String StudentUUID = (String) studentJSON.get(STUDENT_UUID);
                String StudentPassword = (String) studentJSON.get(STUDENT_PASSWORD);
                String StudentEmail = (String) studentJSON.get(STUDENT_EMAIL);
                String StudentSkills = (String) studentJSON.get(STUDENT_SKILLS);
                String StudentEducation = (String) studentJSON.get(STUDENT_EDUCATION);
                String StudentPreviousWork = (String) studentJSON.get(STUDENT_PREVIOUSWORK);
                String StudentLocation = (String) studentJSON.get(STUDENT_LOCATION);
                String StudentApplications = (String) studentJSON.get(STUDENT_APPLICATIONS);
                String StudentUsername = (String) studentJSON.get(STUDENT_USERNAME);
                String StudentPhoneNumber = (String) studentJSON.get(STUDENT_PHONENUMBER);
                UUID sUUID = UUID.fromString(StudentUUID);

                student.add(new Student(sUUID, StudentName, StudentPassword, StudentEmail, StudentSkills,
                        StudentEducation, StudentPreviousWork, StudentLocation, StudentApplications, StudentUsername, StudentPhoneNumber));
            }
            return student;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * Loads the admins from the Admin JSON file and returns an ArrayList of admins.
     * @return
     */
    public static ArrayList<Admin> loadAdmin() {
        ArrayList<Admin> admin = new ArrayList<Admin>();
        try {
            FileReader reader = new FileReader(ADMIN_FILE_NAME);
            JSONArray adminsJSON = (JSONArray) new JSONParser().parse(reader);
            for (int i = 0; i < adminsJSON.size(); i++) {
                JSONObject adminJSON = (JSONObject) adminsJSON.get(i);
                String adminID = (String) adminJSON.get(ADMIN_UUID);
                String adminName = (String) adminJSON.get(ADMIN_NAME);
                String adminPassword = (String) adminJSON.get(ADMIN_PASSWORD);
                String adminEmail = (String) adminJSON.get(ADMIN_EMAIL);
                String adminUsername = (String) adminJSON.get(ADMIN_USERNAME);
                UUID aUUID = UUID.fromString(adminID);
                admin.add(new Admin(aUUID, adminName, adminPassword, adminEmail, adminUsername));
            }
            return admin;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * Loads the businesses from the Business JSON file and returns an ArrayList of business.
     * @return
     */
    public static ArrayList<Business> loadBusiness() {
        ArrayList<Business> business = new ArrayList<Business>();
        try {
            FileReader reader = new FileReader(BUSINESS_FILE_NAME);
            JSONArray businessesJSON = (JSONArray) new JSONParser().parse(reader);
            for (int i = 0; i < businessesJSON.size(); i++) {
                JSONObject businessJSON = (JSONObject) businessesJSON.get(i);
                String businessUUID = (String) businessJSON.get(BUSINESS_UUID);
                String businessNAME = (String) businessJSON.get(BUSINESS_NAME);
                String businessPASSWORD = (String) businessJSON.get(BUSINESS_PASSWORD);
                String businessLISTINGS = (String) businessJSON.get(BUSINESS_LISTINGS);
                String businessEIN = (String) businessJSON.get(BUSINESS_EIN);
                String businessUsername = (String) businessJSON.get(BUSINESS_USERNAME);
                UUID bUUID = UUID.fromString(businessUUID);
                business.add(new Business(bUUID, businessNAME, businessPASSWORD, businessLISTINGS, businessEIN, businessUsername));
            }
            return business;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * Loads the students from the Students JSON file and returns an ArrayList of students.
     * @return
     */
    public static ArrayList<JobListing> loadJobLising() {
        ArrayList<JobListing> jobListings = new ArrayList<JobListing>();
        try {
            FileReader reader = new FileReader(JOBLISTING_FILE_NAME);
            JSONArray jobListingJSON = (JSONArray) new JSONParser().parse(reader);
            for (int i = 0; i < jobListingJSON.size(); i++) {
                JSONObject jobListJSON = (JSONObject) jobListingJSON.get(i);
                String jobListingBusinessID = (String) jobListJSON.get(JOBLISTING_BUSINESSID);
                String jobListingTitle = (String) jobListJSON.get(JOBLISTING_TITLE);
                String jobListingSkills = (String) jobListJSON.get(JOBLISTING_SKILLS);
                String jobListingDescription = (String) jobListJSON.get(JOBLISTING_DESCRIPTION);
                String jobListingSponser = (String) jobListJSON.get(JOBLISTING_SPONSER);
                String jobListingRemote = (String) jobListJSON.get(JOBLISTING_REMOTE);
                String jobListingEmail = (String) jobListJSON.get(JOBLISTING_EMAIL);
                String jobListingPhoneNumber = (String) jobListJSON.get(JOBLISTING_PHONENUMBER);
                String jobListingApplicants = (String) jobListJSON.get(JOBLISTING_APPLICANTS);
                jobListings.add(
                        new JobListing(UUID.fromString(jobListingBusinessID), jobListingTitle, jobListingSkills, jobListingDescription,
                                jobListingSponser, jobListingRemote, jobListingEmail, jobListingPhoneNumber, jobListingApplicants));
            }
            return jobListings;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * Loads the reviews from the Review JSON file and returns an ArrayList of reviews.
     * @return
     */
    public static ArrayList<Review> loadReview() {
        ArrayList<Review> reviews = new ArrayList<Review>();
        try {
            FileReader reader = new FileReader(REVIEW_FILE_NAME);
            JSONArray reviewsJSON = (JSONArray) new JSONParser().parse(reader);
            for (int i = 0; i < reviewsJSON.size(); i++) {
                JSONObject reviewJSON = (JSONObject) reviewsJSON.get(i);
                String reviewBusinessID = (String) reviewJSON.get(REVIEW_BUSINESSID);
                String reviewStudentID = (String) reviewJSON.get(REVIEW_STUDENTID);
                String reviewReview = (String) reviewJSON.get(REVIEW_REVIEW);
                String reviewRating = (String) reviewJSON.get(REVIEW_RATING);
                reviews.add(new Review(reviewBusinessID, reviewStudentID, reviewReview, reviewRating));
            }
            return reviews;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
