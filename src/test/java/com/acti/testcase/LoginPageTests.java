package com.acti.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.acti.base.DriverScript;
import com.acti.pages.LoginPage;

public class LoginPageTests extends DriverScript {
	
	@Test
	public void testLoginPageTitle() {
	initApplication();
	LoginPage lp = new LoginPage();
	String actual="actiTIME - Login";
	String expected = lp.getLoginpageTitle();
	System.out.println(expected);
	Assert.assertEquals(actual, expected);
	quitDriver();
}	@Test
	public void testActiImgDisplayed() {
		initApplication();
		LoginPage lp = new LoginPage();
		boolean flag = lp.verifyactiImg();
		Assert.assertTrue(flag);
		quitDriver();
			
	}
	@Test
	public void testForgotPasswordDisplayed() {
		initApplication();
		LoginPage lp = new LoginPage();
		boolean flag = lp.verifyforgotpasswordLink();
		Assert.assertTrue(flag);
		quitDriver();
		
	}
	@Test
	public void testLoginFunction() {
		initApplication();
		LoginPage lp = new LoginPage();
		lp.enterusername("test25@test.com");
		lp.enterpassword("test123");
		lp.clickLoginButton();
		quitDriver();
			
	}
	@Test
	public void testLoginInvalidCredentials() {
		initApplication();
		LoginPage lp = new LoginPage();
		lp.enterpassword("test123");
		lp.clickLoginButton();
		String errmsg = lp.getErrMsgText();
		System.out.println(errmsg);
		quitDriver();
	
		
		
	}
}