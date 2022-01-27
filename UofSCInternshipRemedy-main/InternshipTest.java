import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.UUID;

import javax.print.attribute.standard.JobSheets;

import org.junit.Test;
public class InternshipTest{

    // =====================================================
    // Section written by Aaron Thompson
    @Test
    public void TestStudentToStringEqual(){
        String comparing = "Name: Aaron" + "\nEmail: Aaront233@gmail.com" + "\nSkills: Java, " + "\nEducation: High School Diploma\n\tUSC Columbia\n\t";
        Logon logon = new Logon();
        Student testing = logon.studentGrabber("Aaront233");
        assertEquals(comparing, testing.toString());
    }
    @Test
    public void TestStudentToStringNotEqual(){
        String comparing = "Name: Aaron" + "\nEmail: Aaront233@gmail.com" + "\nSkills: Java, " + "\nEducation: High School Diploma\n\tUSC Columbia\n\t";
        Logon logon = new Logon();
        Student testing = logon.studentGrabber("John");
        assertNotSame("not equal", comparing,testing.toString());
    }
    @Test
    public void CheckStudentType(){
        Logon logon = new Logon();
        String testing = logon.checkType("John", "geKi12");
        assertEquals("Student", testing);
    }
    @Test
    public void checkBusinessType(){
        Logon logon = new Logon();
        String testing = logon.checkType("Addam","adado45");
        assertEquals("Business", testing);
    }
    @Test
    public void checkAdminType(){
        Logon logon = new Logon();
        String testing = logon.checkType("JohnLight","lightyjohn_");
        assertEquals("Admin", testing);
    }
    @Test
    public void checkNullType(){
        Logon logon = new Logon();
        String testing = logon.checkType("JohnLight",null);
        assertEquals(null, testing);
    }
    @Test
    public void getIDTestStudent(){
        Logon logon = new Logon();
        String testing = logon.getID("Aaront233", "Aaron").toString();
        assertEquals("4c81be1c-c13a-4dc0-bdd7-90de74230a32",testing);
    }
    @Test
    public void getIDTestBusiness(){
        Logon logon = new Logon();
        String testing = logon.getID("Ally", "WallAllyace").toString();
        assertEquals("a7f7def8-c9f1-4fa2-9245-6faa2d2788cb",testing);
    }
    @Test
    public void getIDTestAdmin(){
        Logon logon = new Logon();
        String testing = logon.getID("JohnLight", "lightyjohn_").toString();
        assertEquals("512fb9ae-651d-447f-92aa-6d0d361a1d4d",testing);
    }
    @Test
    public void getIDTestNull(){
        Logon logon = new Logon();
        String testing = logon.getID(null, null).toString();
        assertNotSame("4c81be1c-c13a-4dc0-bdd7-90de74230a32",testing);
    }
    @Test
    public void createStudentAccountTest(){
        Logon logon = new Logon();
        Student expect = new Student(UUID.fromString("4c81be1c-c13a-4dc0-bdd7-90de74230a32"), "Aaron","Aaron", "Aaront233@gmail.com", "Java, ", "High School Diploma\n\tUSC Columbia\n\t", "Computer Repair\t", "Sumter, SC, 29154", "", "Aaront233","");
        Student actual = logon.studentGrabber("Aaront233");
        assertEquals(expect,actual);
    }
    @Test
    public void createAdminAccountTest(){
        AdminList temp = AdminList.getInstance();
        Admin admin = new Admin(UUID.randomUUID(),"Testing","Actual", "Admin@Admin.Admin", "Tester");
        AdminList.addAdmin(admin);
        temp.addAdmin(admin);
        assertEquals(AdminList.getInstance(), temp);
    }
    @Test
    public void createBusinessAccountTest(){
        BusinessList temp = BusinessList.getInstance();
        Business expect = new Business(UUID.fromString("a7f7def8-c9f1-4fa2-9245-6faa2d2788cb"), "Ally Wallace","WallAllyace", "Front End Developer", "12-1234567", "Ally");
        Business actual = temp.getBusiness("Ally");
        assertEquals(expect,actual);
    }
    // Tests both Admin and Admin List
    @Test
    public void addAdminTest(){
        AdminList temp = AdminList.getInstance();
        Admin admin = new Admin(UUID.randomUUID(),"Testing","Actual", "Admin@Admin.Admin", "Tester");
        AdminList.addAdmin(admin);
        temp.addAdmin(admin);
        assertEquals(AdminList.getInstance(), temp);
    }
    @Test
    public void getAdminTest(){
        AdminList admins = AdminList.getInstance();
        ArrayList<Admin> temper = AdminList.getAdminsList();
        Admin admin = temper.get(1);
        assertEquals(admin, admins.getAdmin("LolaRose"));
    }
    @Test
    public void deleteJobTest(){
        JobListingList temp = JobListingList.getInstance();
        BusinessList temper = BusinessList.getInstance();
        AdminList tempered = AdminList.getInstance();
        ArrayList<Admin> admins= tempered.getAdminsList();
        Admin admin = admins.get(1);
        Business bus = temper.getBusinesses().get(1);
        admin.deleteJob(temp, bus.getUUID().toString(), "Front End Developer");
        assertEquals(temp, JobListingList.getInstance());
    }
    @Test
    public void deleteStudentTest(){
        StudentList temp = StudentList.getInstance();
        AdminList tempered = AdminList.getInstance();
        ArrayList<Admin> admins= tempered.getAdminsList();
        Admin admin = admins.get(1);
        Student bus = temp.getStudents().get(1);
        admin.deleteStudent(temp, bus.getUUID().toString());
        assertNotEquals(temp, StudentList.getStudents());
    }
    @Test
    public void deleteBusinessTest(){
        BusinessList temper = BusinessList.getInstance();
        AdminList tempered = AdminList.getInstance();
        ArrayList<Admin> admins= tempered.getAdminsList();
        Admin admin = admins.get(1);
        Business bus = temper.getBusinesses().get(1);
        admin.deleteBusiness(temper, bus.getUUID().toString());
        assertNotEquals(temper, BusinessList.getBusinesses());
    }
    @Test
    public void getAdminIDTest(){
        AdminList temp = AdminList.getInstance();
        Admin admin = temp.getAdminID(1);
        assertEquals(admin, AdminList.getAdminsList().get(1));
    }
    @Test
    public void postJobTest(){
        JobListingList temp = JobListingList.getInstance();
        BusinessList temper = BusinessList.getInstance();
        Business bus = temper.getBusinesses().get(1);
        bus.postJob(bus.getUUID(), "Test", "Front End Developer", "Develop Front End","","","", "1-999-999-9999");
        assertEquals(temp, JobListingList.getInstance());
    }
    @Test
    public void myAppliedJobsTest(){
        JobListingList temp = JobListingList.getInstance();
        BusinessList temper = BusinessList.getInstance();
        Business bus = temper.getBusinesses().get(1);
        ArrayList<JobListing> expected = bus.myAppliedJobs();
        assertNotEquals(expected, temp.getJobListings());
    }
    @Test
    public void addBusinessTest(){
        BusinessList temp = BusinessList.getInstance();
        Business bus = new Business(UUID.randomUUID(),"Testing","Actual", "Admin@Admin.Admin", "Tester", "999");
        BusinessList.addBusiness(bus);
        temp.addBusiness(bus);
        assertEquals(BusinessList.getInstance(), temp);
    }
    @Test
    public void getBusinessTest(){
        BusinessList admins =  BusinessList.getInstance();
        ArrayList<Business> temper =  BusinessList.getBusinesses();
        Business admin = temper.get(1);
        assertEquals(admin, admins.getBusiness("Ally"));
    }
    @Test
    public void getBusinessIDTest(){
        BusinessList businesses =  BusinessList.getInstance();
        Business admin = businesses.getBusinessID(1);
        assertEquals(admin, businesses.getBusiness("Ally"));
    }
    @Test
    public void businessDeleteBusinessTest(){
        BusinessList temper = BusinessList.getInstance();
        Business bus = temper.getBusinesses().get(1);
        temper.deleteBusiness(bus.getUUID().toString());
        assertNotEquals(temper, BusinessList.getBusinesses());
    }
    // End Section Written by Aaron Thompson
    // =====================================================
    // Madison Yam
    @Test
    public void addStudentTest(){
        StudentList temp = StudentList.getInstance();
        Student stud = new Student(UUID.randomUUID(),"Testing","Actual", "Student@Student.Student", "Tester", "Skills", "Education", "PrevWork", "Location", "Applic","Username");
        StudentList.addStudent(stud);
        temp.addStudent(stud);
        assertEquals(StudentList.getInstance(), temp);
    }
    @Test
    public void deleteStudentListTest(){
        StudentList temp = StudentList.getInstance();
        Student stud = temp.getStudents().get(1);
        temp.deleteStudent(stud.getUUID().toString());
        assertNotEquals(temp, StudentList.getStudents());
    }
    @Test
    public void getStudent(){
        StudentList students =  StudentList.getInstance();
        ArrayList<Student> temp =  StudentList.getStudents();
        Student student = temp.get(1);
        assertEquals(student, students.getStudent("Chloe"));
    }
    @Test
    public void getInstanceStudentList(){
        assertTrue(StudentList.getInstance() != null);
    }
    @Test
    public void getInstanceBusinessList(){
        assertTrue(BusinessList.getInstance() != null);
    }
    @Test
    public void getInstanceAdminList(){
        assertTrue(AdminList.getInstance() != null);
    }
    @Test
    public void getInstanceJobListingList(){
        assertTrue(JobListingList.getInstance() != null);
    }
    @Test
    public void getInstanceReviewList(){
        assertTrue(ReviewList.getInstance() != null);
    }
    @Test
    public void addReview(){
        ReviewList reviewList = ReviewList.getInstance();
        ReviewList temp = ReviewList.getInstance();
        Review rev = new Review("BusinessID","StudentID", "Review", "5");
        reviewList.addReview(rev);
        temp.addReview(rev);
        assertEquals(ReviewList.getInstance(), temp);
    }
    @Test
    public void deleteReview(){
        ReviewList reviewList = ReviewList.getInstance();
        ReviewList temp = ReviewList.getInstance();
        temp.deleteReview("BusID", "StudID");
        assertNotEquals(temp, reviewList.getReviews());
    }
    // Reid Mozley
    
