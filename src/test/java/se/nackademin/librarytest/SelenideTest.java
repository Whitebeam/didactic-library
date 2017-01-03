package se.nackademin.librarytest;

import static com.codeborne.selenide.Selenide.*;

import java.lang.Integer;
import java.util.UUID;
import java.util.Random;

import static org.junit.Assert.*;
import org.junit.Ignore;
import org.junit.Test;

import se.nackademin.librarytest.helpers.BookHelper;
import se.nackademin.librarytest.helpers.Table;
import se.nackademin.librarytest.helpers.UserHelper;
import se.nackademin.librarytest.model.Book;
import se.nackademin.librarytest.pages.AddAuthorPage;
import se.nackademin.librarytest.pages.AddBookPage;
import se.nackademin.librarytest.pages.AddUserPage;
import se.nackademin.librarytest.pages.AuthorPage;
import se.nackademin.librarytest.pages.BookPage;
import se.nackademin.librarytest.pages.BrowseAuthorsPage;
import se.nackademin.librarytest.pages.BrowseBooksPage;
import se.nackademin.librarytest.pages.EditBookPage;
import se.nackademin.librarytest.pages.EditUserPage;
import se.nackademin.librarytest.pages.MenuPage;
import se.nackademin.librarytest.pages.MyProfilePage;
import se.nackademin.librarytest.pages.SignInPage;

public class SelenideTest extends TestBase {

    public SelenideTest() {
    }
    
    private void selenideTestInitialisation() {
        page(MenuPage.class).navigateToSignOut();
    }
            
            
    @Test
    public void testUsingTable() {
        selenideTestInitialisation();
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
        selenideTestInitialisation();
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
        new UserHelper().logOut();        
    }

    @Test
    public void testChangeEmailAddress() {
        selenideTestInitialisation();
        //Skapa en ny användare:
        page(MenuPage.class).navigateToAddUser();
        AddUserPage addUserPage = page(AddUserPage.class);
        String username = "Steven Hassan";
        String password = "letmein";
        String email = "ab@cd.ef";
        addUserPage.setUsername(username);
        addUserPage.setPassword(password);
        addUserPage.clickAddUserButton();
    //Logga in med din nya användare:
        SignInPage signInPage = page(SignInPage.class);
        signInPage.setUsername(username);
        signInPage.setPassword(password);
        signInPage.clickLogIn();
    //Gå in på "My profile":
        page(MenuPage.class).navigateToMyProfile();
        MyProfilePage myProfilePage = page(MyProfilePage.class);
    //Ändra e-mailadressen till en ny adress:
        myProfilePage.clickEditUserButton();
        EditUserPage editUserPage = page(EditUserPage.class);
        editUserPage.setEmail(email);
        editUserPage.clickSaveUserButton();
    //Gå in på "My profile" igen:
        page(MenuPage.class).navigateToMyProfile();
        myProfilePage = page(MyProfilePage.class);
    //Verifiera att e-mailadressen har ändrats:
        assertEquals("Email field in My Page should have been set to " + email, email, myProfilePage.getUserEmail());
        //sleep(4000);
    }
    
