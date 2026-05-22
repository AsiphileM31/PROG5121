/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Student
 */
public class Registration {
private String firstname;
private String lastname;
private String username;
private String password;
private String cellNumber;

    /**
     * Validates the username format.
     *
     * @param username the username to check
     * @return true if valid, false otherwise
     */
    public static boolean checkUserName(String username) {
        return username != null && username.contains("_") && username.length() <= 5;
    }

    /**
     * Validates the password complexity.
     * @param password the password to check
     * @return true if valid, false otherwise
     */
    public static boolean checkPasswordComplexity(String password) {
        if (password == null || password.length() < 8) return false;
        boolean hasCapital = false;
        boolean hasNumber = false;
        boolean hasSpecial = false;
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) hasCapital = true;
            else if (Character.isDigit(c)) hasNumber = true;
            else if (!Character.isLetterOrDigit(c)) hasSpecial = true;
        }
        return hasCapital && hasNumber && hasSpecial;
    }

    /**
     * Validates a South African cell phone number.
     * Conditions:
     * - Contains the international country code (+27)
     * - The number part (after +27) is 9–10 digits
     * @param cellNumber
     * @return 
     */
    public static boolean checkCellPhoneNumber(String cellNumber) {
        if (cellNumber == null) return false;
        // Remove all spaces to simplify matching
        String cleaned = cellNumber.replaceAll("\\s+", "");
        // Accept +27 followed by 9 or 10 digits
        return cleaned.matches("^\\+27[0-9]{9,10}$");
    }
    private String lastName;
    private String Firstname;
   /**
     * Registers a new user.
     * @param firstName  user's first name
     * @param lastName   user's last name
     * @param username   desired username
     * @param password   desired password
     * @param cellNumber cell phone number
     * @return a message indicating the result of the registration attempt
     */
    public String registerUser(String firstName, String lastName, String username,
                               String password, String cellNumber) {
        if (!checkUserName(username)) {
            return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        }
        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }
        if (!checkCellPhoneNumber(cellNumber)) {
            return "Cell phone number incorrectly formatted or does not contain international code.";
        }
        // All valid – store the user data
        this.firstname = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.cellNumber = cellNumber;
        return "Registration successful."; 
 
        // Getters for testing and potential later use
       public String getfirstName() {return firstname; }       
       public String getlastName() {return lastname; }
       public String getUsername()  { return username; }
       public String getPassword()  { return password; }
       public String getCellNumber() { return cellNumber; }

    }

 
    

  
