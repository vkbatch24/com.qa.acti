package com.acti.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTests extends BaseTest {
	
	
	@Test
	public void testLoginPageTitle() {
	String actual="actiTIME - Login";
	String expected = lp.getLoginpageTitle();
	System.out.println(expected);
	Assert.assertEquals(actual, expected);
}	@Test
	public void testActiImgDisplayed() {
		boolean flag = lp.verifyactiImg();
		Assert.assertTrue(flag);
	}
	@Test
	public void testForgotPasswordDisplayed() {
		boolean flag =lp.verifyforgotpasswordLink();
		Assert.assertTrue(flag);
	}
	@Test
	public void testLoginFunction() {
		lp.enterusername("test25@test.com");
		lp.enterpassword("test123");
		lp.clickLoginButton();
	}
	@Test
	public void testLoginInvalidCredentials() {
		lp.enterpassword("test123");
		lp.clickLoginButton();
		String errmsg =lp.getErrMsgText();
		System.out.println(errmsg);
	}
}