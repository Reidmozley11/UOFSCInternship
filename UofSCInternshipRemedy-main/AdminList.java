
/**
 * A group of admins with easy access to the admin you want
 * @author Reid Mozley
 */

import java.util.ArrayList;

public class AdminList implements UserList{
    private static AdminList list = null;
    private static ArrayList<Admin> admins;
    

    /**
     * Loads the adminList from the DataLoader.
     * @author Aaron Thompson
     */
    private AdminList() {
        admins = DataLoader.loadAdmin();
    }
    /**
     * Checks to see if there is an instance of an Adminlist and if there isn't creates one, returning the list.
     * @return
     */
    public static AdminList getInstance() {
        if (list == null)
            list = new AdminList();
        return list;
    }
    /**
     * Reads the AdminList for an Admin's name and returns the Admin associated with the name.
     * @param AdminName
     * @return
     */
    public Admin getAdmin(String AdminName) {
        for (int i = 0; i < admins.size(); i++)
            if (admins.get(i).toString().contains(AdminName))
                return admins.get(i);
        return null;
    }
    /**
     * Returns an admin based on it ID number.
     * @param i
     * @return
     */
    public Admin getAdminID(int i) {
        return admins.get(i);
    }
    /**
     * Adds an admin to the adminList.
     * @param admin
     */
    public static void addAdmin(Admin admin) {
        admins.add(admin);
    }
    /**
     * Returns the adminList.
     * @return
     */
    public static ArrayList<Admin> getAdminsList() {
        return admins;
    }
    /**
     * Returns the admins Username based on the location in the list.
     * @param i
     * @return
     */
    public String getUsername(int i) {
        return admins.get(i).getUsername();
    }
    /**
     * Returns the admins Password based on the location in the list.
     * @param i
     * @return
     */
    public String getPassword(int i) {
        return admins.get(i).getPassword();
    }
    /**
     * Returns the size of the adminList ArrayList.
     * @return
     */
    public int getSize() {
        return admins.size();
    }
    /**
     * Returns a string containing the word Admin.
     */
    public String getType(String username, String password) {
        return "Admin";
    }
}
