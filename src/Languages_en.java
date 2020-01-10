import java.util.ListResourceBundle;
/**
 * This class contains the words that need translation.
 * @author Maria Eskioglou 3237
 */
public class Languages_en extends ListResourceBundle {
    /**
     * Returns the contents of the matrix with the translation.
     * @return the matrix.
     */
    @Override
    public Object[][] getContents() {
        return contents;
    }

    private final Object[][] contents = {
            {"Menu", "Menu"},
            {"Sign In","Sign In"},
            {"Login","Login"},
            {"Sign Up", "Sign Up"},
            {"Anonymous","Anonymous"},
            {"Sudoku Game","Sudoku Game"},
            {"Solve","Solve"},
            {"Save","Save"},
            {"Hint","Hint"},
            {"New Game","New Game"},
            {"Load Game","Load Game"},
            {"Statistics","Statistics"},
            {"Return","Return"},
            {"Error","Error"},
            {"Message","Message"},
            {"Value could not be set","Value could not be set"},
            {"1 is acceptable \n","1 is acceptable \n"},
            {"2 is acceptable \n","2 is acceptable \n"},
            {"3 is acceptable \n","3 is acceptable \n"},
            {"4 is acceptable \n","4 is acceptable \n"},
            {"5 is acceptable \n","5 is acceptable \n"},
            {"6 is acceptable \n","6 is acceptable \n"},
            {"7 is acceptable \n","7 is acceptable \n"},
            {"8 is acceptable \n","8 is acceptable \n"},
            {"9 is acceptable \n","9 is acceptable \n"},
            {"Value set \n","Value set \n"},
            {"Error:Please enter number from 1 to 9","Error:Please enter number from 1 to 9"},
            {"Error:Please enter number from 1 to 4","Error:Please enter number from 1 to 4"},
            {"You lost the game!","You lost the game"},
            {"You won the game!","You won the game"},
            {"'s Statistics","'s Statistics"},
            {"Congratulations","Congratulations"},
            {"Try Again","Try Again"},
            {"Row: ","Row"},
            {"Register","Register"},
            {"Registration","Registration"},
            {"Column: ","Column"},
            {"OK","OK"},
            {"Acceptable Numbers","Acceptable Numbers"},
            {"Confirmation","Confirmation"},
            {"Please confirm your username:","Please confirm your username:"},
            {"Submit","Submit"},
            {"'s Statistics","'s Statistics"},
            {"Registration Page","Registration Page"},
            {"Username:","Username:"},
            {"Password:","Password:"},
            {"Killer Game","Killer Game"},
            {"Duidoku","Duidoku"},
            {"Your turn to play","Your turn to play"},
            {"You can't solve Duidoku. \n Please check Hint for help.","You can't solve Duidoku. \n Please check Hint for help."}



    };
}
