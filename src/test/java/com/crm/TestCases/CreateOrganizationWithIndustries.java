package com.crm.TestCases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.crm.FileUtility.BaseClass;
import com.crm.FileUtility.FileUtility;

public class CreateOrganizationWithIndustries extends BaseClass {
	
	    @Test
		public void testCase() throws EncryptedDocumentException, IOException {
			String organizationName = FileUtility.getData("TC_2", 1, 2);
			String industry = FileUtility.getData("TC_2", 1, 3);
			com.crm.POM.Organization organization = new com.crm.POM.Organization(driver); 
			organization.createOrganizationWithIndustries(organizationName, industry);
			String name1 = organization.verifyText();
			assertEquals(name1.contains(organizationName), true);
			
			String name2 = organization.verifyTextIndustries();
			assertEquals(name2.contains(industry), true);
		}
	}


