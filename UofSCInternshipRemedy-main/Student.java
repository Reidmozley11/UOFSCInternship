import java.util.ArrayList;
import java.util.UUID;

/**
 * a virtual representation of a student with their resumes and applications
 * 
 * @author Dreyson Clark
 */

public class Student{
    ArrayList<Student> students = StudentList.getStudents();
    UUID uuid;
    String Name, Password, Email, Skills, Education, PreviousWork, Location, Applications, Username, PhoneNumber;

    /**
     * Constructor for a student object.
     *
     * @param uuid
     * @param Name
     * @param Password
     * @param Email
     * @param Skills
     * @param Education
     * @param PreviousWork
     * @param Location
     * @param Applications
     * @param Username
     */
    public Student(UUID uuid, String Name, String Password, String Email, String Skills, String Education,
            String PreviousWork, String Location, String Applications, String Username, String PhoneNumber) {
        this.uuid = uuid;
        this.Name = Name;
        this.Password = Password;
        this.Email = Email;
        this.Skills = Skills;
        this.Education = Education;
        this.PreviousWork = PreviousWork;
        this.Location = Location;
        this.Applications = Applications;
        this.Username = Username;
        this.PhoneNumber = PhoneNumber;
    }

    /**
     * Sets the skills for the Student.
     *
     * @param skills
     */
    public void setSkills(String skills) {
        this.Skills = skills;
    }

    /**
     * Sets the Education for the student.
     *
     * @param education
     */
    public void setEducation(String education) {
        this.Education = education;
    }

    /**
     * Sets the previousWork for the student.
     *
     * @param previousWork
     */
    public void setPreviousWork(String previousWork) {
        this.PreviousWork = previousWork;
    }

    /**
     * Sets the Location for the student.
     *
     * @param location
     */
    public void setLocation(String location) {
        this.Location = location;
    }

    /**
     * Sets the Name for the student.
     *
     * @param name
     */
    public void setName(String name) {
        this.Name = name;
    }

    /**
     * Sets the password for the student.
     *
     * @param password
     */
    public void setPassword(String password) {
        this.Password = password;
    }

    /**
     * Sets the Email for the student.
     *
     * @param email
     */
    public void setEmail(String email) {
        this.Email = email;
    }

    /**
     * Sets the Username for the student.
     *
     * @param username
     * @return
     */
    public String setUsername(String username) {
        return this.Username = username;
    }

    /**
     * Returns the Applications for the student.
     *
     * @return
     */
    public String getApplications() {
        return this.Applications;
    }

    /**
     * Returns the Location for the student.
     *
     * @return
     */
    public String getLocation() {
        return this.Location;
    }

    /**
     * Returns the Previous Work for the student.
     *
     * @return
     */
    public String getPreviousWork() {
        return this.PreviousWork;
    }

    /**
     * Returns the Education for the student.
     *
     * @return
     */
    public String getEducation() {
        return Education;
    }

    /**
     * Returns the Skills for the student.
     *
     * @return
     */
    public String getSkills() {
        return Skills;
    }

    /**
     * Returns the Email for the student.
     *
     * @return
     */
    public String getEmail() {
        return Email;
    }

    /**
     * Returns the Password for the student.
     *
     * @return
     */
    public String getPassword() {
        return this.Password;
    }

    /**
     * Returns the Name for the student.
     *
     * @return
     */
    public String getName() {
        return Name;
    }

    /**
     * Returns the Username for the student.
     *
     * @return
     */
    public String getUsername() {
        return this.Username;
    }

    /**
     * Returns the UUID for the student.
     *
     * @return
     */
    public UUID getUUID() {
        return uuid;
    }

    /**
     * Converts the Student type to a String to be displayed.
     */
     public String getPhoneNumber(){
         return this.PhoneNumber;
     }

    public String toString() {
        return ("Name: " + this.getName() + "\nEmail: " + this.getEmail() + "\nSkills: " + this.Skills + "\nEducation: "
                + this.Education);
    }
 }