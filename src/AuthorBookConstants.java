/**
 * This class exists to hold some constants used by the Book and
 * Author classes.
 *
 * Use these as default values for properties that have not yet been set.
 *
 * NOTE: This class will not compile until you have created the Author
 * class and at least implemented its two argument constructor.
 */
public class AuthorBookConstants {

    /** Value for uninitialized years (birth, death, publication) */
    public static final int UNKNOWN_YEAR = -4567;

    /** Value for uninitialized book title */
    public static final String UNKNOWN_TITLE  = "UNKNOWN TITLE";

    /** Value for unspecified author */
    public static final Author UNKNOWN_AUTHOR = new Author( "UNKNOWN", "AUTHOR" );

    /** Value for unspecified ISBN */
    public static final String UNKNOWN_ISBN = "UNKNOWN ISBN";
}