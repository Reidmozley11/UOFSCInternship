/**
 * Driver calls the program from the UI 
 */
public class Driver {

    UserInterface userInterface; 
    public static void main(String[] args){
        Driver driver = new Driver();
        driver.run();
    }
    public void run(){
        UserInterface ui = new UserInterface();
        this.userInterface = ui; 
        ui.frontPage();
    }
    public Driver(){
    }
}
