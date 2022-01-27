//import java.util.ArrayList;
// import java.util.Observer;
import java.util.ArrayList;
import java.util.UUID;

/**
 * Initializes the Business class
 * 
 * @author Aaron Thompson
 */

public class Business{
    private UUID businessID;
    private JobListingList temp = JobListingList.getInstance();
    private String name, username, password, listings, EIN;
            private ArrayList<JobListing> myJobs = new ArrayList<JobListing>();
            private ArrayList<JobListing> appliedJobs = new ArrayList<JobListing>();
    public Business(UUID businessUUID, String businessNAME, String businessPASSWORD, String businessLISTINGS,
            String businessEIN, String username) {
        this.businessID = businessUUID;
        this.name = businessNAME;
        this.password = businessPASSWORD;
        this.listings = businessLISTINGS;
        this.EIN = businessEIN;
        this.username = username;
        for(int i=0;i < temp.getJobListings().size();i++){
            ArrayList<JobListing> temps = temp.getJobListings();
            if(temps.get(i).getBusinessID().equals(this.businessID)){
                myJobs.add(temps.get(i));
            }
        }
    }
/**
 * this posts the new instance of job to the array list jobs 
 * @param businessID
 * @param title
 * @param skills
 * @param description
 * @param sponser
 * @param remote
 * @param email
 * @param phoneNumber
 */
    public void postJob(UUID businessID, String title, String skills, String description, String sponser,
            String remote, String email, String phoneNumber) {
        JobListing job = new JobListing(businessID, title, skills, description, sponser, remote, email, phoneNumber, null); 
        myJobs.add(job);
        temp.addJob(job);
        
        this.listings += " - " + job.getTitle();
    }
/**
 * getter for Username which is return this.Username
 * @return this returns the instance of this.Username
 */
    public String getUsername() {
        return this.username;
    }
/**
 * returns business user's ID
 * @return
 */
    public UUID getUUID() {
        return this.businessID;
    }
/**
 * returns name of user
 * @return
 */
    public String getName() {
        return this.name;
    }
/**
 * returns password of user
 * @return
 */
    public String getPassword() {
        return this.password;
    }
/**
 * returns jobs listed
 * @return
 */
    public String getListings() {
        return this.listings;
    }
/**
 * returns EIN number
 * @return
 */
    public String getEIN() {
        return this.EIN;
    }
/**
 * returns job that is applied for allowing for the user to see job applied for.
 * @return
 */
    public ArrayList<JobListing> myAppliedJobs() {
        for (int i = 0; i < myJobs.size(); i++) {
            if (myJobs.get(i).isApplied()) {
                appliedJobs.add(myJobs.get(i));
            }
        }

        return appliedJobs;
    }
}