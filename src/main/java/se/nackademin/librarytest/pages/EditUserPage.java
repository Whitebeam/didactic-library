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
public class EditUserPage extends MenuPage {

    @FindBy(css = "#gwt-uid-3")
    SelenideElement userNameField;
    @FindBy(css = "#gwt-uid-5")
    SelenideElement passwordField;
    @FindBy(css = "#gwt-uid-13")
    SelenideElement emailField;
    @FindBy(css = "#save-user-button")
    SelenideElement saveUserButton;

    public void setUsername(String username) {
        setTextFieldValue("user name field", username, userNameField);
    }

    public void setPassword(String password) {
        setTextFieldValue("password field", password, passwordField);
    }
    
    public void clearPasswordField() {
        setTextFieldValue("clear password field", "", passwordField);
    }

    public void setEmail(String email) {
        setTextFieldValue("email field", email, emailField);
    }
    /*
    TODO: Implement the following functions:
    public void setFirstName
    public void setLastName
    public void setPhoneNumber
    */

    public void clickSaveUserButton() {
        clickButton("save user button", saveUserButton);
    }
}
