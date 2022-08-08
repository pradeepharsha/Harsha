package ABC_Demo11;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TC02_Add_Skills {
	
	WebDriver driver;
	
	//Step1-Global variable
	String TestURL="https://opensource-demo.orangehrmlive.com/";
	String UserName="Admin",password="admin123";
	String SkillName="Oracle2",SkillDescr="Oracle2 descr";
	
  @Test
  public void SkillsTest() throws Exception {
	  
	  TC02_Add_Skills T2=new TC02_Add_Skills();
	  T2.OpenChromeBrowser();
	  T2.OpenOrangeHRM(TestURL);//step2
	  T2.Login(UserName,password);//step2
	  T2.AddSKills(SkillName,SkillDescr);//step2
		
  }
  
  
  
  
  public void OpenChromeBrowser() throws Exception {
	  
	  System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;	
  }
  
  
  
  public void OpenOrangeHRM(String TestURL1) throws Exception {
	  
		driver.get(TestURL1);
  }
  
  
  
  public void Login(String UserName1,String password1) throws Exception {
	  
		findElement(By.name("txtUsername")).sendKeys(UserName1);
		findElement(By.name("txtPassword")).sendKeys(password1);
		findElement(By.id("btnLogin")).click();
  }
  
  
  
  public void AddSKills(String SkillName,String SkillDescr) throws Exception {
	  
		findElement(By.id("menu_admin_viewAdminModule")).click();
		findElement(By.id("menu_admin_Qualifications")).click();
		findElement(By.id("menu_admin_viewSkills")).click();
		findElement(By.id("btnAdd")).click();
		findElement(By.id("skill_name")).sendKeys(SkillName);
		findElement(By.id("skill_description")).sendKeys(SkillDescr);
		findElement(By.id("btnSave")).click();
  }
  
  
  
  
  public  WebElement findElement(By by) throws Exception 
	{

		WebElement elem = driver.findElement(by);  
		
		if (driver instanceof JavascriptExecutor) 
		{
		 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
	 
		}
		return elem;
	}


  
  
  
  
  
  
  
  
  
}
