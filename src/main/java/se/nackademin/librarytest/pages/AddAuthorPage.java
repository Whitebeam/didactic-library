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
public class AddAuthorPage extends MenuPage {

    @FindBy(css = "#gwt-uid-7")
    SelenideElement firstName;
    @FindBy(css = "#gwt-uid-9")
    SelenideElement lastName;
    @FindBy(css = "#gwt-uid-3")
    SelenideElement country;
    @FindBy(css = "#gwt-uid-5")
    SelenideElement biography;
    @FindBy(css = "#add-author-button")
    SelenideElement addAuthorButton;

    public void setFirstNameField(String name) {
        setTextFieldValue("author first name field", name, firstName);
    }

    public void setLastNameField(String name) {
        setTextFieldValue("author last name field", name, lastName);
    }
    
    public void setCountryField(String countryName) {
        setTextFieldValue("author country field", countryName, country);
    }
     
    public void setBiographyField(String biography) {
        setTextFieldValue("author biography field", biography, this.biography);
    }
    
    public void clickAddAuthorButton() {
        clickButton("add Author button", addAuthorButton);
    }
}