    @Test 
    public void checkApplicants() {
        JobListing jobListing = new JobListing(null, null, null, null, null, null, null, null, null); 
        Student student = new Student(null, null, null, null, null, null, null, null, null, null, null); 
        jobListing.applied(student);
        
        assertEquals(true, jobListing.isApplied());
    }

    @Test
    public void checkIfNoApplicants() {
        JobListing jobListing = new JobListing(null, null, null, null, null, null, null, null, null); 
        
        assertEquals(false, jobListing.isApplied());
    }

    @Test
    public void deleteJob() { 
        JobListingList temper = JobListingList.getInstance();
        JobListing job = temper.getJobListings().get(1);
        temper.deleteJob(job.getBusinessID().toString(), job.getTitle());
        assertNotEquals(temper, temper.getJobListings());
    }

    @Test
    public void searchJobsSkills() {
        JobListingList temp = JobListingList.getInstance();
        JobListing job = temp.getJobListings().get(1); 
    
        assertNotEquals(temp, temp.searchJobs(job.getSkills()));
    }

    @Test
    public void applyToJob() {
        JobListingList temp = JobListingList.getInstance();
        Student student = new Student(null, null, null, null, null, null, null, null, null, null, null);
        JobListing job = temp.getJobListings().get(1); 
        temp.applyJob(student, job.getTitle());
        job.isApplied(); 
        boolean works;
        if (job.isApplied()) {
            works = true; 
        } else {
            works = false; 
        }

        assertEquals(true, works);
    }