    @Test
    public void testChangePublicationDate() {
        selenideTestInitialisation();
        String username = "admin";
        String password = "1234567890";
        String bookTitle = "Good Omens";
        Random rnd = new Random();
        int randomNumber = 1000 + rnd.nextInt(1015);
        String date = randomNumber + "-08-21";
        //String date = "2016-08-21";
        page(MenuPage.class).navigateToSignIn();
    //Logga in som administratör (admin/1234567890):
        SignInPage signInPage = page(SignInPage.class);
        signInPage.setUsername(username);
        signInPage.setPassword(password);
        signInPage.clickLogIn();
    //Navigera till boken "Good Omens" (ex. genom att söka böcker eller författare):
        page(MenuPage.class).navigateToBrowseBooks();
        BrowseBooksPage browseBooksPage = page(BrowseBooksPage.class);
        browseBooksPage.setTitleField(bookTitle);
        browseBooksPage.clickSearchBooksButton();
        browseBooksPage.clickFirstResultTitle();
    //Tryck "Edit book":
        BookPage bookPage = page(BookPage.class);
        bookPage.clickEditBookButton();
    //Ändra publiceringsdatumet till ett nytt datum. Datumet ska följa formatet YYYY-MM-DD och vara ett korrekt datum.:
        EditBookPage editBookPage = page(EditBookPage.class);
        editBookPage.setDateField(date);
        editBookPage.clickSaveBookButton();
    //Navigera till boken och verifiera att publiceringsdatumet har uppdaterats:
        page(MenuPage.class).navigateToBrowseBooks();
        browseBooksPage = page(BrowseBooksPage.class);
        browseBooksPage.setTitleField(bookTitle);
        browseBooksPage.clickSearchBooksButton();
        browseBooksPage.clickFirstResultTitle();
        bookPage = page(BookPage.class);
        assertEquals("testChangePublicationDate: Book date change wasn't saved correctly.", date, bookPage.getPublicationDate());
        new UserHelper().logOut();
    }
    
    @Test
    public void testBorrowingABook() {
        selenideTestInitialisation();
        String username = "James";
        String password = "letmein";
        String email = "gh@ij.kl";
        String bookTitle = "Anansi Boys";
        int initialAvailableCopies = -1;
    //Skapa en ny användare:
        page(MenuPage.class).navigateToAddUser();
        AddUserPage addUserPage = page(AddUserPage.class);
        addUserPage.setUsername(username);
        addUserPage.setPassword(password);
        addUserPage.clickAddUserButton();
        //Logga in som din nya användare:
        SignInPage signInPage = page(SignInPage.class);
        signInPage.setUsername(username);
        signInPage.setPassword(password);
        signInPage.clickLogIn();
    //Navigera till en bok:
        page(MenuPage.class).navigateToBrowseBooks();
        BrowseBooksPage browseBooksPage = page(BrowseBooksPage.class);
        browseBooksPage.setTitleField(bookTitle);
        browseBooksPage.clickSearchBooksButton();
        browseBooksPage.clickFirstResultTitle();
    //Välj "Borrow book" för att låna boken:
        BookPage bookPage = page(BookPage.class);
        try {
            initialAvailableCopies = Integer.parseInt(bookPage.getAvailableCopies());
        } catch (Exception e) {
            fail("testBorrowingABook: The number of copies field content coun't be converted to integer.");
        }
        bookPage.clickBorrowBook();
    //Välj Yes:
        bookPage = page(BookPage.class);
        bookPage.clickConfirmDialogButton();    
    //Verifiera att det nu finns en bok mindre tillgänglig:
        bookPage = page(BookPage.class);
        try {
            Thread.sleep(500); //Behövs visst för att sidan ska hinna laddas.
            assertEquals("Available book copies isn't one less after borrowing.", initialAvailableCopies - 1, Integer.parseInt(bookPage.getAvailableCopies()));
        } catch (Exception e) {
            fail("testBorrowingABook: The number of copies field content coun't be converted to integer.");
        }
    //Navigera till "My Profile":
        page(MenuPage.class).navigateToMyProfile();
        MyProfilePage myProfilePage = page(MyProfilePage.class);
    //Verifiera att den valda boken finns listad:
        assertEquals("testBorrowingABook: Borrowed book isn't available under user page", bookTitle, myProfilePage.getFirstResultTitle());
        myProfilePage.clickFirstResultTitle();
    //Lämna tillbaka boken:
        bookPage = page(BookPage.class);
        bookPage.returnBorrowBook();
        bookPage = page(BookPage.class);
        bookPage.clickConfirmDialogButton();
        sleep(100);
        bookPage = page(BookPage.class);
        try {
            assertEquals("Current book isn't returned after borrowing.", initialAvailableCopies, Integer.parseInt(bookPage.getAvailableCopies()));
        } catch (Exception e) {
            fail("testBorrowingABook: The number of copies field content coun't be converted to integer.");
        }
    }
}
