/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nackademin.librarytest.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author testautomatisering
 */
public class AuthorPage {

    @FindBy(css = "#gwt-uid-3")
    SelenideElement nameField;
    @FindBy(css = "#gwt-uid-5")
    SelenideElement countryField;
    @FindBy(css = "#gwt-uid-7")
    SelenideElement biographyField;

    public String getName() {
        return nameField.getText();
    }

    public String getCountry() {
        return countryField.getText();
    }

    public String getBiography() {
        return biographyField.getText();
    }
}
