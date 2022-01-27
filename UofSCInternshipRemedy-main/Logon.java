import javax.security.auth.login.AccountException;
import java.util.Scanner;
import java.util.Set;
import java.util.UUID;
/**
 * the logon class allows the user to logon to the application, 
 *if the credentials aren't matched in the list, the user can create a new account.
 */
public class Logon {

    private String password;
    private String username;
    private String ein;
    private String email;
    private BusinessList businessList;
    private AdminList adminList;
    private StudentList studentList;
/**
* instances of each list of types of users
*/
    public Logon() {
        studentList = StudentList.getInstance();
        businessList = BusinessList.getInstance();
        adminList = AdminList.getInstance();
    }
/**
* checks each username and password in the list and returns true if found
*
* @param username 
* @param password
*/
    public boolean checkCredentials(String username, String password) {

        for (int i = 0; i < studentList.getSize(); i++) {
            if (studentList.getUsername(i).equals(username)) {
                if (studentList.getPassword(i).equals(password)) {
                    return true;
                }
            }
        }
        for (int i = 0; i < businessList.getSize(); i++) {
            if (businessList.getUsername(i).equals(username)) {
                if (businessList.getPassword(i).equals(password)) {
                    return true;
                }
            }
        }
        for (int i = 0; i < adminList.getSize(); i++) {
           if (adminList.getUsername(i).equals(username)) {
               if (adminList.getPassword(i).equals(password)) {
                    return true;
                }
            }
        }
        return false;
    }
/**
* checks the type of user and returns the username and password 
*
* @param username
* @param password
*/
    public String checkType(String username, String password) {

        for (int i = 0; i < studentList.getSize(); i++) {
            if (studentList.getUsername(i).equals(username)) {
                if (studentList.getPassword(i).equals(password)) {
                    return studentList.getType(username,password);
                }
            }
        }
        for (int i = 0; i < businessList.getSize(); i++) {
            if (businessList.getUsername(i).equals(username)) {
                if (businessList.getPassword(i).equals(password)) {
                    return businessList.getType(username,password);
                }
            }
        }
        for (int i = 0; i < adminList.getSize(); i++) {
            if (adminList.getUsername(i).equals(username)) {
                if (adminList.getPassword(i).equals(password)) {
                    return adminList.getType(username,password);
                }
            }
        }
        return null;
    }

    /**
    * Gets the id of specified user
    *
    * @return returns the typeID if it is the same in the type list
    * @param username
    * @param password
    */
    public UUID getID(String username, String password) {

        for (int i = 0; i < studentList.getSize(); i++) {
            if (studentList.getUsername(i).equals(username)) {
                if (studentList.getPassword(i).equals(password)) {
                    return studentList.getStudentID(i).getUUID();
                }
            }
        }
        for (int i = 0; i < businessList.getSize(); i++) {
            if (businessList.getUsername(i).equals(username)) {
                if (businessList.getPassword(i).equals(password)) {
                    return businessList.getBusinessID(i).getUUID();
                }
            }
        }
        for (int i = 0; i < adminList.getSize(); i++) {
            if (adminList.getUsername(i).equals(username)) {
                if (adminList.getPassword(i).equals(password)) {
                    return adminList.getAdminID(i).getUUID();
                }
            }
        }
        return null;
    }

    /**
     * Grabs an instance of a student by search using just their username.
     * 
     * @param username The student's username we are searching for
     * @return Returns an instance of the student searched by username
     */
    public Student studentGrabber(String username) {
        for (int i = 0; i < studentList.getSize(); i++) {
            if (studentList.getUsername(i).equals(username)) {
                return studentList.getStudentID(i);
            }
        }
        return null;
    }

    /**
    *creates the student type account using the specified parameters and adds them to the student list
    *
    * @param username
    * @param password
    * @param uuid
    * @param email
    * @param name
    * @param PhoneNumber
    */
    public void createStudentAccount(String username, String password, UUID uuid, String email, String Name, String PhoneNumber) {
        Student temp = new Student(uuid, Name, password, email, null, null, null, null, null, username, PhoneNumber);
        StudentList.addStudent(temp);
    }

    /**
    *creates the business type account using the specified parameters and adds them to the buisness list
    *
    * @param username
    * @param password
    * @param uuid
    * @param email
    * @param ein
    * @param Name
    */
    public void createBusinessAccount(String username, String password, UUID uuid, String email, String ein, String Name) {
        Business temp = new Business(null, Name, password, null, null, username);
        BusinessList.addBusiness(temp);
    }

    /**
    * creates the admin type account using the specified parameters and adds them to the admin list
    *
    * @param username
    * @param password
    * @param uuid
    * @param email
    * @param Name
    */
    public void createAdminAccount(String username, String password, UUID uuid, String email, String Name) {
        Admin temp = new Admin(uuid, Name, password, email, username);
        AdminList.addAdmin(temp);
    }

    /**
    * sets this.password
     */
    public void setPassword() {
        this.password = password;
    }

    /**
    * sets this.username 
    */
    public void setUsername() {
        this.username = username;
    }

    /**
    * @param password
    * @return returns the user password 
    */
    public String getPassword(String password) {
        return password;
    }

    /**
    * @param username
    * @return returns the users username
    */
    public String getUsername(String username) {
        return username;
    }

    /**
    * @param email
    * @return returns the user email
    */
    public String getEmail(String email) {
        return email;
       
    }

    /**
    * @return returns the user UUID
    */
    public UUID getUUID() {
        UUID uuid = UUID.randomUUID();
        return uuid;
    }

    /**
    * @param ein
    * returns the business EIN number
    */
    public String getEin(String ein) {
        return ein;
    }
}
