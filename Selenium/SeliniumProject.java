package seliniumproject;

public class SeliniumProject {

    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        System.setProperty("webdriver.chrome.driver",
                "/home/shubham/Documents/drivers/chromedriver_linux64/chromedriver");
        TestAdmin admin = new TestAdmin();
        admin.testAdmin();
        
        /*TestLibrarian librarian = new TestLibrarian();
        librarian.testLibrarian();*/
        
    }
    
}
