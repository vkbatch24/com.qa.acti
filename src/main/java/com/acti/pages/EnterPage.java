package com.acti.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.acti.base.DriverScript;

public class EnterPage extends DriverScript {
	//*********************Locators**************************************
		@FindBy(id = "logoutLink")
		WebElement logoutLink;
		@FindBy(xpath ="//a[@class='userProfileLink username ']")
		WebElement userLoggedIn;
		@FindBy(xpath = "//div[@id='container_tasks']")
		WebElement menuTask;
		@FindBy(xpath = "//div[@id='container_reports']")
		WebElement menuReports;
		@FindBy(xpath = "//div[@id='container_users']")
		WebElement menuUsers;
		

		// ***************** Page Initialization
		public EnterPage() {
			PageFactory.initElements(driver, this);
		}

	//*********************** Page Methods *********************
		public void clickLogout() {
			logoutLink.click();
		}
		public String userLoggedIn() {
			return userLoggedIn.getText();
		}
		public void clickTaskMenu() {
			menuTask.click();
		}
		public void clickReportsMenu() {
			menuReports.click();
		}
		public void clickUsersMenu() {
			menuUsers.click();
		}
}
