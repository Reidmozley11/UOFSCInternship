import java.util.ArrayList;

/**
 * A group of students for easy access to specific students
 * 
 * @author Reid Mozley
 */
public class StudentList implements UserList{
    private static ArrayList<Student> students;
    private static StudentList list;
    private StudentList() {
        students = DataLoader.loadStudents();
    }
    /**
     * Adds a student to the ArrayList of students.
     * @param student
     */
    public static void addStudent(Student student) {
        students.add(student);
    }
    /**
     * Removes a student from the ArrayList of students.
     * @param studentID
     */
    public void deleteStudent(String studentID) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getUUID().toString().equals(studentID)) {
                students.remove(i);
                return;
            }
        }
    }
    /**
     * Returns the list of students.
     * @return
     */
    public static ArrayList<Student> getStudents() {
        return students;
    }
    /**
     * Returns the student residing at position i in the array.
     * @param i
     * @return
     */
    public Student getStudentID(int i) {
        return students.get(i);
    }
    /**
     * Checks if there is already an instance of the StudentList, constructs one if there isn't and returns the list either way.
     * @return
     */
    public static StudentList getInstance() {
        if (list == null)
             list = new StudentList();
        return list;
    }
    /**
     * Returns the size of the student Array.
     * @return
     */
    public int getSize(){
        return students.size();
    }
    /**
     * Returns the username of the student at index location i.
     * @param i
     * @return
     */
    public String getUsername(int i) {
        Student temper = students.get(i);
        String temp = temper.getUsername();
        return temp;
    }
    /**
     * Returns the password of the student at index location i.
     * @param i
     * @return
     */
    public String getPassword(int i) {
        return students.get(i).getPassword();
    }
    /**
     * Returns the first student in the list as a String.
     */
    public String toString() {
        return students.get(0).toString(); 
    }
    /**
     * Returns the string Student to give the type of object
     * @param username
     * @param password
     */
    public String getType(String username, String password) {
        return "Student";
    }
    /**
     * Returns the Student whos username matches the one provided.
     * @param username
     * @return
     */
    public Student getStudent(String username) {
        try {
            for (int i = 0; i < students.size(); i++) {
                if (students.get(i).toString().contains(username))
                    return students.get(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
