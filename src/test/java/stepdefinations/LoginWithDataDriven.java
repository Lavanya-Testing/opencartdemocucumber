package stepdefinations;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import factory.BaseClass;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pageobjects.HomePage;
import pageobjects.LoginPage;

public class LoginWithDataDriven {
	HomePage hp;
	LoginPage lp;
	@Given("the user navigates to loginpage")
	public void the_user_navigates_to_loginpage() {
	    
		hp=new HomePage(BaseClass.getDriver());
		hp.clickMyAccount();
		hp.clickLogin();
	}

	@When("the user enter {string} and {string}")
	public void the_user_enter_and(String email, String password) {
	     lp=new LoginPage(BaseClass.getDriver());
	     lp.setEmail(email);
	     lp.setPassword(password);
	     lp.clickLogin();
	}

	@When("user clicks on the login button")
	public void user_clicks_on_the_login_button() {
		lp.clickLogin();
	}

	@Then("user should get error message")
	public void user_should_get_error_message(DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
		 List<Map<String,String>> listOfMaps=dataTable.asMaps();
		String  exp_Text=listOfMaps.get(0).get("errorMessage");
		 String actualText=lp.getErrorText();
		 System.out.println(actualText);
		 Assert.assertEquals("done", actualText, exp_Text);

		
	}

}
