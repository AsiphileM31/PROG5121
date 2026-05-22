/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package my.com.Loginproject1;

class Login {
    private String password;
    private String username;
    private String firstName;
    private String lastName;

    private static class Checkpassword {

        public Checkpassword() {
        }
    }
}
/**
 *
 * @author Student
 */
public class Loginproject1 {
    private String username;
    private String password;

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
        private Object Checkusername;
    private String firstName;
    private String lastName;
    
    
    /**
     * Verifies login credentials against the stored user.
     *
     * @param username entered username
     * @param password entered password
     * @return true if credentials match, false otherwise
     */
 public boolean loginUser(String username, String password) {
    if (this.username.equals(username) && this.password.equals(password)) 
         }
    /**
     * Returns a login status message based on the authentication result.
     *
     * @param loginSuccess result of loginUser()
     * @return welcome message if successful, error message otherwise
     */
    public String returnLoginStatus(boolean loginSuccess) {
        if (loginSuccess) {
            return "welcome " + firstName + ", " + lastName + " it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }

    // Getters for testing and potential later use
    public String getUsername()  { return username; }
    public String getPassword()  {return password; }
    


  