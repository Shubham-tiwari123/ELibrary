package seliniumproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestAdmin {
    
    private boolean testAdminLogin(WebDriver driver) throws InterruptedException{
        driver.manage().window().maximize();
        driver.findElement(By.id("email1")).sendKeys("st@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.id("password1")).sendKeys("shubham1");
        Thread.sleep(2000);
        driver.findElement(By.id("loginBtn")).click();
        Thread.sleep(2000);
        String at = driver.getTitle();
        String exp = "Admin Section";
        driver.close();
        if(at.equalsIgnoreCase(exp)){
            System.out.println("Test pass");
            return true;
        }
        System.out.println("Test fail");
        return false;
        
    }
    
    private void testAddLibrarian() throws InterruptedException{
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/addLibrarian");
        driver.manage().window().maximize();
        driver.findElement(By.id("name1")).sendKeys("vikram");
        Thread.sleep(1000);
        driver.findElement(By.id("email1")).sendKeys("v@gmail.com");
        Thread.sleep(1000);
        driver.findElement(By.id("password1")).sendKeys("abcd");
        Thread.sleep(1000);
        driver.findElement(By.id("mobile1")).sendKeys("9004513557");
        Thread.sleep(1000);
        driver.findElement(By.id("addlibrarian")).click();
        Thread.sleep(1000);
        String getAns = driver.findElement(By.id("messages")).getText();
        String expAns = "Data saved";
        String expAns2 = "Duplicate entry tried";
        driver.close();
        if(getAns.equalsIgnoreCase(expAns) || getAns.equalsIgnoreCase(expAns2)){
            System.out.println("Test pass");
        }
        else
            System.out.println("Test fail");
    }
    
    private void testViewLibrarian() throws InterruptedException{
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/viewLibrarian");
        driver.manage().window().maximize();
        Thread.sleep(1000);
        String getAns = driver.findElement(By.id("getCount")).getText();
        int resultObt = Integer.parseInt(getAns);
        Thread.sleep(1000);
        String title = driver.getTitle();
        driver.close();
        if(title.equals("View Librarian") && resultObt>0){
            System.out.println("Test pass");
        }
        else
            System.out.println("Test fail");
    }
    
    public  void testAdmin() throws InterruptedException{
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080");
        if(testAdminLogin(driver)){
            //testAddLibrarian();
            //testViewLibrarian();
        }
        else{
            System.out.println("Login failed");
        }
    }
}
