package com.crm.TestCases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.FileUtility.BaseClass;
import com.crm.FileUtility.FileUtility;
@Listeners(com.crm.Listeners.BasicListener.class)
public class CreateOrganization extends BaseClass {
	
	

		@Test
		public void createOrganization() throws EncryptedDocumentException, IOException, InterruptedException {
			String organizationName = FileUtility.getData("TC_1", 1, 2);
			com.crm.POM.Organization organization = new com.crm.POM.Organization(driver);
			organization.createOrganization(organizationName);
			String name1 = organization.verifyText();
			assertEquals(name1.contains(organizationName),true);
		}
	}




