
/**
 * A virtual representation of a job posted by a Business
 * 
 * @author Reid Mozley
 */

import java.util.ArrayList;
import java.util.UUID;

public class JobListing {
    private UUID businessID;
    private String title, skills, description, sponser, remote, email, phoneNumber, applicant;
    private ArrayList<JobListing> Jobs = new ArrayList<JobListing>();
    private ArrayList<Student> applicants = new ArrayList<Student>();

    /**
     * Creates a JobListing
     * 
     * @author Aaron Thompson
     * @param BusinessID
     * @param Title
     * @param Skills
     * @param Description
     * @param Sponser
     * @param Remote
     * @param Email
     * @param PhoneNumber
     */
    public JobListing(UUID BusinessID, String Title, String Skills, String Description, String Sponser, String Remote,
            String Email, String PhoneNumber, String applicant) {
        this.businessID = BusinessID;
        this.title = Title;
        this.skills = Skills;
        this.description = Description;
        this.sponser = Sponser;
        this.remote = Remote;
        this.email = Email;
        this.phoneNumber = PhoneNumber;
        this.applicant = applicant;
    }

    /**
     * Returns a JobListing given a businessID and title.

     * @param businessID
     * @param title
     * @return
     */
    public JobListing getJobListing(UUID businessID, String title) {
        try {
            for (int i = 0; i < Jobs.size(); i++) {
                if (Jobs.get(i).toString().contains(businessID.toString()) && Jobs.get(i).toString().contains(title))
                    return Jobs.get(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Returns the UUID of the business

     * @return
     */
    public UUID getBusinessID() {
        return this.businessID;
    }

    /**
     * Returns the title of the Job Listing

     * @return
     */
    public String getTitle() {
        return this.title;
    }
    /**
     * Returns the skills required for the job

     * @return
     */
    public String getSkills() {
        return skills;
    }

    /**
     * Returns the description of the job.

     * @return
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Returns the sponser of the job.

     * @return
     */
    public String getSponser() {
        return this.sponser;
    }

    /**
     * Returns wheter the job is remote or not.

     * @return
     */
    public String getRemote() {
        return this.remote;
    }

    /**
     * Returns the Email associated with the Job.

     * @return
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Returns the PhoneNumber associated with the job.

     * @return
     */
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    /**
     * Returns the list of Applicants for the job.

     * @return
     */
    public String getApplicants(){
        return this.applicant;
    }

    /**
     * Adds a student to the applicants array and to the applicants string that is displayed.
     *
     * @param student
     */
    public void applied(Student student) {
        applicants.add(student);
        applicant += student.getName()+ ", ";
    }

    /**
     * Checks to see if there are applicants for the job.
     */
    public boolean isApplied() {
        if (applicants != null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Turns the Job Lisiting into a String to be displayed.
     */
    public String toString() {
        return ("\nTitle: " + this.title + "\nSkills: " + this.skills + "\nDescription: " + this.description
                + "\nSponser: " + this.sponser + "\nRemote: " + this.remote + "\nEmail: " + this.email
                + "\nPhone Number: " + this.phoneNumber + "\nApplicants: "+ this.applicant);
    }

    public static void addJobListing(JobListing joblisting) {
    }

    
}
