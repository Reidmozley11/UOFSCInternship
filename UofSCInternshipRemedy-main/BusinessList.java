import java.util.ArrayList;

public class BusinessList implements UserList{
    private static BusinessList list;
    private static ArrayList<Business> businesses;

    // String applications
    private BusinessList() {
        businesses = DataLoader.loadBusiness();
    }
/**
 * returns the BusinessList, if there isn't one, a new list is created.
 * @return
 */
    public static BusinessList getInstance() {
        if (list == null)
            list = new BusinessList();
        return list;
    }
/**
 * return list of buisnesses
 * @return
 */
    public static ArrayList<Business> getBusinesses() {
        return businesses;
    }
/**
 * adds a buisness to the list of businesses
 */
    public static void addBusiness(Business business) {
        businesses.add(business);
    }
/**
 * While going through the business list, search for the buisness specified in the business list
 * @param BusinessName
 * @return
 */
    public Business getBusiness(String BusinessName) {
        for (int i = 0; i < businesses.size(); i++)
            if (businesses.get(i).getUsername().equals(BusinessName))
                return businesses.get(i);
        return null;
    }
/**
 * returns the business at specified element
 * @param i
 * @return
 */
    public Business getBusinessID(int i) {
        return businesses.get(i);
    }
/**
 * if the business is found in the list, delete it from that index.
 * @param businessID
 */
    public void deleteBusiness(String businessID) {
        try {
            for (int i = 0; i < businesses.size(); i++) {
                if (businesses.get(i).toString().contains(businessID))
                    businesses.remove(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Returns the number of businesses in the list.
     * @return
     */
    public int getSize() {
        return businesses.size();
    }
    /**
     * Returns the username of the business located at index point i.
     * @param i
     * @return
     */
    public String getUsername(int i) {
        return businesses.get(i).getUsername();
    }
    /**
     * Returns the password of the business located at index point i.
     * @param i
     * @return
     */
    public String getPassword(int i) {
        return businesses.get(i).getPassword();
    }
    /**
     * Returns the string Business to indicate the type of the item.
     * @param username
     * @param password
     */
    public String getType(String username, String password) {
        return "Business";
    }
}