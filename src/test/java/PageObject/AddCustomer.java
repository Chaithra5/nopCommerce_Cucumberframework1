package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomer {

	WebDriver ldriver;
	WebElement listitem ;
	public AddCustomer(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(ldriver, this);
	}
	By  customermenu= By.xpath("//a[@href='#']//span[text()='Customers']");
	By  customersubMenu =By.xpath("//span[text()='Customers'][@class='menu-item-title']");
	By addCustomer= By.xpath("//a[@class='btn bg-blue']");
	By   Email=By.id("Email");
	By pwd=By.id("Password");
	By   firstName= By.id("FirstName");
	By lastName= By.id("LastName");
	By   gender_male= By.id("Gender_Male");
	By gender_female= By.id("Gender_Female");
	By dateOfBirth= By.id("DateOfBirth");
	By   company= By.xpath("//input[@name='Company']");
	By  taxExempt= By.id("IsTaxExempt");
	By       Newletter_yourstorename= By.name("SelectedNewsletterSubscriptionStoreIds");
	By  Newletter_TestStore2    =By.name("SelectedNewsletterSubscriptionStoreIds");
	By    customer_roles= By.xpath("//div[@class='k-multiselect-wrap k-floatwrap']");
	By customer_guest=By.xpath("//li[contains(text(),'Guests')]");
	By    customer_forum=By.xpath("//li[contains(text(),'Forum Moderators')]");
	By    customer_register= By.xpath("//li[contains(text(),'Registered')]");
	By   customer_vendor= By.xpath("//li[contains(text(),'Vendors')]");
	By  customer_administrator=By.xpath("//li[contains(text(),'Administrators')]");
	By  managevendor=  By.id("VendorId");
	By    comment= By.id("AdminComment");
	               By   save= By.name("save");
	
	////Action
	public String getTittle()
	{
		return ldriver.getTitle();
	}
	    public void clickOncustomermenu()
	    {
	    	ldriver.findElement(customermenu).click();
	    }
	    public void clickOncustomersubMenu()
	    {
	    	ldriver.findElement(customersubMenu).click();
	    }
	    public void clickOnaddCustomer()
	    {
	    	ldriver.findElement(addCustomer).click();
	    }
	    public void enterEmail(String data)
	    {
	    	ldriver.findElement(Email).sendKeys(data);
	    }
	    public void enterPassword(String data)
	    {
	    	ldriver.findElement(pwd).sendKeys(data);
	    }
	    public void enterfirstName(String data)
	    {
	    	ldriver.findElement(firstName).sendKeys(data);
	    }
	    public void enterlastName(String data)
	    {
	    	ldriver.findElement(lastName).sendKeys(data);
	    }
	    public void entergender(String data)
	    {
	    if(data.equalsIgnoreCase("Male")){
	    	ldriver.findElement(gender_male).click();
	    }
	    else{
	    	ldriver.findElement(gender_female).click();
	    }}
	    public void enterDtae(String data)
	    {
	    	ldriver.findElement(dateOfBirth).sendKeys(data);
	    }
	    public void entercompany(String data)
	    {
	    	ldriver.findElement(company).sendKeys(data);
	    }
	    public void entertaxExempt()
	    {
	    	ldriver.findElement(taxExempt).click();
	    }
	    public void enterNewletter_yourstorename()
	    {
	    	ldriver.findElement(Newletter_yourstorename).click();
	    }
	    public void enterNewletter_TestStore2()
	    {
	    	ldriver.findElement(Newletter_TestStore2).click();
	    }
	    public void clickOncustomer_roles(String data)
	    {
	    	ldriver.findElement(customer_roles).click();
	    	
	    	if(data.equalsIgnoreCase("Guest"))
	    	{
	    		listitem=ldriver.findElement(customer_guest);
	    	}else if(data.equalsIgnoreCase("Administrators"))
	    	{
	    		listitem=ldriver.findElement( customer_administrator);
	    	}else if(data.equalsIgnoreCase("Vendor"))
	    	{
	    		listitem=ldriver.findElement(customer_vendor);
	    	}
	    	//listitem.click();
	    	
	    	JavascriptExecutor js =(JavascriptExecutor)ldriver;
	    	js.executeScript("arguments[0].click()", listitem);
	    	
	    }
	    public void entermanagevendor()
	    {
	    	Select s= new Select(ldriver.findElement(managevendor));
	    	s.selectByIndex(1);
	    }
	    public void addcomment(String data)
	    {
	    	ldriver.findElement(comment).sendKeys(data);
	    }
	    public void clickOnSave()
	    {
	    	
	    	ldriver.findElement(save).click();
	    }
	    
	   
	    
}     
