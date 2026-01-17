package com.BlazeApp.TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.BlazeApp.BaseClass.BaseClass;

public class ReservePageTest extends BaseClass
{
	@BeforeClass
	public void pageSetup()
	{//user should select the city
		hp.selectFromPort("Mexico City");
		hp.selectToPort("New York");
		hp.clickOnFindFlightButton();
		
	}
	
  @Test(priority=1)
  public void verifyTotalSearch() 
  {
	  int actCount=rp.getTotalSearchResult();
	  Assert.assertEquals(actCount,5);
	  System.out.println("Total Search found: "+actCount);
  }
  
  @Test(priority=2)
  public void verifyAirlineDetails()
  {
	  rp.getAirlineDetails();
  }
  
  @Test(priority=3)
  public void validateFlightSelection()
  {
	  rp.chooseFlight("United Airlines");
  }
  
}
