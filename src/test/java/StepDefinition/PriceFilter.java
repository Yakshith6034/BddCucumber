package StepDefinition;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObject.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.ExcelUtilites;

public class PriceFilter 



{
	WebDriver driver;
	String filepath = "C:\\Users\\ykorvi\\Desktop\\TestData.xlsx";
	WebDriverWait wait;

	@Given("the user opens the BookCart Application")
	public void when_user_navigates_to_the_book_cart_application() {

		// Initialize WebDriver, navigate to the application, and manage timeouts and
		// window size
		driver = new ChromeDriver();
		driver.get("https://bookcart.azurewebsites.net/");
		Options manage = driver.manage();
		manage.timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		manage.window().maximize();
		System.out.println(driver.getTitle());

	} 
	
	@Given("User clicks on the login button")
	public void user_clicks_on_the_login_button()

	{
		// Click on the login button
		driver.findElement(By.xpath("(//span[text()='Login'])[1]/..")).click();
	}
	
	@Given("User enters username")
	public void user_enters_the_username() {
		// Enter username

		LoginPage Lp = new LoginPage(driver);

		String Username = ExcelUtilites.getCellValue(filepath, "Sheet1", 1, 0);

		Lp.UserName(Username);

	}

	@Given("User enters password")
	public void user_enters_the_password() {
		// Enter password
		LoginPage Lp = new LoginPage(driver);
		String Password = ExcelUtilites.getCellValue(filepath, "Sheet1", 1, 1);

		Lp.Password(Password);
	}

	@When("User clicks on Login button")
	public void user_clicks_on_login_button() {
		// Click on the login button to initiate login process
		driver.findElement(By.xpath("(//span[text()='Login'])[last()]/..")).click();
	}

	@Then("User should be able to Adjust the Pricing and add the items")
	

		public void user_should_be_able_to_adjust_the_pricing() throws InterruptedException 
	    {
	        
	    	
	    	
	WebElement slider = driver.findElement(By.xpath("/html/body/app-root/div/app-home/div/div[1]/div/app-price-filter/div/div[2]/mat-slider"));
	        
	        Actions actions = new Actions(driver);
	        int desiredValue = 50;
	        int minSliderValue = 12;
	        int maxSliderValue = 1000;
	        int sliderWidth = 200;
	        int desiredSliderPosition = (desiredValue - minSliderValue) * sliderWidth / (maxSliderValue - minSliderValue);
	        
	        actions.clickAndHold(slider).moveByOffset(desiredSliderPosition, 0).release().perform();
	        
	      
	    	
	       List<WebElement> T =  driver.findElements(By.xpath("/html/body/app-root/div/app-home/div/div[2]/div/div/app-book-card/mat-card/mat-card-content[2]/div/a/strong"));
	       
	       for (WebElement element : T) 
	       
	       {
	           System.out.println(element.getText());
	          
	           if (element.getText().equals("The Chosen"))
	           {
	               // If the text matches, click on the element
	               element.click();
	               Thread.sleep(10000);
	               driver.findElement(By.xpath("/html/body/app-root/div/app-book-details/div/div[2]/div[2]/div/app-addtocart/button")).click();
	              driver.findElement(By.xpath("/html/body/app-root/app-nav-bar/mat-toolbar/mat-toolbar-row/div[3]/button[2]")).click();
	              Thread.sleep(5000);
	              
	              
	              break; 
	           }
	       
	       } 
	      
	       
	       Thread.sleep(5000);
	       
	       List<WebElement> CartItems = driver.findElements(By.xpath("/html/body/app-root/div/app-shoppingcart/div/mat-card/table/tbody/tr/mat-card-content/td[2]/a"));
	       
	              
	              for (WebElement Element : CartItems) 
	              {
	                 
	                      // Get the text directly within the scope of the try block
	                      String elementText = Element.getText();
	                      System.out.println(elementText);

	                      if (elementText.equals("The Chosen")) 
	                      {
	                          // If the text matches, click on the element
	                          System.out.println("Item is added to cart successfully:" +  elementText);
	                        
	                      }
	                  } 
	                  
	                
	                  
	                  
	                  
	              }
	           
	        
	           
	           
	           
	       
		
		
		
}
