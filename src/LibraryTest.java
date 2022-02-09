public class LibraryTest {

    public static void main(String[] args) {
        Library library = new Library(400);
        int score = 0;
        int tScore = 0;

        System.out.println( "Let's calculate some facts about the library..." );

        if( library.getTotalCopies() == 0 ) { tScore++; }
        System.out.println( " - getTotalCopies works for empty library: " + tScore + "/1" );
        score += tScore; tScore = 0;

        if( library.getNumCheckedOut() == 0 ) { tScore++; }
        System.out.println( " - getNumCheckedOut works for empty library: " + tScore + "/1" );
        score += tScore; tScore = 0;

        if( library.getStatus().equals( "Total unique books: 0\n"+
                                        "Total number of copies: 0\n"+
                                        "Total checked out: 0" ) ) { tScore++; }
        System.out.println( " - getStatus  works for empty library: " + tScore + "/1\n" );
        score += tScore; tScore = 0;

        Book[] libraryBooks = new Book[26];
        libraryBooks[0]  = new Book( "Ulysses", new Author("James","Joyce") );
        libraryBooks[1]  = new Book( "The Great Gatsby", new Author("F. Scott","Fitzgerald") );
        libraryBooks[2]  = new Book( "A Portrait of the Artist as a Young Man", new Author("James","Joyce") );
        libraryBooks[3]  = new Book( "Lolita", new Author("Vladimir","Nobokov") );
        libraryBooks[4]  = new Book( "Brave New World", new Author("Aldous","Huxley") );
        libraryBooks[5]  = new Book( "The Sound and the Fury", new Author("William","Faulkner") );
        libraryBooks[6]  = new Book( "Catch-22", new Author("Joseph","Heller") );
        libraryBooks[7]  = new Book( "Darkness at Noon", new Author("Arthur","Koestler") );
        libraryBooks[8]  = new Book( "Sons and Lovers", new Author("D.H.","Lawrence") );
        libraryBooks[9]  = new Book( "The Grapes of Wrath", new Author("John","Steinbeck") );
        libraryBooks[10] = new Book( "Under the Volcano", new Author("Malcolm","Lowry") );
        libraryBooks[11] = new Book( "The Way of All Flesh", new Author("Samuel","Butler") );
        libraryBooks[12] = new Book( "1984", new Author("George","Orwell") );
        libraryBooks[13] = new Book( "I, Claudius", new Author("Robert","Graves") );
        libraryBooks[14] = new Book( "To The Lighthouse", new Author("Virginia","Woolf") );
        libraryBooks[15] = new Book( "An American Tragedy", new Author("Theodore","Dreiser") );
        libraryBooks[16] = new Book( "The Heart is a Lonely Hunter", new Author("Carson","McCullers") );
        libraryBooks[17] = new Book( "Slaughterhouse-Five", new Author("Kurt","Vonnegut") );
        libraryBooks[18] = new Book( "Invisible Man", new Author("Ralph","Ellison") );
        libraryBooks[19] = new Book( "Native Son", new Author("Richard","Wright") );
        libraryBooks[20] = new Book( "Henderson the Rain King", new Author("Saul","Bellow") );
        libraryBooks[21] = new Book( "Appointment in Samarra", new Author("John","O'Hara") );
        libraryBooks[22] = new Book( "U.S.A.", new Author("John","Dos Passos") );
        libraryBooks[23] = new Book( "Winesburg, Ohio", new Author("Sherwood","Anderson") );
        libraryBooks[24] = new Book( "A Passage to India", new Author("E.M.","Forster") );
        libraryBooks[25] = new Book( "The Wings of the Dove", new Author("Henry","James") );

        libraryBooks[0].setIntStdBookNum( "9781840226355" );
        libraryBooks[1].setIntStdBookNum( "9780743273565" );
        libraryBooks[2].setIntStdBookNum( "9780486280509" );
        libraryBooks[3].setIntStdBookNum( "9780679723165" );
        libraryBooks[4].setIntStdBookNum( "9780060850524" );
        libraryBooks[5].setIntStdBookNum( "9780679732242" );
        libraryBooks[6].setIntStdBookNum( "9781451626650" );
        libraryBooks[7].setIntStdBookNum( "9781416540267" );
        libraryBooks[8].setIntStdBookNum( "9781853260476" );
        libraryBooks[9].setIntStdBookNum( "9780143039433" );
        libraryBooks[10].setIntStdBookNum( "9780061120152" );
        libraryBooks[11].setIntStdBookNum( "9781613824238" );
        libraryBooks[12].setIntStdBookNum( "9780451524935" );
        libraryBooks[13].setIntStdBookNum( "9780679724773" );
        libraryBooks[14].setIntStdBookNum( "9781907523588" );
        libraryBooks[15].setIntStdBookNum( "9780451531551" );
        libraryBooks[16].setIntStdBookNum( "9780618526413" );
        libraryBooks[17].setIntStdBookNum( "9780385333849" );
        libraryBooks[18].setIntStdBookNum( "9780679732761" );
        libraryBooks[19].setIntStdBookNum( "9780060929800" );
        libraryBooks[20].setIntStdBookNum( "9780143105480" );
        libraryBooks[21].setIntStdBookNum( "9780143107071" );
        libraryBooks[22].setIntStdBookNum( "9781883011147" );
        libraryBooks[23].setIntStdBookNum( "9781613823347" );
        libraryBooks[24].setIntStdBookNum( "9780156711425" );
        libraryBooks[25].setIntStdBookNum( "9780141441283" );

        library.addBooks( libraryBooks );



        System.out.println( "Let's add a set of books, and add more books..." );

        if( library.getTotalCopies() == 26 ) { tScore+=1; }
        System.out.println( " - addBooks seems to work: " + tScore + "/1" );
        score += tScore; tScore = 0;

        // Make a duplicate book object to make sure it is added properly
        Book dupBook = new Book( "To The Lighthouse", new Author("Virginia","Woolf") );
        dupBook.setIntStdBookNum( "9781907523588" );


        library.addBook( libraryBooks[25] );
        library.addBook( libraryBooks[25] );
        library.addBook( libraryBooks[25] );
        library.addBook( libraryBooks[14] );
        library.addBook( libraryBooks[14] );
        library.addBook( dupBook );
        library.addBook( libraryBooks[1] );
        library.addBook( libraryBooks[2] );
        library.addBook( libraryBooks[5] );
        library.addBook( libraryBooks[9] );
        library.addBook( libraryBooks[12] );
        library.addBook( libraryBooks[15] );
        library.addBook( libraryBooks[20] );
        library.addBook( dupBook );

        if( library.getTotalCopies() == 40 ) { tScore+=1; }
        System.out.println( " - addBook seems to work for duplicates: " + tScore + "/1" );
        score += tScore; tScore = 0;

        Book b1 = new Book( "The Luminaries", new Author( "Eleanor", "Catton" ) );
        b1.setIntStdBookNum( "9780316074315" );
        Book b2 = new Book( "The Circle", new Author( "Dave", "Eggers" ) );
        b2.setIntStdBookNum( "9780385351393" );
        Book b3 = new Book( "S.", new Author( "J.J.", "Abrams" ) );
        b3.setIntStdBookNum( "9780316201643" );

        library.addBook( b1 );
        library.addBook( b2 );

        if( library.getTotalCopies() == 42 ) { tScore+=1; }
        System.out.println( " - addBook seems to work for new books: " + tScore + "/1" );
        score += tScore; tScore = 0;

        Book [] moreBooks = new Book[3];
        moreBooks[0]  = new Book( "Pitch Dark", new Author("Renata","Adler") );
        moreBooks[1]  = new Book( "Speedboat", new Author("Renata","Adler") );
        moreBooks[2]  = new Book( "Dissident Gardens", new Author("Jonathan","Lethem") );
        moreBooks[0].setIntStdBookNum( "9781590176146" );
        moreBooks[1].setIntStdBookNum( "9781590176139" );
        moreBooks[2].setIntStdBookNum( "9780385534932" );

        library.addBooks( moreBooks );

        if( library.getTotalCopies() == 45 ) { tScore+=1; }
        System.out.println( " - addBooks works with non-empty libraries: " + tScore + "/1" );
        score += tScore; tScore = 0;

        if( library.getStatus().equals( "Total unique books: 31\n"+
                                        "Total number of copies: 45\n"+
                                        "Total checked out: 0" ) ) { tScore++; }
        System.out.println( " - getStatus works after adding books: " + tScore + "/1\n" );
        score += tScore; tScore = 0;

        System.out.println( "Let's try checking out books..." );

        if( library.checkOut( b1 ).equals( "Checked out!" )  ) { tScore+=1; }
        System.out.println( " - checkOut works when a book can be checked out: " + tScore + "/1" );
        score += tScore; tScore = 0;
        if( library.checkOut( b1 ).equals( "All out of copies." )  ) { tScore+=1; }
        System.out.println( " - checkOut works when a book is out of copies: " + tScore + "/1" );
        score += tScore; tScore = 0;
        if( library.checkOut( b3 ).equals( "Book not found." ) ) { tScore+=1; }
        System.out.println( " - checkOut works when a book is not in the library: " + tScore + "/1" );
        score += tScore; tScore = 0;
        if( library.getStatus().equals( "Total unique books: 31\n"+
                                        "Total number of copies: 45\n"+
                                        "Total checked out: 1" ) ) { tScore+=1; }
        System.out.println( " - getStatus works after checking out books: " + tScore + "/1\n" );
        score += tScore; tScore = 0;

        System.out.println( "Let's try returning books..." );

        if( library.checkIn( b3 ).equals( "Book not found." ) ) { tScore+=1; }
        System.out.println( " - checkIn works when a book is not in the library: " + tScore + "/1" );
        score += tScore; tScore = 0;
        if( library.checkIn( b2 ).equals( "All of our copies are already checked in." )  ) { tScore+=1; }
        System.out.println( " - checkIn works when a book is not checked out: " + tScore + "/1" );
        score += tScore; tScore = 0;
        if( library.checkIn( b1 ).equals( "Checked in!" )  ) { tScore+=1; }
        System.out.println( " - checkIn works when a book is checked back in: " + tScore + "/1" );
        score += tScore; tScore = 0;
        if( library.getStatus().equals( "Total unique books: 31\n"+
                                        "Total number of copies: 45\n"+
                                        "Total checked out: 0" ) ) { tScore+=1; }
        System.out.println( " - getStatus works after checking out books: " + tScore + "/1\n" );
        score += tScore; tScore = 0;

        library.checkOut( b1 );
        library.checkOut( b2 );
        library.checkOut( libraryBooks[25] );
        library.checkOut( libraryBooks[25] );

        System.out.println( "Let's try to print the whole library..." );

        if( library.toString().equals("0. Ulysses. Joyce, James. : 1/1\n"+
                                      "1. The Great Gatsby. Fitzgerald, F. Scott. : 2/2\n"+
                                      "2. A Portrait of the Artist as a Young Man. Joyce, James. : 2/2\n"+
                                      "3. Lolita. Nobokov, Vladimir. : 1/1\n"+
                                      "4. Brave New World. Huxley, Aldous. : 1/1\n"+
                                      "5. The Sound and the Fury. Faulkner, William. : 2/2\n"+
                                      "6. Catch-22. Heller, Joseph. : 1/1\n"+
                                      "7. Darkness at Noon. Koestler, Arthur. : 1/1\n"+
                                      "8. Sons and Lovers. Lawrence, D.H.. : 1/1\n"+
                                      "9. The Grapes of Wrath. Steinbeck, John. : 2/2\n"+
                                      "10. Under the Volcano. Lowry, Malcolm. : 1/1\n"+
                                      "11. The Way of All Flesh. Butler, Samuel. : 1/1\n"+
                                      "12. 1984. Orwell, George. : 2/2\n"+
                                      "13. I, Claudius. Graves, Robert. : 1/1\n"+
                                      "14. To The Lighthouse. Woolf, Virginia. : 5/5\n"+
                                      "15. An American Tragedy. Dreiser, Theodore. : 2/2\n"+
                                      "16. The Heart is a Lonely Hunter. McCullers, Carson. : 1/1\n"+
                                      "17. Slaughterhouse-Five. Vonnegut, Kurt. : 1/1\n"+
                                      "18. Invisible Man. Ellison, Ralph. : 1/1\n"+
                                      "19. Native Son. Wright, Richard. : 1/1\n"+
                                      "20. Henderson the Rain King. Bellow, Saul. : 2/2\n"+
                                      "21. Appointment in Samarra. O'Hara, John. : 1/1\n"+
                                      "22. U.S.A.. Dos Passos, John. : 1/1\n"+
                                      "23. Winesburg, Ohio. Anderson, Sherwood. : 1/1\n"+
                                      "24. A Passage to India. Forster, E.M.. : 1/1\n"+
                                      "25. The Wings of the Dove. James, Henry. : 2/4\n"+
                                      "26. The Luminaries. Catton, Eleanor. : 0/1\n"+
                                      "27. The Circle. Eggers, Dave. : 0/1\n"+
                                      "28. Pitch Dark. Adler, Renata. : 1/1\n"+
                                      "29. Speedboat. Adler, Renata. : 1/1\n"+
                                      "30. Dissident Gardens. Lethem, Jonathan. : 1/1\n\n"+
                                      "Total unique books: 31\n"+
                                      "Total number of copies: 45\n"+
                                      "Total checked out: 4"
                                      ) ) {
            tScore+=2;
        }
        System.out.println( " - toString works: " + tScore + "/2\n" );
        score += tScore; tScore = 0;

        System.out.println( "Let's ask the library some questions..." );

        if( library.numBooksByAuthor( new Author( "Dave","Eggers" )) == 1 ) { tScore++; }
        if( library.numBooksByAuthor( new Author( "Renata","Adler" )) == 2 ) { tScore++; }
        if( library.numBooksByAuthor( new Author( "J.G.","Ballard" )) == 0 ) { tScore++; }
        if( library.numBooksByAuthor( new Author( "James", "Joyce" )) == 2 ) { tScore++; }
        System.out.println( " - numBooksByAuthor works: " + tScore + "/4" );
        score += tScore; tScore = 0;

        if( library.listBooksByAuthor( new Author( "Dave","Eggers" )).equals("The Circle. Eggers, Dave.\n") ) {
            tScore++;
        }
        if( library.listBooksByAuthor( new Author( "Renata","Adler" )).equals("Pitch Dark. Adler, Renata.\n"+
                                                                              "Speedboat. Adler, Renata.\n") ) {
            tScore++;
        }
        if( library.listBooksByAuthor( new Author( "J.G.","Ballard" )).equals("No books by Ballard, J.G..") ) {
            tScore++;
        }
        if( library.listBooksByAuthor( new Author( "James", "Joyce" )).equals("Ulysses. Joyce, James.\n"+
                                                                              "A Portrait of the Artist as a Young Man. Joyce, James.\n") ) {
            tScore++;
        }
        System.out.println( " - listBooksByAuthor works: " + tScore + "/4" );
        score += tScore; tScore = 0;

        if( library.listBooksByTitle( "the" ).equals("The Great Gatsby. Fitzgerald, F. Scott.\n"+
                                                     "A Portrait of the Artist as a Young Man. Joyce, James.\n"+
                                                     "The Sound and the Fury. Faulkner, William.\n"+
                                                     "The Grapes of Wrath. Steinbeck, John.\n"+
                                                     "Under the Volcano. Lowry, Malcolm.\n"+
                                                     "The Way of All Flesh. Butler, Samuel.\n"+
                                                     "To The Lighthouse. Woolf, Virginia.\n"+
                                                     "The Heart is a Lonely Hunter. McCullers, Carson.\n"+
                                                     "Henderson the Rain King. Bellow, Saul.\n"+
                                                     "The Wings of the Dove. James, Henry.\n"+
                                                     "The Luminaries. Catton, Eleanor.\n"+
                                                     "The Circle. Eggers, Dave.\n") ) { tScore++; }
        if( library.listBooksByTitle( "of" ).equals("A Portrait of the Artist as a Young Man. Joyce, James.\n"+
                                                    "The Grapes of Wrath. Steinbeck, John.\n"+
                                                    "The Way of All Flesh. Butler, Samuel.\n"+
                                                    "The Wings of the Dove. James, Henry.\n") ) { tScore++; }
        if( library.listBooksByTitle( "gatsby" ).equals("The Great Gatsby. Fitzgerald, F. Scott.\n") ) { tScore++; }
        if( library.listBooksByTitle( "cloud atlas" ).equals("No books with \"cloud atlas\" in the title.") ) { tScore++; }
        System.out.println( " - listBooksByTitle works: " + tScore + "/4\n" );
        score += tScore; tScore = 0;

        System.out.println( "Bonus! Let's remove a book from the library forever..." );

        if( library.deleteBook( b1 ).equals( "Book removed." ) ) { tScore+=1; }
        if( library.deleteBook( b3 ).equals( "Book not found." ) ) { tScore+=1; }
        if( library.getStatus().equals( "Total unique books: 30\n"+
                                        "Total number of copies: 44\n"+
                                        "Total checked out: 3" ) ) { tScore+=1; }
        library.checkOut( libraryBooks[1] );
        if( library.toString().equals("0. Ulysses. Joyce, James. : 1/1\n"+
                                      "1. The Great Gatsby. Fitzgerald, F. Scott. : 1/2\n"+
                                      "2. A Portrait of the Artist as a Young Man. Joyce, James. : 2/2\n"+
                                      "3. Lolita. Nobokov, Vladimir. : 1/1\n"+
                                      "4. Brave New World. Huxley, Aldous. : 1/1\n"+
                                      "5. The Sound and the Fury. Faulkner, William. : 2/2\n"+
                                      "6. Catch-22. Heller, Joseph. : 1/1\n"+
                                      "7. Darkness at Noon. Koestler, Arthur. : 1/1\n"+
                                      "8. Sons and Lovers. Lawrence, D.H.. : 1/1\n"+
                                      "9. The Grapes of Wrath. Steinbeck, John. : 2/2\n"+
                                      "10. Under the Volcano. Lowry, Malcolm. : 1/1\n"+
                                      "11. The Way of All Flesh. Butler, Samuel. : 1/1\n"+
                                      "12. 1984. Orwell, George. : 2/2\n"+
                                      "13. I, Claudius. Graves, Robert. : 1/1\n"+
                                      "14. To The Lighthouse. Woolf, Virginia. : 5/5\n"+
                                      "15. An American Tragedy. Dreiser, Theodore. : 2/2\n"+
                                      "16. The Heart is a Lonely Hunter. McCullers, Carson. : 1/1\n"+
                                      "17. Slaughterhouse-Five. Vonnegut, Kurt. : 1/1\n"+
                                      "18. Invisible Man. Ellison, Ralph. : 1/1\n"+
                                      "19. Native Son. Wright, Richard. : 1/1\n"+
                                      "20. Henderson the Rain King. Bellow, Saul. : 2/2\n"+
                                      "21. Appointment in Samarra. O'Hara, John. : 1/1\n"+
                                      "22. U.S.A.. Dos Passos, John. : 1/1\n"+
                                      "23. Winesburg, Ohio. Anderson, Sherwood. : 1/1\n"+
                                      "24. A Passage to India. Forster, E.M.. : 1/1\n"+
                                      "25. The Wings of the Dove. James, Henry. : 2/4\n"+
                                      "26. The Circle. Eggers, Dave. : 0/1\n"+
                                      "27. Pitch Dark. Adler, Renata. : 1/1\n"+
                                      "28. Speedboat. Adler, Renata. : 1/1\n"+
                                      "29. Dissident Gardens. Lethem, Jonathan. : 1/1\n\n"+
                                      "Total unique books: 30\n"+
                                      "Total number of copies: 44\n"+
                                      "Total checked out: 4"
                                      ) ) {
            tScore+=2;
        }

        System.out.println( " - book deletion: " + tScore + "/5\n" );
        score += tScore; tScore = 0;

        System.out.println( "Total score: " + score + "/30  \n   (can be up to 35 with bonus)" );

    }
}