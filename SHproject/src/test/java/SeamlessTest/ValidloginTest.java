package SeamlessTest;

import org.apache.hc.core5.http.Message;
import org.asynchttpclient.util.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ValidloginTest { 
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/");     //open web page
		//1. Click “Form Authentication” 

		driver.findElement(By.linkText("Form Authentication")).click();

		
		//2. Enter tomsmith for the username and SuperSecretPassword! for the password 
		
        // Get the WebElement corresponding to the username (TextField)		
        WebElement username = driver.findElement(By.id("username"));							

        // Get the WebElement corresponding to the Password Field		
        WebElement password = driver.findElement(By.name("password"));	
        
        //input corresponding Data into fields
        username.sendKeys("tomsmith");					
        password.sendKeys("SuperSecretPassword!");	
        
        // Get webElement corresponding to Log in button and click on log in
        driver.findElement(By.className("radius")).click();
        
		 
		//3. Assert the success message “You logged into a secure area!”
      
     // This will capture error message
        String actual_msg=driver.findElement(By.id("flash")).getText();
            
        // Store message in variable
        String expect="You logged into a secure area!\r\n"
        		+ "×";
                        
        // Here Assert is a class and assertEquals is a method which will compare two values if// both matches it will run fine but in case if does not match then if will throw an 
        //exception and fail testcases
         
        // Verify error message
        Assert.assertEquals(actual_msg, expect);
         
            }
        
		 //driver.close();
	}


