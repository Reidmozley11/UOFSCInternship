
import java.util.ArrayList;
import java.util.UUID;

/**
 * A Facade method for the userinterface
 * 
 * @author Reid Mozley
 */
public class UIFacade {
    private AdminList adminList;
    private BusinessList businessList;
    private JobListingList jobListingList;
    private Logon logon;
    private Student student;
    private StudentList studentList;

/**
 * Constructor for the UIFacade class.
 */
    public UIFacade() {
        logon = new Logon();
        businessList = BusinessList.getInstance();
        adminList = AdminList.getInstance();
        studentList = StudentList.getInstance();
        jobListingList = JobListingList.getInstance();
    }

    /**
     * Runs logon's check credentials method to ensure our user is in the system
     * already
     * 
     * @author Reid Mozley
     * @param username the users entered username
     * @param password the users entered password
     * @return returns a boolean true if the user is real and in the system
     */
    public boolean checkUser(String username, String password) {
        if (logon.checkCredentials(username, password)) {
            return true;
        } else {
            return false;
        }
    }
/**
 * This is a method of Admin in which is checking the object
 * That if it equals admin in the checkType then it will return the admin to the list
 * @param username the users inputted username
 * @param password the users inputted password
 * @return either returns null if the account isn't a admin or returns an instance of the admin list
 */
    public Admin checkObjectAdmin(String username, String password) {
        if (logon.checkType(username, password).equals("Admin")) {
            return adminList.getAdmin(username);
        } else
            return null;
    }
/**
 * This is a method of Student in which is checking the object
 * That if it equals student in the checkType then it will return the student to the list
 * @param username the users inputted username
 * @param password the users inputted password
 * @return either returns null if the account isn't a student or returns an instance of the business list
 */
    public Student checkObjectStudent(String username, String password) {
        if (logon.checkType(username, password).equals("Student"))
            return studentList.getStudent(username);
        else
            return null;
    }
/**
 * This is a method of Business in which is checking the object
 * That if it equals business in the checkType then it will return the business to the list
 * @param username the users inputted username
 * @param password the users inputted password
 * @return either returns null if the account isn't a business or returns an instance of the business list
 */
    public Business checkObjectBusiness(String username, String password) {
        if (logon.checkType(username, password).equals("Business"))
            return businessList.getBusiness(username);
        else
            return null;
    }
/**
 * This checks the ID of the account via their username and password which returns the type
 * @param username this is the instance of username that is inputted
 * @param password this is the instance of password that is input
 * @return the type of either account or null
 */
    public String checkID(String username, String password) {
        if (logon.checkType(username, password).equals("Admin")) {
            return "Admin";
        } else if (logon.checkType(username, password).equals("Student"))
            return "Student";
        else if (logon.checkType(username, password).equals("Business"))
            return "Business";
        else
            return null;
    }
    /**
     * This creates an instance of Student
     * And then put it into logon

     * @param username their username
     * @param password their password
     * @param uuid their uuid
     * @param email their email
     * @param name their name
     * @param phoneNumber their phone number
     */
    public void createStudent(String username, String password, UUID uuid, String email, String name, String phoneNumber) {
        logon.createStudentAccount(username, password, uuid, email, name, phoneNumber);
    }

    /**
    * This creates an instance of Business
    * And then put it into logon 

    * @param username their username
    * @param password their password
    * @param uuid their uuid
    * @param email their email
    * @param ein their ein
    * @param name their name
    */
    public void createBusiness(String username, String password, UUID uuid, String email, String ein, String name) {
        logon.createBusinessAccount(username, password, uuid, email, ein, name);
    }

    /**
    * This creates an instance of Admin
    * And then put it into logon
    *
    * @param username their username
    * @param password their password
    * @param uuid their uuid
    * @param email their email
    * @param name their name
    */
    public void createAdmin(String username, String password, UUID uuid, String email, String name) {
        logon.createAdminAccount(email, password, null, username, name);
    }

    /**
     * This block of methods are in charge of creating the students resume!
     * 
     * @author Reid Mozley
     */
    public void resumeSkills(String skills) {
        student.setSkills(skills);
    }
    
    /**
    * Sets the education that the student inputted in for their resume
    *
    * @param education
    */
    public void resumeEducation(String education) {
        student.setEducation(education);
    }
    
    /**
    * This grabs the previousWork of the student and sets it into their resume
    * @param previousWork this is inputted string of their previousWork
    */
    public void resumePreviousWork(String previousWork) {
        student.setPreviousWork(previousWork);
    }
    
    /**
    * This is resumeLocation which grabs the location and sets it in the resume
    * @param location this is a string that allows the student to add their location to their resume
    */
    public void resumeLocation(String location) {
        student.setLocation(location);
    }

    /**
     * This is returning the array list of the method search jobs to the ui
     * 
     * @param skills this is the users inputted searched skill
     * @return This is returning the array list of the searchjobs
     */
    public ArrayList<JobListing> searchJobss(String skills) {
        return JobListingList.searchJobs(skills);
    }

    /**
    * This is grabbing the student based on their username
    *
    * @param username this is the students username being passed through
    * @return this returns a student based on their username
    */
    public Student grabStudent(String username) {
        return logon.studentGrabber(username);
    }

    /**
    * This is allowing a student to apply to the specific job they are trying to access
    *  
    * @param student This is the specific of the student that is the student who is applying
    * @param jobapply this would be the job they are trying to apply to
    */
    public void apply(Student student, String jobapply) {
        jobListingList.getInstance().applyJob(student, jobapply);
    }
}