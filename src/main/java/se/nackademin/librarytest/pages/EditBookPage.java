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
public class EditBookPage extends MenuPage {

    @FindBy(css = "#gwt-uid-3")
    SelenideElement titleField;
    @FindBy(css = "#gwt-uid-13")
    SelenideElement isbnField;
    @FindBy(css = "#gwt-uid-7")
    SelenideElement dateField;
    @FindBy(css = "#save-book-button")
    SelenideElement saveBookButton;

    public void setTitle(String title) {
        setTextFieldValue("user name field", title, titleField);
    }

    public void setIsbn(String isbn) {
        setTextFieldValue("isbn field", isbn, isbnField);
    }

    public void setDateField(String date) {
        setTextFieldValue("date field", date, dateField);
    }
    
    public void clickSaveBookButton() {
        clickButton("save book button", saveBookButton);
    }
}
