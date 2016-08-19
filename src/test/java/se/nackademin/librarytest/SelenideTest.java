package se.nackademin.librarytest;

import static com.codeborne.selenide.Selenide.*;

import java.util.UUID;

import static org.junit.Assert.*;
import org.junit.Ignore;
import org.junit.Test;

import se.nackademin.librarytest.helpers.BookHelper;
import se.nackademin.librarytest.helpers.Table;
import se.nackademin.librarytest.helpers.UserHelper;
import se.nackademin.librarytest.model.Book;
import se.nackademin.librarytest.pages.AddAuthorPage;
import se.nackademin.librarytest.pages.AddBookPage;
import se.nackademin.librarytest.pages.AuthorPage;
import se.nackademin.librarytest.pages.BookPage;
import se.nackademin.librarytest.pages.BrowseAuthorsPage;
import se.nackademin.librarytest.pages.BrowseBooksPage;
import se.nackademin.librarytest.pages.MenuPage;
import se.nackademin.librarytest.pages.MyProfilePage;
import se.nackademin.librarytest.pages.SignInPage;

public class SelenideTest extends TestBase {

    public SelenideTest() {
    }

    //@Test
    public void testUsingTable() {
        page(MenuPage.class).navigateToBrowseBooks();
        BrowseBooksPage browseBooksPage = page(BrowseBooksPage.class);
        //browseBooksPage.setTitleField("G");
        browseBooksPage.clickSearchBooksButton();
        Table table = new Table($(".v-grid-tablewrapper"));
        System.out.println(table.getColumnCount());
        System.out.println(table.getRowCount());
        System.out.println(table.getCellValue(0, 0));
        System.out.println(table.getCellValue(1, 1));
        table.searchAndClick("American Gods", 0);
        sleep(2000);
    }

    @Test
    public void testCreateNewAuthor() {
        String firstName = "Steven";
        String lastName = "Hassan";
        String fullName = firstName + " " + lastName;
        String  biography = "Steven Alan Hassan (born 1954) is an American licensed mental health counselor who has written on the subject of cults and published three books through his Freedom of Mind Press.";
        String country = "United States of America";
        page(MenuPage.class).navigateToSignIn();
        SignInPage signInPage = page(SignInPage.class);
        signInPage.setUsername("admin");
        signInPage.setPassword("1234567890");
        signInPage.clickLogIn();
        page(MenuPage.class).navigateToAddAuthor();
        AddAuthorPage addAuthorPage = page(AddAuthorPage.class);
        addAuthorPage.setFirstNameField(firstName);
        addAuthorPage.setLastNameField(lastName);
        addAuthorPage.setBiographyField(biography);
        addAuthorPage.setCountryField(country);
        addAuthorPage.clickAddAuthorButton();
        page(MenuPage.class).navigateToBrowseAuthors();
        BrowseAuthorsPage browseAuthorsPage = page(BrowseAuthorsPage.class);
        browseAuthorsPage.setNameField(fullName);
        browseAuthorsPage.clickSearchBooksButton();
        browseAuthorsPage = page(BrowseAuthorsPage.class);
        Table table = new Table($(".v-grid-tablewrapper"));
        table.searchAndClick(fullName, 0);
        AuthorPage authorPage = page(AuthorPage.class);
        assertEquals("The author " + fullName + " should have been visible on the page.", fullName, authorPage.getName());
        assertEquals("The country of the author " + fullName + ":" + country + " should have been visible on the page.", country, authorPage.getCountry());
        assertEquals("The biography of the author " + fullName + ":" + biography + " should have been visible on the page.", biography, authorPage.getBiography());
    }

    @Test
    public void testChangeEmailAddress() {
    }
    
    @Test
    public void testChangePublicationDate() {
    }
    
    @Test
    public void testBorrowingABook() {
    }
}
