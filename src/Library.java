import org.w3c.dom.ls.LSOutput;

/**
 * A class to sort books into a library to see if they are checked out or in.
 * @author Eric Hillmeyer
 */

public class Library {

    /** Unique books in the library. */
    private Book[] books;

    /** Number of copies for each book. */
    private int[] copies;

    /** Number of copies currently on the shelf (checked in) for each book. */
    private int[] checkedIn;

    /** Number of unique books in the library. */
    private int numBooks;

    /** Construct a new empty Library. */
    public Library(int librarySize) {
        books = new Book[librarySize];
        copies = new int[librarySize];
        checkedIn = new int[librarySize];
        numBooks = 0;
    }

    /**
     * Get the number of total copies of all books that exist in the
     * library.
     * @return Total number of copies in the library.
     */
    public int getTotalCopies() {
        int totalCopies = 0;

        for (int i = 0; i < copies.length; i++) {
            totalCopies += copies[i];
        }

        return totalCopies;
    }

    /**
     * Get the number of copies currently checked out.
     * @return Total number of copies checked out.
     */
    public int getNumCheckedOut() {
        int numCheckedIn = 0;

        for (int i = 0; i < checkedIn.length; i++) {
            numCheckedIn += checkedIn[i];
        }

        // Once we have the getTotalCopies method, we just need to subtract the amount checked in from that to see
        // how many copies are checked out.
        return getTotalCopies() - numCheckedIn;
    }

    /**
     * Get a String representing the status of the library.
     * @return Status string.
     */
    public String getStatus() {
        return "Total unique books: " + numBooks + "\n" +
                "Total number of copies: " + getTotalCopies() + "\n" +
                "Total checked out: " + getNumCheckedOut();
    }

    /**
     * Add a single book to the library, on the shelf.
     *
     * If the book is already present, adds another copy.
     * If the book is new, add it after the existing books.
     * @param b Book to add.
     */
    public void addBook(Book b) {
        for (int i = 0; i < books.length; i++) {
            // This if (books[i] == null) is used often in this code to make sure the index accessed can be used.
            if (books[i] == null) {
                // Need to add the book to the array, then increase the amount of books in other variables by 1.
                books[i] = b;
                checkedIn[i]++;
                copies[i]++;
                numBooks++;
                break;
            } else if (books[i].equals(b)) {
                copies[i]++;
                checkedIn[i]++;
                break;
            }
        }
    }

    /**
     * Add all the books in the array to the library. Adds one copy of
     * each book.
     * @param newBooks Books to add.
     */
    public void addBooks(Book[] newBooks) {
        // This for loop does uses addBook to add multiple books one at a time.
        for (int i = 0; i < newBooks.length; i++) {
            addBook(newBooks[i]);
        }
    }

    /**
     * Checks out a book from the library if possible.
     * @param b Book to check out.
     * @return String denoting success or failure.
     */
    public String checkOut (Book b) {
        int indexNeeded = 0;
        boolean bookFound = false;

        for (int i = 0; i < books.length; i++) {
            if (books[i] != null && books[i].equals(b)) {
                indexNeeded = i;
                bookFound = true;
                break;
            }
        }

        if (bookFound && checkedIn[indexNeeded] != 0) {
            checkedIn[indexNeeded]--;
            return "Checked out!";
        } else if (bookFound && checkedIn[indexNeeded] == 0) {
            return "All out of copies.";
        }

        return "Book not found.";
    }

    /**
     * Checks in a book to the library if possible.
     * @param b Book to check in.
     * @return String denoting success or failure.
     */
    public String checkIn (Book b) {
        int indexNeeded = 0;
        boolean bookFound = false;

        for (int i = 0; i < books.length; i++) {
            if (books[i] != null && books[i].equals(b)) {
                indexNeeded = i;
                bookFound = true;
                break;
            }
        }

        if (bookFound && checkedIn[indexNeeded] == copies[indexNeeded]) {
            return "All of our copies are already checked in.";
        } else if (bookFound && checkedIn[indexNeeded] < copies[indexNeeded]) {
            checkedIn[indexNeeded]++;
            return "Checked in!";
        }

        return "Book not found.";
    }

