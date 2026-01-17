package com.BlazeApp.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReservePage {

	private  WebDriver driver;
	
	public ReservePage(WebDriver driver)//driver from base class
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	

	
	//locator
	@FindBy(xpath="//table//tbody//tr")
	List<WebElement> totalSearchResult;
	
	@FindBy(xpath="//table//tbody//tr//td[3]")
	List<WebElement> allAirlines;
	
//	@FindBy(xpath="//table//tr["+"]//td//input")
//	WebElement chooseFlightButton;
	
	//By button=By.xpath("//table//tr["+row+"]//td//input");
	
	//method
	
	
	public int getTotalSearchResult()
	{
		return totalSearchResult.size();
	}
	
	public void getAirlineDetails()
	{
		for(WebElement i:allAirlines)
		{
			System.out.println(i.getText());
		}
		

	}
	
	
	public void chooseFlight(String name)
	{
		int rowcount=0;
		for(WebElement i:allAirlines) 
		{
			rowcount++;
			
			if(i.getText().contains(name))
			{
				System.out.println("Airline found at row: "+rowcount);
				driver.findElement(By.xpath("//table//tr["+rowcount+"]//td//input")).click();
				break;
				
			}
			//return next page object
		}
	}
	
	
	
	
}
