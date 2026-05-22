/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Student
 */
public class RegistrationTest {
    
    public RegistrationTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of checkUserName method, of class Registration.
     */
    @Test
    public void testCheckUserName() {
        System.out.println("checkUserName");
        String username = "";
        boolean expResult = false;
        boolean result = Registration.checkUserName(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkPasswordComplexity method, of class Registration.
     */
    @Test
    public void testCheckPasswordComplexity() {
        System.out.println("checkPasswordComplexity");
        String password = "";
        boolean expResult = false;
        boolean result = Registration.checkPasswordComplexity(password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkCellPhoneNumber method, of class Registration.
     */
    @Test
    public void testCheckCellPhoneNumber() {
        System.out.println("checkCellPhoneNumber");
        String cellNumber = "";
        boolean expResult = false;
        boolean result = Registration.checkCellPhoneNumber(cellNumber);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registerUser method, of class Registration.
     */
    @Test
    public void testRegisterUser() {
        System.out.println("registerUser");
        String firstName = "";
        String lastName = "";
        String username = "";
        String password = "";
        String cellNumber = "";
        Registration instance = new Registration();
        String expResult = "";
        String result = instance.registerUser(firstName, lastName, username, password, cellNumber);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFirstName method, of class Registration.
     */
    @Test
    public void testGetFirstName() {
        System.out.println("getFirstName");
        Registration instance = new Registration();
        String expResult = "";
        String result = instance.getfirstName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLastName method, of class Registration.
     */
    @Test
    public void testGetLastName() {
        System.out.println("getLastName");
        Registration instance = new Registration();
        String expResult = "";
        String result = instance.getlastName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsername method, of class Registration.
     */
    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        Registration instance = new Registration();
        String expResult = "";
        String result = instance.getUsername();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPassword method, of class Registration.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        Registration instance = new Registration();
        String expResult = "";
        String result = instance.getPassword();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCellNumber method, of class Registration.
     */
    @Test
    public void testGetCellNumber() {
        System.out.println("getCellNumber");
        Registration instance = new Registration();
        String expResult = "";
        String result = instance.getCellNumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getfirstName method, of class Registration.
     */
    @org.junit.Test
    public void testGetfirstname() {
        System.out.println("getfirstname");
        Registration instance = new Registration();
        String expResult = "";
        String result = instance.getfirstName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getlastName method, of class Registration.
     */
    @org.junit.Test
    public void testGetlastName() {
        System.out.println("getlastName");
        Registration instance = new Registration();
        String expResult = "";
        String result = instance.getlastName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of firstName method, of class Registration.
     */
    @org.junit.Test
    public void testFirstName() {
        System.out.println("firstName");
        Registration instance = new Registration();
        String expResult = "";
        String result = instance.getfirstName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFirstname method, of class Registration.
     */
    @org.junit.Test
    public void testGetFirstname() {
        System.out.println("getFirstname");
        Registration instance = new Registration();
        String expResult = "";
        String result = instance.getfirstName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getfirstName method, of class Registration.
     */
    @org.junit.Test
    public void testGetfirstName() {
        System.out.println("getfirstName");
        Registration instance = new Registration();
        String expResult = "";
        String result = instance.getfirstName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
