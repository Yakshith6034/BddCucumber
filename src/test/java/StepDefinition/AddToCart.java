package StepDefinition;

import java.util.List;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObject.LoginPage;
import PageObject.addToCart;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.EnvConfig;
import utilities.ExcelUtilites;

public class AddToCart {

    WebDriver driver;
    WebDriverWait wait;
    private EnvConfig envConfig = new EnvConfig();
    private String excelFilePath = envConfig.getExcelFilePath();
    String baseUrl = envConfig.getBaseUrl();
    
    boolean itemFound = false;  // Initialize a flag to track if the item is found

    @Given("the user navigates to the BookCart application1")
    public void when_user_navigates_to_the_book_cart_application1() {
        try {
            driver = new ChromeDriver();
            driver.get(baseUrl);
            Options manage = driver.manage();
            manage.timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            manage.window().maximize();
            System.out.println(driver.getTitle());
        } catch (Exception e) {
            e.printStackTrace();
            // Handle the exception here or rethrow it if needed
        }
    }

    @And("user navigates to the BookCart")
    public void userLoginIntoTheApplicationWithAnd() {
        try {
            LoginPage Lp = new LoginPage(driver);

            driver.findElement(By.xpath("(//span[text()='Login'])[1]/..")).click();
            String Username = ExcelUtilites.getCellValue(excelFilePath, "Sheet1", 1, 0);
            String Password = ExcelUtilites.getCellValue(excelFilePath, "Sheet1", 1, 1);
            Lp.UserName(Username);
            Lp.Password(Password);
            driver.findElement(By.xpath("(//span[text()='Login'])[last()]/..")).click();
        } catch (Exception e) {
            e.printStackTrace();
            // Handle the exception here or rethrow it if needed
        }
    }

    @Given("user searches for a book")
    public void userSearchForA() throws InterruptedException {
        try {
            Thread.sleep(1000);

            addToCart Cart = new addToCart(driver);
            Cart.SearchProduct();
        } catch (Exception e) {
            e.printStackTrace();
            // Handle the exception here or rethrow it if needed
        }
    }

    @When("user add the book to the cart")
    public void userAddTheBookToTheCart() {
        try {
            addToCart Cart = new addToCart(driver);
            Cart.BookCart();
            
            List<WebElement> Search = driver.findElements(By.xpath("/html/body/app-root/div/app-home/div/div[2]/div/div"));
            
            if (Search.size() == 1)
            {
                System.out.println("one product only displayed in the search results");
            	
            } 
            else 
            {
                // Condition not met: Handle the case when the number of products is not equal to 1.
                // You can add assertions or perform other actions here as needed.
            }
            
        } catch (Exception e) {
            e.printStackTrace()  ;
            // Handle the exception here or rethrow it if needed
        }
    }

    @Then("the cart badge should get updated")
    public void theCartBadgeShouldGetUpdated() throws InterruptedException {
        try {
          
           

        	addToCart AC = new addToCart(driver);
        	AC.CartList();
            List<WebElement> CartItems = driver.findElements(By.xpath("/html/body/app-root/div/app-shoppingcart/div/mat-card/table/tbody/tr/mat-card-content/td[2]/a"));

            for (WebElement Element : CartItems) 
            {
                String elementText = Element.getText();
                System.out.println("SearchedProduct:" + elementText);
             

                if (elementText.equals("Roomies")) 
                {
                    System.out.println("Item is added to cart successfully");
                } 
                break;

            }
            
            
            
        } 
        
        catch (Exception e) 
        {
            e.printStackTrace();
            // Handle the exception here or rethrow it if needed
        }
    
    
       
    
    
    
    }
    
   
    @Given("the cart contains the selected item")
    public void thecartcontainstheselecteditem()
    {
       
    	 try {
             
             

         	addToCart AC = new addToCart(driver);
         	AC.CartList();
             List<WebElement> CartItems = driver.findElements(By.xpath("/html/body/app-root/div/app-shoppingcart/div/mat-card/table/tbody/tr/mat-card-content/td[2]/a"));

             for (WebElement Element : CartItems) 
             {
                 String elementText = Element.getText();
                 System.out.println("SearchedProduct:" + elementText);
              

                 if (elementText.equals("Roomies")) 
                 {
                     System.out.println("Item is added to cart successfully");
                 } 
                 break;

             }
             
             
             
         } 
         
         catch (Exception e) 
         {
             e.printStackTrace();
             // Handle the exception here or rethrow it if needed
         }
    
    
    
    
    }

    @When("the user removes the item from the cart")
    public void the_user_removes_the_item_from_the_cart() throws InterruptedException 
    {
       
    	addToCart AC = new addToCart(driver);
     	AC.CartList();
     	AC.removeItem();

    }
    
    
//    @When("the user clicks the plus button for the product quantity")
//    public void the_user_clicks_the_plus_button_for_the_product_quantity() throws InterruptedException 
//    
//    {
//    	
//    	
//    	    addToCart AC = new addToCart(driver);
//    	    AC.CartList();
//    	    
//    	    List<WebElement> CartItems = driver.findElements(By.xpath("/html/body/app-root/div/app-shoppingcart/div/mat-card/table/tbody/tr/mat-card-content/td[2]/a"));
//
//    	    for (WebElement Element : CartItems) {
//    	        String elementText = Element.getText();
//    	        System.out.println("SearchedProduct:" + elementText);
//
//    	        if (elementText.equals("Roomies")) {
//    	            WebElement plusButton = driver.findElement(By.xpath("/html/body/app-root/div/app-shoppingcart/div/mat-card/table/tbody/tr/mat-card-content/td[6]/button[2]")); // Find the plus button
//    	            plusButton.click(); // Click on the plus button to increase the quantity
//    	            System.out.println("Quantity increased");
//
//    	            // Optional: Verify that the quantity has been increased
//    	            WebElement quantityElement = driver.findElement(By.xpath("/html/body/app-root/div/app-shoppingcart/div/mat-card/table/tbody/tr/mat-card-content/td[4]")); // Assuming this element contains the quantity
//    	            String quantityText = quantityElement.getText();
//    	            // Parse the quantity from the text and compare it to your expected quantity
//    	            int currentQuantity = Integer.parseInt(quantityText);
//    	            int expectedQuantity = 2; // Change this to your desired quantity
//    	            if (currentQuantity == expectedQuantity) {
//    	                System.out.println("Quantity is as expected: " + currentQuantity);
//    	            } else {
//    	                System.out.println("Quantity is not as expected. Current Quantity: " + currentQuantity);
//    	            }
//
//    	            String msg = "Product removed from cart";
//    	            
//    	            // Check if the page text contains the message and print it
//    	            String pageText = driver.findElement(By.tagName("body")).getText();
//    	            if (pageText.contains(msg)) {
//    	                System.out.println(msg);
//    	            }
//
//    	            break;
//    	        }
//    	    }
//    	


    	          
    	        
 
    	
    	           
    	           

    	         
    	       
    	    
    	}

    	
    	
    

    

