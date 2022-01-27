import java.util.Scanner;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A userinteface for the internship applications console
 * 
 * @author Reid Mozley
 */
public class UserInterface {

    private StudentList studentlist;
    private UIFacade ui;
    Scanner keyboard = new Scanner(System.in);

    /**
     * Creates the facade for use
     * 
     * @author Reid Mozley
     */
    public UserInterface() {
        // user = User.getType;
        // if (
        ui = new UIFacade();
        frontPage();
    }

    /**
     * Displays the welcome message and takes in the users username and password
     * then calls logon passing in the username and password
     * 
     * @author Reid Mozley
     */
    public void frontPage() {
        System.out.println("**** Welcome to the UofSC internship Application ****");
        System.out.println("\n                  Login                           ");

        System.out.println("\nUsername: ");
        String user = keyboard.nextLine();
        System.out.println("\nPassword: ");
        String password = keyboard.nextLine();

        logon(user, password);
    }

    /**
     * Checks to see if the user exists inside of one of the three array's of users:
     * Admin, Business, and Student. If they are present logs in that user, if they
     * aren't it asks them if they want to create an account
     * 
     * @author Remedy team
     * @param username Passes in the username the user entered in the front page
     * @param password Passes in the password the user entered in the front page
     */
    public void logon(String username, String password) {
        String answer;
        if (ui.checkUser(username, password)) {
            String temp = ui.checkID(username, password);
            if (temp.equals("Admin")) {
                Admin admin = ui.checkObjectAdmin(username, password);
                adminOn(admin);
            } else if (temp.equals("Student")) {
                Student student = ui.checkObjectStudent(username, password);
                studentOn(student);
            } else if (temp.equals("Business")) {
                Business business = ui.checkObjectBusiness(username, password);
                businessOn(business);
            }
        } else {
            System.out.println(
                    "\nWe noticed you don't have an account with us would you like to create one? [yes] or [no]");
            answer = keyboard.nextLine();
            if (answer.equalsIgnoreCase("yes")) {
                createAccount();
                frontPage();
            } else {
                frontPage();
            }
        }
    }

    /**
     * Creates an account for a user. The user specifies if they want a Student,
     * Business, or Admin account Then it takes in their username password and email
     * and finally creates them a unique uuid.
     * 
     * @author Reid Mozley
     */
    public void createAccount() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        boolean looper = true;

        System.out.println("\n**** Welcome to Account Creation ****");

        System.out.println("What type of account would you like: student, business, admin?");
        String userType = keyboard.nextLine();

