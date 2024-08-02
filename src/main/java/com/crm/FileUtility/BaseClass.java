package com.crm.FileUtility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.crm.POM.Login;

public class BaseClass {
		
		public static WebDriver driver;
		
		@BeforeClass
		public void preCondition() throws IOException {
			String browser=JavaUtility.getInputData("browser");
			if (browser.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();
			} else if (browser.equalsIgnoreCase("edge")) {
				driver = new EdgeDriver();
			} else {
				driver = new ChromeDriver();
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			driver.get(JavaUtility.getInputData("url"));
		}

		@BeforeMethod
		public void login() throws IOException {
			Login login = new Login(driver);
			login.login(JavaUtility.getInputData("username"),JavaUtility.getInputData("password"));
		}

		@AfterMethod
		public void logout() {
			Login login = new Login(driver);
//			login.signOut();
		}

		@AfterClass
		public void postCondition() {
			driver.quit();
		}
	}
