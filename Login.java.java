package Assignment_1;

public class Login {
    private String storedUsername;
    private String storedPassword;
    private String storedFirstName;
    private String storedLastName;

    public Login() {
    }

    // Username validation
    public boolean checkUserName(String username) {
        return username != null && username.contains("_") && username.length() <= 5;
    }

    // Password validation
    public boolean checkPasswordComplexity(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }
        
        String capital = ".*[A-Z].*";
        String small = ".*[a-z].*";
        String special = ".*[!@#$%^&*(),.?\":{}|<>].*";
        String digit = ".*\\d.*";

        return password.matches(capital)
                && password.matches(small)
                && password.matches(special)
                && password.matches(digit);
    }

    // Phone validation
    public boolean checkCellPhoneNumber(String phone) {
        if (phone == null) {
            return false;
        }
        
        String cleaned = phone.replaceAll("\\s+", "");
        
        if (cleaned.length() <= 12 && cleaned.startsWith("+27") && cleaned.length() >= 10) {
            if (cleaned.length() > 3) {
                int fourthDigit = Character.getNumericValue(cleaned.charAt(3));
                return fourthDigit >= 6 && fourthDigit <= 8;
            }
        }
        return false;
    }

    // Register user
    public String registerUser(String username, String password, String phone, String firstName, String lastName) {
        if (checkUserName(username)
                && checkPasswordComplexity(password)
                && checkCellPhoneNumber(phone)) {
            
            this.storedUsername = username;
            this.storedPassword = password;
            this.storedFirstName = firstName;
            this.storedLastName = lastName;
            
            return "User is successfully registered";
        }
        return "User registration failed";
    }

    // Login validation
    public boolean loginUser(String storedUsername, String storedPassword,
                            String enteredUsername, String enteredPassword) {
        return storedUsername != null && storedUsername.equals(enteredUsername)
                && storedPassword != null && storedPassword.equals(enteredPassword);
    }

    // Login status
    public String returnLoginStatus(boolean loginStatus, String firstName, String lastName) {
        if (loginStatus) {
            return "Welcome " + firstName + " " + lastName + ", it is great to see you again.";
        }
        return "Username or password incorrect, please try again.";
    }
    
    public String getStoredUsername() {
        return storedUsername;
    }
    
    public String getStoredPassword() {
        return storedPassword;
    }
}