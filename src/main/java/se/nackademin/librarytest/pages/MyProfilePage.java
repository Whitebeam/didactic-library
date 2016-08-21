/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nackademin.librarytest.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author Whitebeam
 */
public class MyProfilePage extends MenuPage {
    @FindBy(css = "#gwt-uid-5")
    SelenideElement userNameField;
    @FindBy(css = "#gwt-uid-13")
    SelenideElement userEmailField;
    @FindBy(css = "#edit-user")
    SelenideElement editUserButton;
    @FindBy(css = "td.v-grid-cell:nth-child(1) > a:nth-child(1)")
    SelenideElement firstResultTitle;

    public String getUserName() {
        return userNameField.getText();
    }
    
    public String getUserEmail() {
        return userEmailField.getText();
    }
    
    public void clickEditUserButton() {
        clickButton("edit user button", editUserButton);
    }
    
    public String getFirstResultTitle() {
        return firstResultTitle.getText();
    }
    
    public void clickFirstResultTitle() {
        clickButton("open first book in list", firstResultTitle);
    }
}
