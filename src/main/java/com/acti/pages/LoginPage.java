package com.acti.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.acti.base.DriverScript;

public class LoginPage extends DriverScript {

//*********************Locators**************************************
	@FindBy(id = "username")
	WebElement usernameTextbox;
	@FindBy(name = "pwd")
	WebElement passwordTextbox;
	@FindBy(xpath = "//div[text()='Login ']")
	WebElement LoginButton;
	@FindBy(className = "errormsg")
	WebElement errmsgText;
	@FindBy(linkText = "Forgot your password?")
	WebElement forgotpasswordLink;
	@FindBy(xpath = "//div[@class='atLogoImg']")
	WebElement actiImg;

	// ***************** Page Initialization
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

//*********************** Page Methods *********************
	public void enterusername(String username) {
		usernameTextbox.sendKeys(username);

	}

	public void enterpassword(String password) {
		passwordTextbox.sendKeys(password);
	}

	public void clickLoginButton() {
		LoginButton.click();
	}

	public String getErrMsgText() {
		return errmsgText.getText();
	}

	public boolean verifyforgotpasswordLink() {
		return forgotpasswordLink.isDisplayed();
	}

	public boolean verifyactiImg() {
		return actiImg.isDisplayed();
	}

	public String getLoginpageTitle() {
		return driver.getTitle();
	}

}
