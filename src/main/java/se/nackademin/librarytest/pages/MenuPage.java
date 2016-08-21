/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nackademin.librarytest.pages;

import com.codeborne.selenide.SelenideElement;

import java.util.logging.Logger;

import org.openqa.selenium.support.FindBy;

/**
 * @author testautomatisering
 */
public class MenuPage extends PageBase {

    private static final Logger LOG = Logger.getLogger(MenuPage.class.getName());
    @FindBy(css = "#side-menu-link-browse-books")
    private SelenideElement browseBooks;
    @FindBy(css = "#side-menu-link-browse-authors")
    private SelenideElement browseAuthors;
    @FindBy(css = "#side-menu-link-add-book")
    private SelenideElement addBook;
    @FindBy(css = "#side-menu-link-add-author")
    private SelenideElement addAuthor;
    @FindBy(css = "#side-menu-link-add-user")
    private SelenideElement addUser;
    @FindBy(css = "#side-menu-link-sign-in")
    private SelenideElement signIn;
    @FindBy(css = "#side-menu-link-sign-out")
    private SelenideElement signOut;
    @FindBy(css = "#side-menu-link-my-profile")
    private SelenideElement myProfile;
    
    public void navigateToBrowseBooks() {
        clickButton("browse books", browseBooks);
    }

     public void navigateToBrowseAuthors() {
        clickButton("browse authors", browseAuthors);
    }

    public void navigateToAddUser() {
        clickButton("add user", addUser);
    }

    public void navigateToSignIn() {
        clickButton("sign in", signIn);
    }

    public void navigateToSignOut() {
        clickButton("sign out", signOut);
    }

    public void navigateToMyProfile() {
        clickButton("my profile", myProfile);
    }
    
    public void navigateToAddBook() {
        clickButton("add book", addBook);
    }
    
    public void navigateToAddAuthor() {
        clickButton("add author", addAuthor);
    }
}
