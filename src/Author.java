/**
 * This class will take an author's information and put it properly to a string.
 * @author Eric Hillmeyer
 */

public class Author {

    private final String givenName;
    private final String surname;
    private int birth = AuthorBookConstants.UNKNOWN_YEAR;
    private int death = AuthorBookConstants.UNKNOWN_YEAR;

    /**
     * Takes in both first and last names and assigns them to the givenName and surname variables.
     * @param givenName The author's first name
     * @param surname The author's last name
     */
    public Author (String givenName, String surname) {
        this.givenName = givenName;
        this.surname = surname;
    }

    /**
     * Gets author's birthyear.
     * @return The author's birthyear
     */
    public int getBirthYear() {
        return this.birth;
    }

    /**
     * Gets author's year of death.
     * @return The author's year of death
     */
    public int getDeathYear() {
        return this.death;
    }

    /**
     * Takes birthyear, checks if it is a valid year, then sets it to the variable birth.
     * @param birth The author's birthyear
     */
    public void setLifeRange(int birth) {
        if (isValidYear(birth)) {
            this.birth = birth;
        }
    }

    /**
     * Takes birthyear and year of death, checks if they are valid years, then sets them to the variables
     * death and birth.
     * @param birth The author's birthyear
     * @param death The author's year of death
     */
    public void setLifeRange(int birth, int death) {
        if (isValidYear(birth)) {
            this.birth = birth;
        }

        if (death >= birth && isValidYear(death)) {
            this.death = death;
        }
    }

    /**
     * Takes in a second author's name and compares the first and second to see if they are the same.
     * @param other A second author that will be compared to the first
     * @return true if both authors' names match and false if not
     */
    public boolean isSame(Author other) {
        // This is the check for the bonus points part of the assignment. It checks first if the surnames match.
        // Then, it checks if the first letters of the names match. Finally, it checks of either name is just 1 letter
        // long. If all of this is true, and things match properly, returns true. The overall program runs properly
        // without this if statement.
        if (surname.equals(other.surname) && givenName.charAt(0) == other.givenName.charAt(0)
                && (givenName.length() == 1 || other.givenName.length() == 1)){
                return true;
        }

        // The simplified version of the above if statement. This will check if the two authors are the same without
        // other parameters restricting the check.
        if (givenName.equals(other.givenName) && surname.equals(other.surname)) {
            return true;
        }

        return false;
    }

    /**
     * Formatting the basic string version of the author's name into surname, first name.
     * @return The properly formatted string version of the author.
     */
    public String toString() {
        return surname + ", " + givenName;
    }

    /**
     * Checks if birth and death have been set. If so, returns string 1. If only birth has been set, returns string 2.
     * If neither have been set, return the basic form of the toString() method.
     * @return Different strings based off of different parameters
     */
    public String getLongString() {
        if (birth != AuthorBookConstants.UNKNOWN_YEAR && death != AuthorBookConstants.UNKNOWN_YEAR) {
            return toString() + " (" + birth + "-" + death + ")";
        } else if (birth != AuthorBookConstants.UNKNOWN_YEAR) {
            return toString() + " (born " + birth + ")";
        }
        return toString();
    }

    /**
     * Takes the year and makes sure it is non zero, later than -2000, and earlier than 2024.
     * @param year Year to be checked.
     * @return true if it is a valid year, false if not
     */
    public static boolean isValidYear(int year) {
        boolean isValid = true;
        if (year == 0) {
            isValid = false;
        } else if(year <= -2000) {
            isValid = false;
        } else if(year >= 2024) {
            isValid = false;
        }

        return isValid;
    }
}
