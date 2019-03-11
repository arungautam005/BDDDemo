package com.sephora.dsg.pages;

import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.sephora.dmg.core.driver.SephoraDsgMobileDriver;

/**
 * @author Gspann SephoraBasePage is the super class for all the page
 *         classes
 */
public class SephoraBasePage extends SephoraDsgMobileDriver{
//	public WebDriver driver;
	  public final String CHAR_LIST = 
		        "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	  public final int RANDOM_STRING_LENGTH = 4;

	  public WebDriver driver = SephoraDsgMobileDriver.driver;
	

	public void DefaultWait(int timemiliseconds){
		try {
			Thread.sleep(timemiliseconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	   public int getRandomNumber() {
	        int randomInt = 0;
	        Random randomGenerator = new Random();
	        randomInt = randomGenerator.nextInt(CHAR_LIST.length());
	        if (randomInt - 1 == -1) {
	            return randomInt;
	        } else {
	            return randomInt - 1;
	        }
	    }
	
	   public String generateRandomString(){
	         
	        StringBuffer randStr = new StringBuffer();
	        for(int i=0; i<RANDOM_STRING_LENGTH; i++){
	            int number = getRandomNumber();
	            char ch = CHAR_LIST.charAt(number);
	            randStr.append(ch);
	        }
	        return randStr.toString();
	    }
		public void VerifyClientPresent(String ClientName,String location) {
			try {
				List<WebElement> clients =SephoraDsgMobileDriver.driver.findElements(By.name(ClientName));
				WebElement client = driver.findElement(By.name(ClientName));
				int noOfClient=clients.size();
				if(noOfClient>0) {
					while(!client.isDisplayed()) {
						swipe(300, 350, 300, -100,"Up");
					}
					TestInfo("Verified "+ClientName+" present at "+location);
				}
				else {
					TestInfo("Verified "+ClientName+" not present at "+location);
					Assert.fail();
				}
			}
			catch(Exception e) {
				TestInfo("Failed to Verify Client present at "+location);
				Assert.fail();
			}
		}

		public void VerifyStringPresent(String Name,String location) {
			try {
				List<WebElement> clients =driver.findElements(By.name(Name));
				int noOfClient=clients.size();
				if(noOfClient>0) {
					TestInfo("Verified "+Name+" present at "+location);
				}
				else {
					TestInfo("Verified "+Name+" not present at "+location);
					Assert.fail();
				}
			}
			catch(Exception e) {
				TestInfo("Failed to Verify"+Name+" present at "+location);
				Assert.fail();
			}
		}

		public void ClickByClientName(String clientname) {
			List<WebElement> clients=driver.findElements(By.name(clientname));
			if(clients.size()>0) {
				WebElement client=driver.findElement(By.name(clientname));
				while(!client.isDisplayed()) {
					swipe(300, 350, 300, 600);
				}

				click(client, clientname);
			}

			else {
				TestInfo("Client not found");
				Assert.fail();
			}
		}

		public void VerifyClientNotPresent(String ClientName,String location) {
			try {
				List<WebElement> clients =driver.findElements(By.name(ClientName));
				int noOfClient=clients.size();
				if(noOfClient==0) {
					TestInfo("Verified "+ClientName+" not present at "+location);

				}
				else {
					TestInfo("Verified "+ClientName+" present at "+location);
					Assert.fail();
				}
			}
			catch(Exception e) {
				TestInfo("Failed to Verify Client not present at "+location);
				Assert.fail();
			}
		}

		public void VerifyClientNotPresent(String ClientName,String ClientTime,String location) {
			try {
				List<WebElement> clients =driver.findElements(By.xpath("//XCUIElementTypeStaticText[@name='"+ClientName+"']/following-sibling::XCUIElementTypeStaticText[@name='"+ClientTime+"']"));
				int noOfClient=clients.size();
				if(noOfClient==0) {
					TestInfo("Verified "+ClientName+" not present at "+location);

				}
				else {
					TestInfo("Verified "+ClientName+" present at "+location);
					Assert.fail();
				}
			}
			catch(Exception e) {
				TestInfo("Failed to Verify Client not present at "+location);
				Assert.fail();
			}
		}

		public void VerifyClientPresent(String ClientName,String ClientTime,String location) {
			try {
				List<WebElement> clients =driver.findElements(By.xpath("//XCUIElementTypeStaticText[@name='"+ClientName+"']/following-sibling::XCUIElementTypeStaticText[@name='"+ClientTime+"']"));
				int noOfClient=clients.size();
				if(noOfClient==1) {
					TestInfo("Verified "+ClientName+" present at "+location);

				}
				else {
					TestInfo("Verified "+ClientName+" not present at "+location);
					Assert.fail();
				}
			}
			catch(Exception e) {
				TestInfo("Failed to Verify Client present at "+location);
				Assert.fail();
			}
		}


		public void VerifyClientNotDisplay(int NumberOfClients) {
			try {
				List<WebElement> element1=driver.findElements(By.xpath("//XCUIElementTypeCell"));
				int noOfclient=element1.size();
				if(NumberOfClients>noOfclient) {
					TestInfo("Verified client not display");
				}
				else {
					TestInfo("Client displayed");
					Assert.fail();
				}
			}
			catch(Exception e) {
				TestInfo("Failed to Verify client display");
				Assert.fail();
			}
		}
		
		

	}

