package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	@FindBy(id="Email")
	private WebElement userName;
	@FindBy(id="Password")
	private WebElement pwd;
	@FindBy(xpath="//input[@value='Log in']")
	private WebElement btn;
	@FindBy(xpath="//a[text()='Logout']")
	private WebElement logoutBtn;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
    public void enterUser(String user)
    {
    	userName.sendKeys(user);
    }
    public void enterPassword(String password)
    {
    	pwd.sendKeys(password);
    }
    public void clickOnLogin()
    {
    	btn.click();
    }
    public void clickOnLogout()
    {
    	logoutBtn.click();
    }
}
