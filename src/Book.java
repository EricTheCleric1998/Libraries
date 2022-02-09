/**
 * This class will take a books's information, accessing the Author class, and putting it properly to a string.
 * @author Eric Hillmeyer
 */

public class Book {

    private String title = AuthorBookConstants.UNKNOWN_TITLE;
    private String isbn = AuthorBookConstants.UNKNOWN_ISBN;
    private Author author = AuthorBookConstants.UNKNOWN_AUTHOR;
    private int year = AuthorBookConstants.UNKNOWN_YEAR;

    public Book() {
    }

    /**
     * Assigns the global variable title to the title given by the parameter.
     * @param title Title to be assigned
     */
    public Book(String title) {
        this.title = title;
    }

    /**
     * Assigns title and author to the global variables author and title.
     * @param title Title of book to be assigned
     * @param author Name of author to be assigned as given by Author class
     */
    public Book(String title, Author author) {
        this.title = title;
        this.author = author;
    }

    /**
     * Sets the title of the book, checking if it is an empty string in the process.
     * @param title Title of the book
     */
    public void setTitle(String title) {
        if (!title.isEmpty()) {
            this.title = title;
        }
    }

    /**
     * Gets the title of the book.
     * @return The given title of the book
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the author of the book via the Author class.
     * @param author Author given to the book
     */
    public void setAuthor(Author author) {
        this.author = author;
    }

    /**
     * Gets the author as given by the Author class.
     * @return Author given to the book
     */
    public Author getAuthor() {
        return author;
    }

    /**
     * Sets publication year of the book.
     * @param year The year the book was published
     */
    public void setPubYear(int year) {
        if(Author.isValidYear(year)) {
            this.year = year;
        }
    }

    /**
     * Gets the publication year of the book.
     * @return The publication year of the book
     */
    public int getPubYear() {
        return year;
    }

    /**
     * Sets the ISBN of the book, checking if it is either 13 or 10 characters.
     * @param isbn The proper ISBN number of the book
     */
    public void setIntStdBookNum(String isbn) {
        if (isbn.length() == 13 || isbn.length() == 10) {
            this.isbn = isbn;
        }
    }

    /**
     * Gets ISBN of the book.
     * @return ISBN of the book
     */
    public String getIntStdBookNum() {
        return isbn;
    }

    /**
     * Checks if both authors' names are the same.
     * @param other Author of a book to be checked against the first author
     * @return true if authors share a name, false if not
     */
    public boolean hasSameAuthor(Book other) {
        return author.isSame(other.author);
    }

    /**
     * Checks if both ISBNs are the same
     * @param other ISBN of a book to be checked against first ISBN
     * @return true if ISBNs are the same, false if not
     */
    public boolean equals(Book other) {
        return isbn.equals(other.isbn);
    }

    /**
     * Creates a string version of a book's information based on what information was given previously.
     * @return Different strings based on different information given about a particular book
     */
    public String toString() {
        if (year != AuthorBookConstants.UNKNOWN_YEAR && author != AuthorBookConstants.UNKNOWN_AUTHOR
                && title != AuthorBookConstants.UNKNOWN_TITLE) {
            return title + " (" + year + "). " + author + ".";
        } else if (author != AuthorBookConstants.UNKNOWN_AUTHOR && title != AuthorBookConstants.UNKNOWN_TITLE) {
            return title + ". " + author + ".";
        } else if (title != AuthorBookConstants.UNKNOWN_TITLE){
            return title + ".";
        }
        return "";
    }
}
