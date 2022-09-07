package com.Flipkart.Stepdefinition;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class MobilePurchase {
	

    public static  WebDriver driver;

	@BeforeClass
	
	public static void  openBrow() throws InterruptedException{
		System.out.println("launch");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vinit\\workspace\\Chrome brow\\Driver\\chromedriver.exe");
		
		   driver=new ChromeDriver();
		 driver.navigate().to("https://www.flipkart.com/");
		 driver.manage().window().maximize();
		 Thread.sleep(2000);
		
	}
	 @AfterClass
	   public static void closebrow(){
		   System.out.println("closing brow");
		   driver.quit();
	   }
	 
	   @Before
	   public void starttime(){
		    
		   System.out.println(java.time.LocalTime.now());
	   }
	   @After
	   public void endtime(){
		   System.out.println(java.time.LocalTime.now());
		  
	   }
	   @Test
     public void method1() throws InterruptedException 
	   {
		   System.out.println("login");
		   
			  
		   WebElement out=   driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
			out.click();
     }
	   
	  
	   @Test
	   public void method2() 
			   throws InterruptedException, IOException{
		   System.out.println("search");
		   
		   driver.findElement(By.name("q")).sendKeys("samsung mobiles");
		   driver.findElement(By.xpath("//*[@type='submit']")).click();
		   Thread.sleep(2000);
		    
           File s= new File("C:\\Users\\vinit\\OneDrive\\Documents\\sampleexl.xlsx");
     	  
         	  FileOutputStream m = new FileOutputStream(s);
     	  Workbook E= new XSSFWorkbook();
     	  Sheet r= E.createSheet("MOBILES LIST");
     	List<WebElement> tdata=  driver.findElements(By.xpath("//*[contains(text(),'SAMSUNG')]"));
         
        for(int i=1; i<tdata.size();i++){
       WebElement adata=  tdata.get(i);
       String print=adata.getText();
     	  Row t= r.createRow(i);
     	  Cell y= t.createCell(0);
     	  y.setCellValue(print);}
    
     	  E.write(m);
         E.close();  
           
			
			
	   }
	    
	   @Test
	   public void method3()throws InterruptedException{
		   System.out.println("windowhandle");
		   driver.findElement(By.xpath("//*[contains(text(),'SAMSUNG Galaxy F22 (Denim Black, 64 GB)')]")).click();
		   Thread.sleep(2000);
		   String parent=  driver.getWindowHandle();
		     
    		Set<String>child=driver.getWindowHandles();
    		
    		for(String v:child){
    			if(!parent.equals(v)){
    				driver.switchTo().window(v);
    			}
    		}
   
    	
	   }
	   @Test
	   public void method4() throws IOException{
		   
   
        WebElement name=driver.findElement(By.xpath("(//*[contains(text(),'SAMSUNG Galaxy F22 (Denim Black, 64 GB)')]) [2]") );
         String ab= name.getText();
         
         
         File s= new File("C:\\Users\\vinit\\OneDrive\\Documents\\sampleexl.xlsx");
          FileInputStream f1= new FileInputStream(s);
          Workbook F= new XSSFWorkbook(f1);
          Sheet P= F.getSheet("MOBILES LIST");
          
        
        	  Row u=P.getRow(2);
        	  
        	  for (int j = 0; j < u.getPhysicalNumberOfCells(); j++) {
        		  Cell n= u.getCell(j);
				Assert.assertEquals(ab, n);
			}
        	          
        
	   }
	   @Test
	 public void method5() throws IOException{
		 System.out.println("Screenshot");
		  JavascriptExecutor j= (JavascriptExecutor)driver;
			//WebElement scroll=driver.findElement(By.xpath("//*[contains(text(),'Specifications')]"));
		   j.executeScript("window.scrollBy(0,1800)","");
		   TakesScreenshot t= (TakesScreenshot)driver;
	         File src=  t.getScreenshotAs(OutputType.FILE);
	        File des= new File("C:\\Users\\vinit\\eclipse-workspace2\\Junit-Projects\\Screenshot2\\photo.png");
	        FileUtils.copyFile(src, des);
	 }
	  
	   


}
