import java.util.ArrayList;
import java.util.UUID;
/**
 * Initalizes the Admin class
 * @author Aaron Thompson
 */
public class Admin{
    private ArrayList<Admin> admins = AdminList.getAdminsList();
    private String name;
    private String password;
    private UUID uuid;
    private String email;
    private String username;

    /**
     * Constructor for an admin.
     * @author Aaron Thompson
     * @param adminID
     * @param adminName
     * @param adminPassword
     * @param adminEmail
     * @param Username
     */
    public Admin(UUID adminID, String adminName, String adminPassword, String adminEmail, String Username) {
        this.name = adminName;
        this.password = adminPassword;
        this.uuid = adminID;
        this.email = adminEmail;
        this.username = Username;
    }

    /**
     * Adds an admin to the Admin ArrayList

     * @author Aaron Thompson
     * @param admin
     */
    public void addAdmin(Admin admin) {
        admins.add(admin);
    }

    /**
     * returns the admin whose username was provided

     * @author Aaton Thompson 
     * @param Username
     * @return
     */
    public Admin getAdmin(String Username) {
        try {
            for (int i = 0; i < admins.size(); i++) {
                if (admins.get(i).toString().contains(Username))
                    return admins.get(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Deletes a job based on the businessID and title.

     * @param list
     * @param businessID
     * @param title
     */
    public void deleteJob(JobListingList list, String businessID, String title) {
        list.deleteJob(businessID, title);
    }

    /**
     * Deletes a student based on the students ID.

     * @param list
     * @param studentID
     */
    public void deleteStudent(StudentList list, String studentID) {
        list.deleteStudent(studentID);
    }

    /**
     * Deletes a business based on the businesses ID.

     * @param list
     * @param businessID
     */
    public void deleteBusiness(BusinessList list, String businessID) {
        list.deleteBusiness(businessID);
    }

    /**
     * Returns an admin's Name.

     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Returns an admin's Password.

     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     * Returns an admin's UUID

     * @return
     */
    public UUID getUUID() {
        return uuid;
    }

    /**
     * Returns an admin's Email.

     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     * Returns an admin's Username.

     * @return
     */
    public String getUsername(){
        return username;
    }
}
