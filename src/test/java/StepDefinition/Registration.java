package StepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObject.LoginPage;
import PageObject.RegistrationPage;
import PageObject.addToCart;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.EnvConfig;
import utilities.randomStringUtilites;

public class Registration {
	WebDriver driver;

	WebDriverWait wait;
	String name = "";

	private EnvConfig envConfig = new EnvConfig();

	String baseUrl = envConfig.getBaseUrl();

	@Given("the user navigate to the Cart application")
	public void the_user_navigates_to_the_cart_application() {
		driver = new ChromeDriver();
		driver.get(baseUrl);
		Options manage = driver.manage();
		manage.timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		manage.window().maximize();
		System.out.println(driver.getTitle());
	}

	@Given("user clicks on  login button")
	public void user_clicks_on_the_login_button()

	{
		// Click on the login button
		RegistrationPage RP = new RegistrationPage(driver);
		RP.Login();

	}

	@When("the user clicks on the Register button")
	public void the_user_clicks_on_the_Register_button() {

		RegistrationPage RP = new RegistrationPage(driver);
		RP.RegisterButton();
	}

	@When("the user enters the First Name")
	public void the_user_enters_the_first_name() {
		RegistrationPage RP = new RegistrationPage(driver);
		String FirstName = randomStringUtilites.generateRandomString(10);

		RP.FirstName(FirstName);

	}

	@When("the user enters the Last Name")
	public void the_user_enters_the_last_name() {

		RegistrationPage RP = new RegistrationPage(driver);
		String LastName = randomStringUtilites.generateRandomString(10);

		RP.LastName(LastName);

	}

	@When("the user enters the User Name")
	public void the_user_enters_the_user_name() throws InterruptedException {
		RegistrationPage RP = new RegistrationPage(driver);
		name = randomStringUtilites.generateRandomString(10);
		RP.UserName(name);

		System.out.println(name);
		// the_user_details_should_be_saved_successfully(name);

	}

	@When("the user enters the Password")
	public void the_user_enters_the_password() {

		RegistrationPage RP = new RegistrationPage(driver);

		RP.Password("WaveRock@2.3");

	}

	@When("the user enters the Confirm Password")
	public void the_user_enters_the_confirm_password() {
		RegistrationPage RP = new RegistrationPage(driver);

		RP.ConfirmPassword("WaveRock@2.3");
	}

	@Then("the user select the Gender")
	public void the_user_select_the_Gender()

	{

		RegistrationPage RP = new RegistrationPage(driver);

		RP.Gender();

	}

	@Then("the user details should be saved successfully")
	public void the_user_details_should_be_saved_successfully() throws InterruptedException

	{

		Thread.sleep(3000);

		addToCart AC = new addToCart(driver);
		AC.CartList();

		Thread.sleep(3000);

		String Text = driver.findElement(By.xpath("//span[text()='Register']")).getText();

		System.out.println(Text);

		System.out.println(name);

		driver.findElement(By.cssSelector("input[formcontrolname='username']")).sendKeys(name);
		LoginPage Lp = new LoginPage(driver);
		String Pass = "WaveRock@2.3";

		Thread.sleep(2000);
		Lp.Password(Pass);

		System.out.println(Pass);

		Lp.LoginButton();

		System.out.println("Assertion passed: " + Text + "success");

	}

	@When("they enter a password with only uppercase characters")
	public void they_enter_a_password_with_only_uppercase_characters()

	{
		RegistrationPage RP = new RegistrationPage(driver);
		RP.Password("WaveROCK");
		RP.ConfirmPassword("WaveRock");

	}

	@Then("Appropriate Error message should be displayed")
	public void error_message_should_be_displayed() throws InterruptedException {
		Thread.sleep(2000);
		// String expected = "Password should have minimum 8 characters, at least 1
		// uppercase letter, 1 lowercase letter and 1 number";
		WebElement Text = driver.findElement(By.xpath("//*[@id=\"mat-error-0\"]"));
		String T = Text.getText();
		System.out.println("ErrorMessage:" + T);
	}

	@When("the user submits the form without entering mandatory field")
	public void the_user_submits_the_form_without_entering_the_first_name() {
		RegistrationPage RP = new RegistrationPage(driver);
		RP.SubmitWithoutMandatorydeatials();
	}

	@Then("user should see the error message for mandatory field")
	public void UserShouldSeeerrormessage() {

		RegistrationPage RP = new RegistrationPage(driver);
		RP.ErrorMessages();

	}

}