    //Dreyson Clark DataWriter.java
    @Test
    public void saveStudent(){
    Student student = new Student(UUID.fromString("90c84406-0898-4759-b519-ee61f42a68cd")
, "Intellectual Aardvark", "IA555", "ia5@gmail.com", "Python", "None", "Best Buy", "Columbia", "none", "Intellect", "803-555-7891");
    StudentList temp = StudentList.getInstance();
    StudentList.addStudent(student);
    DataWriter.saveStudent();
    StudentList temp2 = StudentList.getInstance();
    assertEquals(temp, temp2);

    //call student done
    //call add student done
    //call save student 
    //compare new studentlist to old student
    //assertsnotequals
        
    }
    @Test
    public void saveBuisness(){
    Business business = new Business(UUID.fromString("6f732682-7eb5-4b2d-841b-0016afd745da"), null, null, null, null, null); 
    BusinessList temp = BusinessList.getInstance();
    BusinessList.addBusiness(business);
    DataWriter.saveBusiness();
    BusinessList temp2 = BusinessList.getInstance();
    assertEquals(temp, temp2); 
    }
   
    @Test    
    public void saveReview(){
    Review review = new Review("BusinessID","StudentID", 
            "Wonderful", "5"); 
    ReviewList temp = ReviewList.getInstance();
    ReviewList.addReview(review);
    DataWriter.saveReview();
    ReviewList temp2 = ReviewList.getInstance();
    assertEquals(temp, temp2); 
    }
    
    @Test 
    public void saveJobListing(){
    JobListing joblisting = new JobListing(UUID.fromString("a7f7def8-c9f1-4fa2-9245-6faa2d2788cb"), null, null, null, null, null, null, null, null);
    JobListingList temp = JobListingList.getInstance();
    JobListingList.addJobListing(joblisting);
    DataWriter.saveJobListing();
    JobListingList temp2 = JobListingList.getInstance();
    assertEquals(temp, temp2); 
    }
}