        if (userType.equalsIgnoreCase("student")) {
            System.out.println("\n**** Student Account ****");
            System.out.println("\nWhat would you like your username to be? ");
            String realUser = keyboard.nextLine();
            System.out.println("\nWhat would you like your password to be? ");
            String realPassword = keyboard.nextLine();
            looper = true;
            String realEmail = "";
            while (looper != false) {
                System.out.println("\nWhat would you like your email to be? ");
                realEmail = keyboard.nextLine();
                if (checkEmail(realEmail)) {
                    looper = false;
                } else {
                    System.out.println("\nThe email [" + realEmail + "] is not a real email");
                    System.out.println("\nTry again");
                }
            }
            System.out.println("\nWhat would you like your name to be? ");
            String name = keyboard.nextLine();
            System.out.println("\nWhat is you phoneNumber? ");
            String phoneNumber = keyboard.nextLine();
            UUID uuid = UUID.randomUUID();
            ui.createStudent(realUser, realPassword, uuid, realEmail, name, phoneNumber);
            return;
        } else if (userType.equalsIgnoreCase("business")) {
            looper = true;
            System.out.println("\n**** Business Account ****");
            System.out.println("\nWhat would you like your username to be? ");
            String realUser = keyboard.nextLine();
            System.out.println("\nWhat would you like your password to be? ");
            String realPassword = keyboard.nextLine();
            looper = true;
            String realEmail = "";
            while (looper != false) {
                System.out.println("\nWhat would you like your email to be? ");
                realEmail = keyboard.nextLine();
                if (checkEmail(realEmail)) {
                    looper = false;
                } else {
                    System.out.println("\nThe email [" + realEmail + "] is not a real email");
                    System.out.println("\nTry again");
                }
            }
            looper = true;
            String ein = "";
            while (looper != false) {
                System.out.println("\nWhat is your EIN");
                ein = keyboard.nextLine();
                if (checkEIN(ein)) {
                    looper = false;
                } else {
                    System.out.println("\nThe EIN [" + ein + "] is not a real EIN");
                    System.out.println("\nTry again");
                }
            }
            UUID uuids = UUID.randomUUID();
            System.out.println("\nWhat would you like your name to be? ");
            String name = keyboard.nextLine();
            ui.createBusiness(realUser, realPassword, uuids, realEmail, ein, name);
        } else if (userType.equalsIgnoreCase("admin")) {
            looper = true;
            System.out.println("\n**** Admin Account ****");
            System.out.println("\nWhat would you like your username to be? ");
            String realUser = keyboard.nextLine();
            System.out.println("\nWhat would you like your password to be? ");
            String realPassword = keyboard.nextLine();
            looper = true;
            String realEmail = "";
            while (looper != false) {
                System.out.println("\nWhat would you like your email to be? ");
                realEmail = keyboard.nextLine();
                if (checkEmail(realEmail)) {
                    looper = false;
                } else {
                    System.out.println("\nThe email [" + realEmail + "] is not a real email");
                    System.out.println("\nTry again");
                }
            }
            UUID uuid = UUID.randomUUID();
            System.out.println("\nWhat would you like your name to be? ");
            String name = keyboard.nextLine();
            ui.createAdmin(realUser, realPassword, uuid, realEmail, name);
        } else {
            System.out.println("The entered type is incorrect");
        }
    }

    /**
     * A method that checks to see if an email is of correct type
     * String@String.string
     * 
     * Reference https://mailtrap.io/blog/java-email-validation/
     * 
     * @author Reid Mozley
     * @param email The email the user inputted which is being validated
     * @return Returns true if the email is real and false if the user misinputted
     *         an email
     */
    public boolean checkEmail(String email) {
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(email);

        return (matcher.matches() ? true : false);
    }

    /**
     * A method that checks to see if an ein is of correct type of 9 digits
     * 
     * @author Reid Mozley
     * @param ein The ein number that the business inputted to be validated
     * @return Returns true if the ein is 9 digits and false if it is more or less
     *         than 9
     */
    public boolean checkEIN(String ein) {
        if (ein.length() < 9 || ein.length() > 9) {
            return false;
        }
        return true;
    }

    /**
     * A method that logs a student onto the system. The method shows them the
     * student front panel which contains all of the avaliable student functions.
     * 
     * @author Reid Mozley
     * @param student The student that is currently logged on
     */
    public void studentOn(Student student) {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        while (true) {
            System.out.println("**** Welcome " + student.getName() + " ****");
            System.out.println(
                    "\n1) Create a resume?\n2) Print your resume\n3) Look at job listing's \n4) Write a review\n5) Exit");
            System.out.println("\nPlease enter the number of the function you would like to access");
            int selection = keyboard.nextInt();
            keyboard.nextLine();
            if (selection == 1) {
                resumeCreator(student);
            } else if (selection == 2) {
                System.out.println("What would you like your resume to be called?");
                String input = keyboard.nextLine();
                String name = input;
                DataWriter.createResumeFile(name, student);
            } else if (selection == 3) {
                System.out.println("What skill would you like to search for in jobs? Press enter to view all jobs");
                String inputtedskill = keyboard.nextLine();
                viewListings(student, inputtedskill);
            } else if (selection == 4) {
                //reviewWrite();
                System.out.println("Action not exisiting yet");
            } else if (selection == 5) {
                System.out.println("Goodbye");
                DataWriter.saveStudent();
                DataWriter.saveJobListing();
                DataWriter.saveReview();
                System.exit(0);
            } else {
                System.out.println("You selected a function that does not exist [" + selection
                        + "] <-- please select a valid range");
                studentOn(student);
            }
        }
    }

    /**
     * A virtual resume contains skills, location, previous work expierence, and
     * education.
     * 
     * @author Reid Mozley
     * @param student The student creating a resume
     */
    public void resumeCreator(Student student) {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("**** Welcome to the Resume Creation center " + student.getName() + " ****");
        System.out.println("\nTo start you off with a great resume input some of your skills!");
        System.out.println("\n(Pro tip: Enter your skills one at a time. Typing [done] will quit the skills section)");
        String skills = "";
        String input;
        boolean looping = true;
        while (looping != false) {
            input = keyboard.nextLine();
            if (input.equalsIgnoreCase("done")) {
                looping = false;
            } else {
                skills += input + ", ";
            }
        }
        student.setSkills(skills);

        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("The next step in your resume process is where you are from!");
        System.out.println("\nPlease input your City");
        String city = keyboard.nextLine();
        System.out.println("\nPlease input your State");
        String state = keyboard.nextLine();
        System.out.println("\nPlease input your ZipCode");
        String zipCode = keyboard.nextLine();
        String userLocation = city + ", " + state + ", " + zipCode;
        student.setLocation(userLocation);

        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("For this piece of your resume you'll need to input your past work experience");
        System.out.println(
                "\n(Pro tip: Enter your work experience one at a time. Typing [done] will quit the work experience section)");
        String previousWork = "";
        String input3;
        boolean looper = true;
        while (looper != false) {
            input3 = "\t"+keyboard.nextLine();
            if (input3.equalsIgnoreCase("\tdone")) {
                looper = false;
            } else {
                System.out.println("\nWhat company did you work for: ");
                String company = "\n\t\t"+keyboard.nextLine(); 
                System.out.println("\nWhat type of position did you have? (i.e. Internship, Full-time, Part-time): ");
                String position = "\n\t\t"+keyboard.nextLine(); 
                System.out.println("\nHow long did you work there? (Format like: May 2019 - Aug 2019/present): ");
                String time = "\n\t\t"+keyboard.nextLine(); 
                boolean looper2 = true; 
                System.out.println("\nInput responsibility (Pro tip: Enter done once you have finished): ");
                String responsiblity = ""; 
                while (looper2 != false) {
                    String input4 = "\n\t\t"+keyboard.nextLine(); 
                    if (input4.equalsIgnoreCase("\n\t\tdone")) {
                        looper2 = false; 
                    } else { 
                        responsiblity += input4; 
                    }
                }
                previousWork += input3 + company + position + time + responsiblity + "\n";
                student.setPreviousWork(previousWork);
            }
        }

        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Now for the last part of your resume you'll need to input your education(s)");
        System.out.println(
                "\n(Pro tip: Enter your educations one at a time. Typing [done] will quit the education section)");

        String education = "";
        String input2;
        boolean go = true;
        while (go != false) {
            input2 = "\t"+keyboard.nextLine();
            if (input2.equalsIgnoreCase("\tdone")) {
                go = false;
            } else {
                education += input2 + "n\t";
            }
        }
        student.setEducation(education);
        System.out.println("Would you like to print your resume?");
        input = keyboard.nextLine();
        if (input.equals("yes")) {
            System.out.println("What would you like it to be called?");
            input = keyboard.nextLine();
            DataWriter.createResumeFile(input, student);
        }
        System.out.println("Thank you for creating a resume!");
    }

    /**
     * This is taking in the users searched skills and returning the matching jobs
     * 
     * @param skills this is the users inputted search behavior
     */
    public void viewListings(Student student, String skills) {
        System.out.println("\nHere are all of the open job listings currently avalible on the app");
        System.out.println(ui.searchJobss(skills));
        System.out.println("What job would you like to apply to?");
        String jobapply = keyboard.nextLine();
        ui.apply(student, jobapply);
        System.out.println("Applied");
    }

    /**
     * A method that logs the admin in and shows them the admin front panel with all
     * of their avaliable admin functions.
     * 
     * @author Reid Mozley
     * @param admin The admin that is currently logged in
     */
    public void adminOn(Admin admin) {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("**** Welcome " + admin.getName() + " ****");
        System.out.println("\n1) Edit a student profile\n2) Exit");
        System.out.println("\nPlease enter the number of the function you would like to access");
        int selection = keyboard.nextInt();
        keyboard.nextLine();
        while (true) {
            if (selection == 1) {
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("**** Student Editor ****");
                System.out.println("\nPlease enter the username of the student you would like to edit");
                String username = keyboard.nextLine();
                if (ui.grabStudent(username) == null) {
                    System.out.println("This student was not found please try again");
                } else {
                    editStudent(admin, ui.grabStudent(username));
                }
 
            } else if (selection == 2) {
                System.out.println("Goodbye");
                DataWriter.saveStudent();
                DataWriter.saveJobListing();
                DataWriter.saveReview();
                DataWriter.saveBusiness();
                System.exit(0);
            } else
                System.out.println("You selected a function that does not exist [" + selection
                        + "] <-- please select a valid range");
            }
        }


    /**
     * Edits a student class
     * 
     * @author Reid Mozley
     * @param admin
     * @param student
     */
    public void editStudent(Admin admin, Student student) {
        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println(
                "\n" + admin.getUsername() + " what would you like to edit about " + student.getName() + "'s account?");
        System.out.println(
                "\n1) Their actual name?\n2) Their username\n3) Their password?\n4) Their email?\n5) Something resume related\n6) Return to previous page");
        System.out.println("\nPlease enter the number of the function you would like to access");
        int selection = keyboard.nextInt();
        keyboard.nextLine();

        if (selection == 1) {
            System.out.println("\nWhat would you like to change" + student.getName() + "'s name to");
            System.out.println("\nPlease input the new name now: ");
            student.setName(keyboard.nextLine());
            System.out.println("\nDisplaying new Student name: ");
            System.out.println(student.getName());
        } else if (selection == 2) {
            System.out.println("\nWhat would you like to change" + student.getUsername() + " to");
            System.out.println("\nPlease input the new username now: ");
            student.setUsername(keyboard.nextLine());
            System.out.println("\nDisplaying " + student.getName() + "'s new username: ");
            System.out.println(student.getUsername());
        } else if (selection == 3) {
            System.out.println("\nWhat would you like to change" + student.getPassword() + " to");
            System.out.println("\nPlease input the new password now: ");
            student.setPassword(keyboard.nextLine());
            System.out.println("\nDisplaying " + student.getName() + "'s new password: ");
            System.out.println(student.getPassword());
        } else if (selection == 4) {
            System.out.println("\nWhat would you like to change" + student.getEmail() + " to");
            System.out.println("\nPlease input the email now: ");
            student.setEmail(keyboard.nextLine());
            System.out.println("\nDisplaying " + student.getName() + "'s new email: ");
            System.out.println(student.getEmail());
        } else if (selection == 5) {
            editStudentResume(admin, student);
        } else if (selection == 6) {
            adminOn(admin);
        } else {
            System.out.println(
                    "You selected a function that does not exist [" + selection + "] <-- please select a valid range");
            editStudent(admin, student);
        }
        editStudent(admin, student);
    }

    /**
     * A method to allow an admin to edit a student resume
     * 
     * @author Reid Mozley
     * @param admin   The admin accessing the student resume
     * @param student The student the admin is currently editing
     */
    public void editStudentResume(Admin admin, Student student) {
        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("\n**** Now editing " + student.getName() + "'s Resume! ****");
        System.out.println("\nWhat about this resume would you like changed");
        System.out.println("\n1) Skills\n2) Education\n3) Previous Work\n4) Location\n5) Email\n6) To go back a page");

        System.out.println("\nPlease enter the number of the function you would like to access");
        int selection = keyboard.nextInt();
        keyboard.nextLine();

        if (selection == 1) {
            System.out.print("\033[H\033[2J");
            System.out.flush();

            System.out.println("\nHere are the current skills for " + student.getName());
            System.out.println(student.getSkills());
            System.out.println("\nReinput the skills you would like here");
            System.out.println("Pro tip: Enter the skills one at a time and type [done] to quit inputting skills");
            String newSkills = "";
            boolean looping = true;

            while (looping != false) {
                String input = keyboard.nextLine();

                if (input.equalsIgnoreCase("done")) {
                    looping = false;
                } else {
                    newSkills += input + ", ";
                }
            }

            student.setSkills(newSkills);
            System.out.println("\nHere are the students new skills you entered: ");
            System.out.println(student.getSkills());
            editStudentResume(admin, student);
        } else if (selection == 2) {
            System.out.print("\033[H\033[2J");
            System.out.flush();

            System.out.println("\nHere are the current inputted educations for " + student.getName());
            System.out.println(student.getEducation());
            System.out.println("\nPlease reinput the educations you would like");
            System.out.println(
                    "\nPro tip: Enter the educations one at a time and type [done] to quit inputting education");
            String newEducation = "";
            boolean looping = true;

            while (looping != false) {
                String input = keyboard.nextLine();

                if (input.equalsIgnoreCase("done")) {
                    looping = false;
                } else {
                    newEducation += input + ", ";
                }
            }
            student.setEducation(newEducation);

            System.out.println("\nHere are the students new educations you entered: ");
            System.out.println(student.getEducation());
            editStudentResume(admin, student);
        } else if (selection == 3) {
            System.out.print("\033[H\033[2J");
            System.out.flush();

            System.out.println("\nHere are the current inputted previous work for " + student.getName());
            System.out.println(student.getPreviousWork());
            System.out.println("\nPlease reinput the previous work you would like");
            System.out.println(
                    "\nPro tip: Enter the previous work one at a time and type [done] to quit inputting previous work");
            String newPreviousWork = "";
            boolean looping = true;

            while (looping != false) {
                String input = keyboard.nextLine();

                if (input.equalsIgnoreCase("done")) {
                    looping = false;
                } else {
                    newPreviousWork += input + ", ";
                }
            }
            student.setEducation(newPreviousWork);

            System.out.println("\nHere are the students new previous work you entered: ");
            System.out.println(student.getPreviousWork());
            editStudentResume(admin, student);
        } else if (selection == 4) {
            System.out.print("\033[H\033[2J");
            System.out.flush();

            System.out.println("\nHere is the current location of " + student.getName());
            System.out.println(student.getLocation());
            System.out.println("\nPlease reinput the location you wish to have");
            System.out.println("\nTo start input your City");
            String city = keyboard.nextLine();
            System.out.println("\nNow input your State");
            String state = keyboard.nextLine();
            System.out.println("\nFinally input your ZipCode");
            String zipCode = keyboard.nextLine();
            String userLocation = city + ", " + state + ", " + zipCode;
            student.setLocation(userLocation);
            editStudentResume(admin, student);
        } else if (selection == 5) {
            System.out.print("\033[H\033[2J");
            System.out.flush();

            System.out.println("\nHere is the current email address for " + student.getName());
            System.out.println(student.getEmail());
            System.out.println("\nPlease reinput an email: ");

            String newEmail = keyboard.nextLine();

            student.setEmail(newEmail);
            editStudentResume(admin, student);
        } else if (selection == 6) {
            editStudent(admin, student);
        } else {
            System.out.print("\033[H\033[2J");
            System.out.flush();

            System.out.println("You input a function that does not exist please try again");
            editStudentResume(admin, student);
        }
    }

    /**
     * A method that logs a business onto the system. It shows the business the
     * front panel with all the business functionalities.
     * 
     * @author Reid Mozley
     * @param business The business currently logged in
     */
    public void businessOn(Business business) {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("**** Welcome " + business.getName() + " ****");
        while (true) {
            System.out.println(
                    "\n1) Create a Job Listing\n2) Views applications \n3) Write a review\n4) View your Job Listings\n5) Exit");
            System.out.println("\nPlease enter the number of the function you would like to access");
            int selection = keyboard.nextInt();
            keyboard.nextLine();
            if (selection == 1) {
                createJobListing(business); // makes a new job
            } else if (selection == 2) {
                viewApplicants(business); // views the job's with current applications
            } else if (selection == 3) {
                // writeReview();
            } else if (selection == 4) {
                viewMyJobs(business);
            } else if (selection == 5) {
                System.out.println("Goodbye");
                DataWriter.saveBusiness();
                DataWriter.saveJobListing();
                System.exit(0);
            } else{
                System.out.println("You selected a function that does not exist [" + selection
                        + "] <-- please select a valid range");
            }
        }
    }

    /**
     * A job posting UI If this method is selected it runs through and creates a job
     * listing for the business in question
     * 
     * @author Reid Mozley
     * @param business The business posting the job
     */
    public void createJobListing(Business business) {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("**** Job Posting! ****");
        System.out.println("First things first what is the title of the position you want?");
        String title = keyboard.nextLine();

        System.out.println("To start creating " + title + " lets input the skills you are looking for: ");
        System.out.println(
                "\n(Pro tip: Enter the skills you want one at a time. Typing [done] will quit the skills section)");
        String skills = "";
        String input;
        boolean looping = true;
        while (looping != false) {
            input = keyboard.nextLine();
            if (input.equalsIgnoreCase("done")) {
                looping = false;
            } else {
                skills += input + ", ";
            }
        }

        System.out.println("\nNow let's enter in your description of [" + title + "]");
        System.out.println("\nPro tip: Hit enter and type done to end your description");
        looping = true;
        String descript = "";
        while (looping != false) {
            input = "";
            input = keyboard.nextLine();
            if (input.equalsIgnoreCase("done")) {
                looping = false;
            } else {
                descript += input;
            }
        }

        System.out.println("\nNext step is to declare your sponser!");
        System.out.println("\nPro tip: If you do not have a sponser just type [skip]");
        input = "";
        input = keyboard.nextLine();
        String sponser;
        if (input.equalsIgnoreCase("skip")) {
            sponser = title + " has no sponsers";
        } else {
            sponser = input;
        }

        System.out.println("\nIf [" + title + "] is a remote position please input [yes] otherwise input [no]");
        String remote = "";
        looping = true;
        while (looping != false) {
            remote = keyboard.nextLine();
            if (remote.equalsIgnoreCase("yes")) {
                looping = false;
            } else if (remote.equalsIgnoreCase("no")) {
                looping = false;
            } else {
                System.out.println(
                        "\nIt seems you have inputted an in correct command, please remember to input [yes] for a remote job and [no] for a non remote job");
            }
        }

        System.out.println("\nNow please input the email you would like to be viewed by students");
        String email = keyboard.nextLine();

        System.out.println("\nFinally please input the phone number that you would like to be viewed by students");
        String phone = keyboard.nextLine();

        business.postJob(business.getUUID(), title, skills, descript, sponser, remote, email, phone);
    }
/**
 * This allows the business to view the jobs that have applicants who have applied to them
 * @param business this is the business that has been passed through 
 */
    public void viewApplicants(Business business) {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("**** Here are your jobs that have recieved applications ****");
        System.out.println(business.myAppliedJobs());
    }
/**
 * This allows the business to be able to view the joblisting they have created
 * @param business is the specific business that is passed through
 */
    public void viewMyJobs(Business business) {
        System.out.println("\nHere are your current job listings: ");
        System.out.println(business.getListings());
    }
}