    /**
     * Get string representation of entire library collection and status.
     * @return String representation of library.
     */
    public String toString() {
        String libraryStatus = "";

        for (int i = 0; i < checkedIn.length; i++) {
            if (books[i] != null) {
                // We only need to use a few array variables and access them at i to format the output properly.
                libraryStatus += i + ". " + books[i].toString() + " : " + checkedIn[i] + "/" + copies[i] + "\n";
            }
        }

        // Need a newline character before we try to use getStatus() for formatting purposes
        libraryStatus += "\n" + getStatus();

        return libraryStatus;
    }

    /**
     * Get number of unique books that exist for a given author.
     * @param a The author to check.
     * @return Number of books by the author.
     */
    public int numBooksByAuthor(Author a) {
        int titlesByAuthor = 0;

        for (int i = 0; i < books.length; i++) {
            if(books[i] != null) {
                // Though we are using the Author class, we can't use anything from it because books only accesses
                // the Book class, so we use the getAuthor method from Book.
                if (books[i].getAuthor().isSame(a)) {
                    titlesByAuthor++;
                }
            }
        }

        return titlesByAuthor;
    }

    /**
     * Returns a String that lists the unique books which exist for a
     * given author, in standard book format, with a newline after
     * each.  If no books are found for the author, returns string
     * that says so.
     *
     * @param a The author in question.
     * @return String listing books by the author.
     */
    public String listBooksByAuthor(Author a) {
        String listToString = "";

        for (int i = 0; i < books.length; i++) {
            if (books[i] != null) {
                String bookToCheck = books[i].getAuthor().toString();

                //For sake of comparison, I needed to make all strings completely lowercase
                if (bookToCheck.toLowerCase().contains(a.toString().toLowerCase())) {
                    listToString += books[i].getTitle() + ". " + books[i].getAuthor() + ".\n";
                }
            }
        }

        // This if statement checks if listToString has been updated at all after the for loop is done looping.
        if (listToString.equals("")) {
            listToString = "No books by " + a + ".";
        }

        return listToString;
    }

    /**
     * Returns string that lists the unique books with contain the
     * given string within their titles, without regard for case, with
     * a newline after each.  If no books are found containing the
     * string, returns string that says so.
     * @param s The string to look for in the titles.
     * @return String listing books that contain given string in titles.
     */
    public String listBooksByTitle(String s) {
        String listToString = "";

        for (int i = 0; i < books.length; i++) {
            if (books[i] != null) {
                String bookToCheck = books[i].getTitle();

                // Same as before, need to make everything lowercase to do a proper comparison.
                if (bookToCheck.toLowerCase().contains(s.toLowerCase())) {
                    listToString += bookToCheck + ". " + books[i].getAuthor() + ".\n";
                }
            }
        }

        // Again, same as before, just need to check if listToString has been updated.
        if (listToString.equals("")) {
            listToString = "No books with \"" + s + "\" in the title.";
        }

        return listToString;
    }

    /**
     * Deletes book entirely from the library.
     * @param b Book to remove.
     * @return String denoting success or failure.
     */
    // This method only sort of works, though I do not know where I am going wrong. Since this method is bonus points,
    // I decided to leave it where it was. I don't know if I will get any points from it or not.
    public String deleteBook(Book b) {
        // Do not need boolean because if indexOfBook is greater than -1 after for loop, we have found an index.
        int indexOfBook = -1;
        boolean didDelete = false;

        for (int i = 0; i < books.length; i++) {
            if (books[i] != null) {
                if (books[i].equals(b)) {
                    indexOfBook = i;
                }
            }
        }

        for (int k = 0; k < books.length; k++) {
            if (k == indexOfBook) {
                // This for loop iterates over books, replacing every index with the one ahead of it.
                for (int l = indexOfBook; l < books.length - 1; l++) {
                    books[l] = books[l + 1];
                    didDelete = true;
                    break;
                }
            }
        }

        if (didDelete) {
            return "Book removed.";
        }

        // I think this is the only return that is actually working.
        return "Book not found.";
    }
}