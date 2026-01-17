package com.BlazeApp.BaseClass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeClass;

import com.BlazeApp.Pages.P1_HomePage;
import com.BlazeApp.Pages.PurchesPage;
import com.BlazeApp.Pages.ReservePage;

public class BaseClass 
{
	//Project configuration class
	
	public WebDriver driver;
	public P1_HomePage hp;
	public ReservePage rp;
	
	@BeforeClass
	public void setUp()
	{
		driver=new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://blazedemo.com/");
		hp=new P1_HomePage(driver);
		rp=new ReservePage(driver);
		
			
	}
	
	

	//@AfterClass
	public void tearDown()
	{
		//close
		driver.quit();
	}
}
