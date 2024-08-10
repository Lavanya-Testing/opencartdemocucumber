package stepdefinations;

import java.util.Map;

import org.junit.Assert;

import factory.BaseClass;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pageobjects.AccountRegistrationPage;
import pageobjects.HomePage;

public class RegistrationSteps {
     static HomePage hp;
    static  AccountRegistrationPage regpage;
	@Given("the user navigates to Register Account page")
	public void the_user_navigates_to_register_account_page() {
	      hp=new HomePage(BaseClass.getDriver());
	      hp.clickMyAccount();
	      hp.clickRegister();
	}

	@When("the user enters the details into below fields")
	public void the_user_enters_the_details_into_below_fields(DataTable dataTable) throws InterruptedException {
		 Map<String, String> dataMap=dataTable.asMap(String.class, String.class);
		 regpage= new AccountRegistrationPage(BaseClass.getDriver());
		 regpage.setFirstName(dataMap.get("firstName"));
		 Thread.sleep(2000);
		 regpage.setLastName(dataMap.get("lastName"));
		 Thread.sleep(2000);
		 regpage.setEmail(BaseClass.getAlphaNumeric()+"@gmail.com");
		 Thread.sleep(2000);
		 regpage.setTelephone(dataMap.get("telephone"));
		 Thread.sleep(2000);
		 regpage.setPassword(dataMap.get("password"));
		 Thread.sleep(2000);
		 regpage.setConfirmPasswprd(dataMap.get("password"));
		 Thread.sleep(2000);
		
	    
	}

	@When("the user selects Privacy Policy")
	public void the_user_selects_privacy_policy() throws InterruptedException {
		regpage.setPrivacyPolicy();
		 Thread.sleep(2000);
	}

	@When("the user clicks on Continue button")
	public void the_user_clicks_on_continue_button() throws InterruptedException {
		regpage.clickContinue();
		 Thread.sleep(2000);
	}

	@Then("the user account should get created successfully")
	public void the_user_account_should_get_created_successfully() {
	    String confirmMessage=regpage.getConfirmationMsg();
	    Assert.assertEquals("passed", confirmMessage, "Your Account Has Been Created!");
	}
}
