import java.util.ListResourceBundle;
/**
 * This class contains the words that need translation in greek.
 * @author Maria Eskioglou 3237
 */
public class Languages_Ελληνικά extends ListResourceBundle {
    /**
     * Returns the contents of the matrix with the translations.
     * @return τον πίνακα.
     */
    @Override
    public Object[][] getContents() {
        return contents;
    }

    private final Object[][] contents = {
            {"Menu", "Μενού"},
            {"Sign In","Σύνδεση"},
            {"Sign Up", "Εγγραφή"},
            {"Anonymous","Ανώνυμα"},
            {"Sudoku Game","Παιχνίδι"},
            {"Solve","Λύση"},
            {"Save","Αποθήκευση"},
            {"Hint","Βοήθεια"},
            {"New Game","Νέο Παιχνίδι"},
            {"Load Game","Φόρτωση Παιχνιδιού"},
            {"Statistics","Στατιστικά"},
            {"Return","Επιστροφή"},
            {"Error","Λάθος"},
            {"Message","Μήνυμα"},
            {"Value could not be set","Δεν είναι αποδεκτή τιμή."},
            {"1 is acceptable \n","Το 1 είναι αποδεκτό \n"},
            {"2 is acceptable \n","Το 2 είναι αποδεκτό \n"},
            {"3 is acceptable \n","Το 3 είναι αποδεκτό \n"},
            {"4 is acceptable \n","Το 4 είναι αποδεκτό \n"},
            {"5 is acceptable \n","Το 5 είναι αποδεκτό \n"},
            {"6 is acceptable \n","Το 6 είναι αποδεκτό \n"},
            {"7 is acceptable \n","Το 7 είναι αποδεκτό \n"},
            {"8 is acceptable \n","Το 8 είναι αποδεκτό \n"},
            {"9 is acceptable \n","Το 9 είναι αποδεκτό \n"},
            {"Value set","Αποδεκτή Τιμή"},
            {"Error:Please enter number from 1 to 9","Λάθος: Παρακαλώ δώσε έναν αριθμό από το 1 ως το 9"},
            {"Error:Please enter number from 1 to 4","Λάθος: Παρακαλώ δώσε έναν αριθμό από το 1 ως το 4"},
            {"You lost the game!","Έχασες το παιχνίδι."},
            {"You won the game!","Κέρδισες το παιχνίδι."},
            {"Congratulations","Συγχαρητήρια!"},
            {"'s Statistics"," Στατιστικά"},
            {"Try Again","Προσπάθησε ξανά"},
            {"Row: ","Γραμμή"},
            {"Register","Εγγραφή"},
            {"Registration","Εγγραφή"},
            {"Column: ","Στήλη"},
            {"OK","Εντάξει"},
            {"Acceptable Numbers","Αποδεκτοί Αριθμοί"},
            {"Confirmation","Επιβεβαίωση"},
            {"Please confirm your username:","Παρακαλώ επιβεβαίωσε το όνομα χρήστη: "},
            {"Submit",""},
            {"'s Statistics","'s Statistics"},
            {"Registration Page","Φόρμα Εγγραφής"},
            {"Username:","Όνομα:"},
            {"Password:","Κωδικός:"},
            {"Killer Game","Παιχνίδι Killer"},
            {"Sudoku Game","Παιχνίδι Sudoku"},
            {"Login","Σύνδεση"},
            {"Duidoku Game","Παιχνίδι Duidoku"},
            {"Your turn to play","Η σειρά σου να παίξεις"},
            {"You can't solve Duidoku. \n Please check Hint for help.","Δεν μπορείς να λύσεις το Duidoku. \n Παρακαλώ έλεγξε την Βοήθεια."}
    };
}
