package SeamlessTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InValidloginTest { 
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/");     //open web page
		
		//2. Click "Form Authentication" 

		driver.findElement(By.linkText("Form Authentication")).click();

		
		//3. Enter thomas for the username and SecretPassword! for the password  
		
        // Get the WebElement corresponding to the username (TextField)		
        WebElement username = driver.findElement(By.id("username"));							

        // Get the WebElement corresponding to the Password Field		
        WebElement password = driver.findElement(By.name("password"));	
        
        //input corresponding Data into fields
        username.sendKeys("thomas");					
        password.sendKeys("SecretPassword!");	
        
        // Get webElement corresponding to Log in button and click on log in
        driver.findElement(By.className("radius")).click();
        
		 
		//4. Assert the error message “Your username is invalid!”
		
        // This will capture error message
        String actual_msg=driver.findElement(By.id("flash")).getText();
            
        // Store message in variable
        String expect="Your username is invalid!\r\n"
        		+ "×";
                        
        // Here Assert is a class and assertEquals is a method which will compare two values if// both matches it will run fine but in case if does not match then if will throw an 
        //exception and fail testcases
         
        // Verify error message
        Assert.assertEquals(actual_msg, expect);
         
		 
		 //driver.close();
	}

}
