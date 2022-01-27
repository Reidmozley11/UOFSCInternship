import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Initalizes the DataWriter class
 */
public class DataWriter extends DataConstants {

	/**
	 * Writes the changes to the studentList to the Student JSON.
	 */
	public static void saveStudent() {
		StudentList studentList = StudentList.getInstance();
		ArrayList<Student> students = studentList.getStudents();
		JSONArray StudentsJSON = new JSONArray();

		for (int i = 0; i < students.size(); i++) {
			StudentsJSON.add(getStudentJSON(students.get(i)));
		}

		try (FileWriter file = new FileWriter(STUDENT_FILE_NAME)) {

			file.write(StudentsJSON.toJSONString());
			file.flush();
			file.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Writes a student into a JSON Object and returns it to add to the JSON file.
	 *
	 * @param student
	 * @return
	 */
	public static JSONObject getStudentJSON(Student student) {
		JSONObject StudentJSON = new JSONObject();
		StudentJSON.put(STUDENT_UUID, student.getUUID().toString());
		StudentJSON.put(STUDENT_NAME, student.getName());
		StudentJSON.put(STUDENT_PASSWORD, student.getPassword());
		StudentJSON.put(STUDENT_EMAIL, student.getEmail());
		StudentJSON.put(STUDENT_SKILLS, student.getSkills());
		StudentJSON.put(STUDENT_EDUCATION, student.getEducation());
		StudentJSON.put(STUDENT_PREVIOUSWORK, student.getPreviousWork());
		StudentJSON.put(STUDENT_LOCATION, student.getLocation());
		StudentJSON.put(STUDENT_APPLICATIONS, student.getApplications());
		StudentJSON.put(STUDENT_USERNAME, student.getUsername());
		StudentJSON.put(STUDENT_PHONENUMBER, student.getPhoneNumber());

		return StudentJSON;
	}

	/**
	 * Writes the changes to the businessList to the Business JSON.
	 *
	 */
	public static void saveBusiness() {
		BusinessList businessList = BusinessList.getInstance();
		ArrayList<Business> businesses = businessList.getBusinesses();
		JSONArray BusinessesJSON = new JSONArray();

		for (int i = 0; i < businesses.size(); i++) {
			BusinessesJSON.add(getBusinessJSON(businesses.get(i)));
		}

		try (FileWriter file = new FileWriter(BUSINESS_FILE_NAME)) {

			file.write(BusinessesJSON.toJSONString());
			file.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Writes a business into a JSON Object and returns it to add to the JSON file.
	 *
	 * @param business
	 * @return
	 */
	public static JSONObject getBusinessJSON(Business business) {
		JSONObject BusinessJSON = new JSONObject();
		BusinessJSON.put(BUSINESS_UUID, business.getUUID().toString());
		BusinessJSON.put(BUSINESS_NAME, business.getName());
		BusinessJSON.put(BUSINESS_PASSWORD, business.getPassword());
		BusinessJSON.put(BUSINESS_LISTINGS, business.getListings());
		BusinessJSON.put(BUSINESS_EIN, business.getEIN());
		BusinessJSON.put(BUSINESS_USERNAME, business.getUsername());

		return BusinessJSON;
	}

	/**
	 * Writes the changes to the reviewList to the Review JSON.
	 */
	public static void saveReview() {
		ReviewList reviewList = ReviewList.getInstance();
		ArrayList<Review> review = reviewList.getReviews();
		JSONArray reviewJSON = new JSONArray();

		for (int i = 0; i < review.size(); i++) {
			reviewJSON.add(getReviewJSON(review.get(i)));
		}

		try (FileWriter file = new FileWriter(REVIEW_FILE_NAME)) {

			file.write(reviewJSON.toJSONString());
			file.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Writes a review into a JSON Object and returns it to add to the JSON file.
	 *
	 * @param review
	 * @return
	 */
	public static JSONObject getReviewJSON(Review review) {
		JSONObject reviewJSON = new JSONObject();
		reviewJSON.put(REVIEW_BUSINESSID, review.getBusinessID().toString());
		reviewJSON.put(REVIEW_STUDENTID, review.getStudentID().toString());
		reviewJSON.put(REVIEW_REVIEW, review.getReview());
		reviewJSON.put(REVIEW_RATING, review.getRating());

		return reviewJSON;
	}

	/**
	 * Writes the changes to the jobListingList to the JobListing JSON.
	 */
	public static void saveJobListing() {
		JobListingList jobListingList = JobListingList.getInstance();
		ArrayList<JobListing> jobListings = jobListingList.getJobListings();
		JSONArray JobListingsJSON = new JSONArray();

		for (int i = 0; i < jobListings.size(); i++) {
			JobListingsJSON.add(getJobListingJSON(jobListings.get(i)));
		}

		try (FileWriter file = new FileWriter(JOBLISTING_FILE_NAME)) {

			file.write(JobListingsJSON.toJSONString());
			file.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Writes a JobListing into a JSON Object and returns it to add to the JSON file.
	 *
	 * @param jobListing
	 * @return
	 */
	public static JSONObject getJobListingJSON(JobListing jobListing) {
		JSONObject JobListingJSON = new JSONObject();
		JobListingJSON.put(JOBLISTING_BUSINESSID, jobListing.getBusinessID().toString());
		JobListingJSON.put(JOBLISTING_TITLE, jobListing.getTitle());
		JobListingJSON.put(JOBLISTING_SKILLS, jobListing.getSkills());
		JobListingJSON.put(JOBLISTING_DESCRIPTION, jobListing.getDescription());
		JobListingJSON.put(JOBLISTING_SPONSER, jobListing.getSponser());
		JobListingJSON.put(JOBLISTING_REMOTE, jobListing.getRemote());
		JobListingJSON.put(JOBLISTING_EMAIL, jobListing.getEmail());
		JobListingJSON.put(JOBLISTING_PHONENUMBER, jobListing.getPhoneNumber());
		JobListingJSON.put(JOBLISTING_APPLICANTS, jobListing.getApplicants());

		return JobListingJSON;
	}

	/**
	 * Writes a resume to a txt file given a name and student.
	 *
	 * @param name
	 * @param student
	 */
	public static void createResumeFile(String name, Student student) {
		try {
			File myObj = new File(name + ".txt");
			FileWriter myWriter = new FileWriter(name + ".txt");
			if (myObj.createNewFile()) {
				System.out.println("File already exists.");
			} else {
				myWriter.write("Name: " + student.getName() + "\nEmail: " + student.getEmail() + "\nSkills: "
						+ student.getSkills() + "\nEducation: \n" + student.getEducation() + "\nPreviousWork: \n"
						+ student.getPreviousWork() + "\nLocation: " + student.getLocation()+"\nPhone Number: "+student.getPhoneNumber());
				myWriter.close();
				System.out.println("File created: " + myObj.getName());
			}
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
}