package com.sampleproject.testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sampleproject.commonmethods.CommonMethods;
import com.sampleproject.reports.DataLibrary;

import io.restassured.RestAssured;

public class TC01_GETRequest extends CommonMethods {
	
	@BeforeTest
	public void startTest() {
		testcaseName="Fetching the Employee details";
		testcaseDec="TC01 Getting Employee Details";
		author="Automation tester";
		category="Functional Test Case";
	}
	
	@Test (dataProvider ="fetchData")
	public void getEmployeeDetails(String baseURI, String UserId) {
		
		    RestAssured.baseURI=baseURI;
		    httprequest = RestAssured.given(); 
		    
		    
		    CommonMethods.get_auth_info();
		    CommonMethods.getResponseBody(UserId);
		    CommonMethods.getStatusCode(UserId);
		    CommonMethods.getStatusLine(UserId);
		    CommonMethods.verifyStatusCode(UserId,"200");
		    CommonMethods.verifyData(UserId, "name","Janet");
		    CommonMethods.verifyData(UserId, "email", "Weaver@api.com");
	}
	
	@DataProvider(name ="fetchData")
	public String[][] getdata() throws IOException{
		return DataLibrary.readdata();
	}

}
