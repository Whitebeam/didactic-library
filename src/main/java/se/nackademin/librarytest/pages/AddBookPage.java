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
public class AddBookPage extends MenuPage {

    @FindBy(css = "#gwt-uid-3")
    SelenideElement bookTitle;
    @FindBy(css = "#gwt-uid-9")
    SelenideElement descriptionField;
    @FindBy(css = "#gwt-uid-11")
    SelenideElement pageNumber;
    @FindBy(css = "#gwt-uid-13")
    SelenideElement pageIsbn;
    @FindBy(css = "#gwt-uid-7")
    SelenideElement datePublished;
    @FindBy(css = "#add-book-button")
    SelenideElement addBookButton;

    public void setTitle(String title) {
        setTextFieldValue("book title field", title, bookTitle);
    }

    public void setDescriptionField(String description) {
        setTextFieldValue("book description field", description, descriptionField);
    }
    
    public void setPageNumber(String pageNumber) {
        setTextFieldValue("book page number field", pageNumber, this.pageNumber);
    }
     
    public void setIsbn(String isbn) {
        setTextFieldValue("isbn field", isbn, pageIsbn);
    }
    
    public void setDatePublished(String date) {
        setTextFieldValue("publication date field", date, datePublished);
    }
    
    /* TODO: Add the following functions:
    public void selectAuthor(String name)
    public void deselectAuthor(String name)
    */
    
    public void clickAddBookButton() {
        clickButton("add book button", addBookButton);
    }
}
