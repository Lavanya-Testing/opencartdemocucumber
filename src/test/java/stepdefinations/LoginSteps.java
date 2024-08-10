package stepdefinations;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.MyAccountPage;
import utilities.DataReader;

public class LoginSteps {
	WebDriver driver;
	HomePage hp;
	LoginPage lp;
	MyAccountPage macc;
	
	List<HashMap<String,String>> dataMap;
	
	
	@Given("the user navigates to login page")
	public void the_user_navigates_to_login_page() throws InterruptedException {
	    BaseClass.getLogger().info("Goto  my account -->Click on login");
	  hp=new HomePage(BaseClass.getDriver());
	  hp.clickMyAccount();
	  Thread.sleep(2000);
	  hp.clickLogin();
	  Thread.sleep(2000);
	}
	
	@When("user enters email as {string} and pwd as {string}")
	public void user_enters_email_as_and_pwd_as(String email, String pwd) {
	    BaseClass.getLogger().info("Entering email and password");
	    lp=new LoginPage(BaseClass.getDriver());
	    lp.setEmail(email);
	    lp.setPassword(pwd);
	}
	@When("user clicks on the Loggin button")
	public void user_clicks_on_the_loggin_button() {
		 BaseClass.getLogger().info("clicked on loggin button");
		    lp=new LoginPage(BaseClass.getDriver());
		    lp.clickLogin();
	    
	}
	@Then("the user should be redirected to the My Account Page")
	public void the_user_should_be_redirected_to_the_my_account_page() {
		 BaseClass.getLogger().info("user redirected to the MyAccount Page");
		    macc=new MyAccountPage(BaseClass.getDriver());
		    boolean targetPage=macc.isMyAccountPageExists();
		    //System.out.println(targetPage);
		   Assert.assertEquals(targetPage, true);
	}
	
	//************Data Driven test *************
	@Then("the user should be redirected to MyAccountPage by passing email and pwd with excel  rows {string}")
	public void the_user_should_be_redirected_to_my_account_page_by_passing_email_and_pwd_with_excel_rows(String rows) {
		try {
			dataMap=DataReader.data(System.getProperty("user.dir")+"\\testdata\\opncart_testdata.xlsx", "sheet1");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int index=Integer.parseInt(rows)-1;
		
		String email=dataMap.get(index).get("username");
		String password=dataMap.get(index).get("password");
		String exp_result=dataMap.get(index).get("result");
		
		LoginPage lp= new LoginPage(BaseClass.getDriver());
		lp.setEmail(email);
		lp.setPassword(password);
		lp.clickLogin();
		
		 macc=new MyAccountPage(BaseClass.getDriver());
		 
		 try {
			 
			 boolean targetPage=macc.isMyAccountPageExists();
			 System.out.println("targetPage :"+targetPage); 
			 if(exp_result.equals("valid"))
			 {
				 if(targetPage==true)
				 {
				    macc.clickLogout();
				    Assert.assertTrue(true);
				 }
				 else
				 {
					 Assert.assertTrue(false);
				 }
				 
			 }
			 else if(exp_result.equalsIgnoreCase("invalid"))
			 {
				 if(targetPage==true)
				 {
				    macc.clickLogout();
				    Assert.assertTrue(false);
				 }
				 else
				 {
					 Assert.assertTrue(true);
				 }
			 }
		 }
		 catch(Exception e)
		 {
			 
		 }
		
		
		
	    
	}

	
	
	

}
