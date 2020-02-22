package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandleWait {
	public WebDriver driver;
	
	public HandleWait(WebDriver driver)
	{
		this.driver=driver;
	}

	public void handingWait(WebElement ele,long duration)
	{
		WebDriverWait wait= new WebDriverWait(driver,duration);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
}
