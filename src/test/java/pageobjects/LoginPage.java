package pageobjects;

  import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

	public class LoginPage extends BasePage {

		public LoginPage(WebDriver driver) {
			super(driver);
		}

		@FindBy(xpath = "//input[@id='input-email']")
		WebElement txtEmailAddress;

		@FindBy(xpath = "//input[@id='input-password']")
		WebElement txtPassword;

		@FindBy(xpath = "//input[@value='Login']")
		WebElement btnContinue;
		
		@FindBy(xpath="//div[text()='Warning: No match for E-Mail Address and/or Password.']")
		WebElement error_Message;


		public void setEmail(String email) {
			txtEmailAddress.sendKeys(email);
		}

		public void setPassword(String pwd) {
			txtPassword.sendKeys(pwd);
		}

		public void clickLogin() {
			
			//JavascriptExecutor js=(JavascriptExecutor)driver;
			//js.executeAsyncScript("arguments[0].click();",btnContinue);
			//Actions act=new Actions(driver);
			//act.moveToElement(btnContinue).click().perform();
			//btnContinue.sendKeys(Keys.RETURN);
			btnContinue.submit();
		}
		
		public String getErrorText()
		{
			return error_Message.getText();
		}

		

	}



