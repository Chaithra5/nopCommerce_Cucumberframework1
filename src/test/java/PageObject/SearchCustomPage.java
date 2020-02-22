package PageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.HandleWait;

public class SearchCustomPage {

	HandleWait wait;
	WebDriver ldriver;
	 public SearchCustomPage(WebDriver driver)
	 {
		ldriver=driver;
		PageFactory.initElements(ldriver, this);
		wait= new HandleWait(ldriver);
	 }
	 
	@FindBy(id="SearchEmail")
	private WebElement searchEmail;
	@FindBy(name="SearchFirstName")
	private WebElement SearchFirstName;
	@FindBy(name="SearchLastName")
	private WebElement SearchLastName;
	@FindBy(id="search-customers")
	private WebElement searchButton;
	@FindBy (xpath="//div[@id='customers-grid_wrapper']//tbody//tr")
	private List<WebElement> tableRow;
	@FindBy(xpath="//div[@id='customers-grid_wrapper']//tbody//tr//td[2]")
	private List<WebElement> emailCol;
	@FindBy(xpath="//div[@id='customers-grid_wrapper']//tbody//tr//td[3]")
	private List<WebElement> nameCol;
	
public void enterEmail(String email)
{
	wait.handingWait(searchEmail, 30);
	searchEmail.clear();
	searchEmail.sendKeys(email);
}
public void clickOnSearch()
{
	searchButton.click();
}
  public int getRow()
  {
	  return tableRow.size();
  }
	public boolean searchingCustomerEmail()
	{
		boolean flag=false;
			for(WebElement nemailCol:emailCol)
			{
				if(nemailCol.getText().equalsIgnoreCase("brenda_lindgren@nopCommerce.com"))
				{
					flag=true;
				}
		}
		return flag;
	}
	
	public void enterFirstName()
	{
		wait.handingWait(SearchFirstName, 30);
		SearchFirstName.clear();
		SearchFirstName.sendKeys("Steve");
	}
	public void enterLastName()
	{
		wait.handingWait(SearchLastName, 30);
		SearchLastName.clear();
		SearchLastName.sendKeys("Gates");
	}
	public boolean searchCustName()
	{
		boolean flag = false;
		for(WebElement nnameCol:nameCol)
		{
			String name = nnameCol.getText();
			            String[] names = name.split(" ");
			if(names[0].equalsIgnoreCase("Steve")&& names[1].equalsIgnoreCase("Gates"))
			{
				flag= true;
			}
			            
		}
		
		return flag;
		
	}
}
