package seliniumproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestLibrarian {
    
    private boolean testLibrarianLogin(WebDriver driver) throws InterruptedException{
        driver.manage().window().maximize();
        driver.findElement(By.id("email2")).sendKeys("s@gmail.com");
        Thread.sleep(1000);
        driver.findElement(By.id("password2")).sendKeys("qwer");
        Thread.sleep(1000);
        driver.findElement(By.id("loginBtn2")).click();
        Thread.sleep(1000);
        String at = driver.getTitle();
        String exp = "Librarian Section";
        driver.close();
        if(at.equalsIgnoreCase(exp)){
            System.out.println("Test pass");
            return true;
        }
        System.out.println("Test fail");
        return false;
        
    }
    
    private void testAddBook() throws InterruptedException{
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/addBook");
        driver.manage().window().maximize();
        driver.findElement(By.id("callno1")).sendKeys("19876");
        Thread.sleep(1000);
        driver.findElement(By.id("name1")).sendKeys("vikas");
        Thread.sleep(1000);
        driver.findElement(By.id("author1")).sendKeys("rabindra");
        Thread.sleep(1000);
        driver.findElement(By.id("publisher1")).sendKeys("rk sharma");
        Thread.sleep(1000);
        driver.findElement(By.id("quantity1")).sendKeys("8");
        Thread.sleep(1000);
        driver.findElement(By.id("savebook")).click();
        Thread.sleep(1000);
        String getAns = driver.findElement(By.id("messages")).getText();
        String expAns = "Book added";
        String expAns2 = "Duplicate entry not allowed";
        driver.close();
        if(getAns.equalsIgnoreCase(expAns) || getAns.equalsIgnoreCase(expAns2)){
            System.out.println("Test pass");
            return;
        }
        System.out.println("Test fail");
    }
    
    private void testViewBook() throws InterruptedException{
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/viewBook");
        driver.manage().window().maximize();
        Thread.sleep(1000);
        String getAns = driver.findElement(By.id("getCount")).getText();
        int resultObt = Integer.parseInt(getAns);
        Thread.sleep(1000);
        String title = driver.getTitle();
        driver.close();
        if(title.equals("View Book") && resultObt>=0){
            System.out.println("Test pass");
        }
        else
            System.out.println("Test fail");
    }
    
    private void testIssueBook() throws InterruptedException{
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/issueBookform");
        driver.manage().window().maximize();
        driver.findElement(By.id("callno1")).sendKeys("19876");
        Thread.sleep(1000);
        driver.findElement(By.id("id1")).sendKeys("1235");
        Thread.sleep(1000);
        driver.findElement(By.id("name1")).sendKeys("rabindra");
        Thread.sleep(1000);
        driver.findElement(By.id("mobile1")).sendKeys("9004348447");
        Thread.sleep(1000);
        driver.findElement(By.id("issuebook")).click();
        Thread.sleep(1000);
        String getAns = driver.findElement(By.id("messages")).getText();
        String expAns = "Book issued";
        String expAns2 = "Previous book not returned";
        driver.close();
        if(getAns.equalsIgnoreCase(expAns) || getAns.equalsIgnoreCase(expAns2)){
            System.out.println("Test pass");
            return;
        }
        System.out.println("Test fail");
    }
    
    private void testReturnBook() throws InterruptedException{
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/returnBook");
        driver.manage().window().maximize();
        driver.findElement(By.id("callno1")).sendKeys("19876");
        Thread.sleep(1000);
        driver.findElement(By.id("studentid1")).sendKeys("1235");
        Thread.sleep(1000);
        driver.findElement(By.id("returnbook")).click();
        Thread.sleep(1000);
        String getAns = driver.findElement(By.id("messages")).getText();
        String expAns = "Book returned";
        String expAns2 = "Book already returned";
        driver.close();
        if(getAns.equalsIgnoreCase(expAns) || getAns.equalsIgnoreCase(expAns2)){
            System.out.println("Test pass");
            return;
        }
        System.out.println("Test fail");
    }
    
    public void testLibrarian() throws InterruptedException{
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080");
        if(testLibrarianLogin(driver)){
            testAddBook();
            testViewBook();
            testIssueBook();
            testReturnBook();
        }
        else{
            System.out.println("Login failed");
        }
    }
}
