package com.BlazeApp.Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class P1_HomePage
{
	
	private WebDriver driver;
	
	public P1_HomePage(WebDriver driver)//driver from base class
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	//locators
	@FindBy(name="fromPort")
	private WebElement fromportddEle;
	
	@FindBy(name="toPort")
	private WebElement toportddEle;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement findFlightButton;
	
	//methods
	public String getAppUrl()
	{
		return driver.getCurrentUrl();
	}
	
	public String getAppTitle()
	{
		return driver.getTitle();
	}

	
	public void selectFromPort(String city)
	{
		Select sc=new Select(fromportddEle);
		sc.selectByVisibleText(city);
	}
	
	
	public void selectToPort(String city)
	{
		Select sc=new Select(toportddEle);
		List<WebElement> allOptions=sc.getOptions();
		System.out.println("Total Options are: "+allOptions.size());
		for(WebElement i:allOptions)
		{
			System.out.println(i.getText());
			
			if(i.getText().contains(city))
			{
				//select
				i.click();
				break;
			}
		}
		
	}
	
	
	public ReservePage clickOnFindFlightButton()
	{
		findFlightButton.click();
		//for next page navigation  : return next page object
		return new ReservePage(driver);
	}
}
