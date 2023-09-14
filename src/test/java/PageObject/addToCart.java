package PageObject;

import java.util.List;

import org.openqa.selenium.By;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class addToCart

{
public WebDriver ldriver;
  By Product = By.xpath("/html/body/app-root/app-nav-bar/mat-toolbar/mat-toolbar-row/div[2]/app-search/form/input");
  By SearcH_Product = By.cssSelector("span.mat-option-text");
  By Select_Theme = By.xpath("/html/body/app-root/app-nav-bar/mat-toolbar/mat-toolbar-row/div[3]/app-theme-picker/button");
  By BookCart = By.xpath("(//button[@color='primary']//span/..)[1]");
  By CarttItemList =  By.xpath(("/html/body/app-root/app-nav-bar/mat-toolbar/mat-toolbar-row/div[3]/button[2]"));
  By DeleteItem = By.xpath(("/html/body/app-root/div/app-shoppingcart/div/mat-card/table/tbody/tr/mat-card-content/td[2]/a"));
 
  public addToCart(WebDriver rdriver)
		
  {
			ldriver = rdriver;
			
		}
		
		
		
		public void SearchProduct( )
		{
		
			ldriver.findElement(Product).sendKeys("Roomies");
			ldriver.findElement(SearcH_Product).click();
			
		}
		
		public void BookCart()
		{
			
			ldriver.findElement(BookCart).click();
		}
		
		public void SelectTheme()
		{
			ldriver.findElement(Select_Theme).click();
		}
		
		
		public void CartList()
		{
			ldriver.findElement(CarttItemList).click();
		}
		
		

	public void removeItem() throws InterruptedException
	{
		
		
	         List<WebElement> CartItems = ldriver.findElements(DeleteItem);

	         for (WebElement Element : CartItems) 
	         {
	             String elementText = Element.getText();
	             System.out.println("SearchedProduct:" + elementText);
	          

	             if (elementText.equals("Roomies")) 
	             {
	                 
	            	 ldriver.findElement(By.xpath("/html/body/app-root/div/app-shoppingcart/div/mat-card/table/tbody/tr/mat-card-content/td[6]/button/span[1]/mat-icon")).click();
	            	 System.out.println("Item is removed from the cart");
	            	Thread.sleep(1000);
	            	String msg = "Product removed from cart";
	                
	                // Check if the page text contains the message and print it
	                String pageText = ldriver.findElement(By.tagName("body")).getText();
	                if (pageText.contains(msg)) 
	                {
	                	
	                	
	                	
	                	
	                    System.out.println(msg + " Successfully");
	                }
	                       
	            	 break;
	            	 
	            	 
	            	 
	             } 
	             

	         }
	    }

		
		
	}
		

		


		
		

	
	
	
	
	
	
	
	
	


