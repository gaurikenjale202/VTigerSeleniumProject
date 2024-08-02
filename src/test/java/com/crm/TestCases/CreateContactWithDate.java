package com.crm.TestCases;


import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.crm.FileUtility.BaseClass;
import com.crm.FileUtility.FileUtility;
import com.crm.POM.Contacts;
import com.crm.POM.HomePage;

import JavaUtility.JavaUtil;

	
public class CreateContactWithDate extends BaseClass{
	
	FileUtility fUtil = new FileUtility();
	@Test
	public void createContact() throws EncryptedDocumentException, IOException {
		//String organizationName = FileUtility.getData("TC_3", 1,2);
		
		HomePage hPage = new HomePage(driver);
		hPage.contacts();
		
		Contacts contacts = new Contacts(driver);
		contacts.plus();
		int row=0;
		String conName =FileUtility.getData("TC_3",row++,0);
		contacts.lastName(conName+JavaUtil.generateRandomNumber(1000));
		contacts.lastName("");
		contacts.endDate(JavaUtil.getCurrentDate());
		contacts.saveBtn();
		assertTrue((contacts.getContactInfo().getText()).contains(conName));
		
		
	}

}

