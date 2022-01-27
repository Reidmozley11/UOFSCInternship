import java.util.ArrayList;
/**
 * Initalizes JobListingList class
 */
public class JobListingList {
    private static ArrayList<JobListing> jobs;
    private static JobListingList list;
    private static ArrayList<JobListing> search = new ArrayList<JobListing>();

    private JobListingList() {
        jobs = DataLoader.loadJobLising();
    }

    /**
     * getInstance is getting an instance of joblistinglist and so if the list is
     * null it creates one
     * 
     * @return this returns the list which is a joblistinglist
     */
    public static JobListingList getInstance() {
        if (list == null)
            list = new JobListingList();
        return list;
    }

    /**
     * getJobListing is returning the array list of all the jobs
     * 
     * @return this is returning the entire array list of the jobs which are all
     *         joblistings
     */
    public ArrayList<JobListing> getJobListings() {
        return jobs;
    }

    /**
     * This method is taking the job and adding it into the array list jobs
     * 
     * @param job is a joblisting that holds users input
     */
    public static void addJob(JobListing job) {
        jobs.add(job);
    }

    /**
     * deleteJob has the function of being able to remove a specific job if it
     * matches the BusinessID and title to remove it from the arraylist
     * 
     * @param businessID this is the ID of a specific business that the user inputs
     * @param title      this the title of the job that the user will input to be
     *                   able to delete
     */
    public void deleteJob(String businessID, String title) {
        try {
            for (int i = 0; i < jobs.size(); i++) {
                if (jobs.get(i).toString().contains(businessID) && jobs.get(i).toString().contains(title))
                    jobs.remove(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * searchJobs is a method that takes the users inputted value and runs through
     * the jobs arraylist to check to see if any of the skills in the job match what
     * the user is looking for
     * 
     * @param skill this is the value that the user is searching for specifically
     * @return this returns the ArrayList search that contains all the jobs that
     *         match the users search
     */
    public static ArrayList<JobListing> searchJobs(String skill) {
        for (int i = 0; i < jobs.size(); i++) {
            String jobsskills = jobs.get(i).getSkills();
            String jobkills[] = jobsskills.split(", ");
            for (int j = 0; j < jobkills.length; j++) {
                if (jobkills[j].equals(skill)) {
                    search.add(jobs.get(i));
                }
            }
        }
        return search;
    }
    /**
     * Uses a Student and a Job title to add a Student to the list of applicants.
     *
     * @author Reid Mozley
     * @param student
     * @param job
     */
    public void applyJob(Student student, String job) {
        for (int i = 0; i < jobs.size(); i++) {
            if (jobs.get(i).getTitle().equalsIgnoreCase(job)) {
                jobs.get(i).applied(student);
            }
        }
    }

	public static void addJobListing(JobListing joblisting) {
        jobs.add(joblisting);
	}

}
