package StepDefinitions;

import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import PageObject.AddCustomer;
import PageObject.LoginPage;
import PageObject.SearchCustomPage;

public class BaseVariable {
	public WebDriver driver;
	public LoginPage l;
	public AddCustomer a;
	public SearchCustomPage sCust;
	public static Logger logger;
	public Properties pro;
	
	///created for generating randomstring for uniq email
	public static String randomstring()
	{
		String generatedString1=RandomStringUtils.randomAlphabetic(5);
		return (generatedString1);
	}
}
