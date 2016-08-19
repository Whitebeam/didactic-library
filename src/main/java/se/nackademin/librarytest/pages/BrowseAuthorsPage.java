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
public class BrowseAuthorsPage {
    @FindBy(css = "#gwt-uid-3")
    private SelenideElement nameField;
    @FindBy(css = "#gwt-uid-5")
    private SelenideElement countryField;

    @FindBy(css = "#search-authors-button")
    private SelenideElement searchAuthorsButton;
    
    @FindBy(css = "td.v-grid-cell:nth-child(1) > a:nth-child(1)")
    private SelenideElement firstResultTitle;

    public void clickFirstResultTitle() {
        firstResultTitle.click();
    }

    public void setNameField(String name) {
        nameField.clear();
        nameField.sendKeys(name);
    }

    public void setCountryField(String country) {
        nameField.clear();
        nameField.sendKeys(country);
    }
    
    public void clickSearchBooksButton() {
        searchAuthorsButton.click();
    }
}
