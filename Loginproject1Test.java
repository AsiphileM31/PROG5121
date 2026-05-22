/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package my.com.loginproject1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Student
 */
public class Loginproject1Test {
    
    public Loginproject1Test() {
    }

    /**
     *
     * @throws Exception
     */
    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    /**
     *
     * @throws Exception
     */
    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    /**
     *
     * @throws Exception
     */
    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    /**
     *
     * @throws Exception
     */
    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }
    
    @BeforeAll
    public static void testUsernameCorrectlyFormatted() {
        System.out.println("Setup class");
    }
    
    @AfterAll
    public static void testPasswordMeetsComplexity() {
    }
    
    @BeforeEach
    public void testCellPhoneCorrectlyFormatted () {
        System.out.println("Setup before each test");
    }
    
    @AfterEach
    public void teardown () {
    }

    /**
     * Test of checkUserName method, of class Loginproject1.
     */
    @org.junit.jupiter.api.Test
    public void testCheckUserName() {
        System.out.println("checkUserName");
        String username = "";
        boolean expResult = false; 
        boolean result = Loginproject1.checkUserName(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkPasswordComplexity method, of class Loginproject1.
     */
    @org.junit.jupiter.api.Test
    public void testCheckPasswordComplexity() {
        System.out.println("checkPasswordComplexity");
        String password = "";
        boolean expResult = false;
        boolean result = Loginproject1.checkPasswordComplexity(password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkCellPhoneNumber method, of class Loginproject1.
     */
    @org.junit.jupiter.api.Test
    public void testCheckCellPhoneNumber() {
        System.out.println("checkCellPhoneNumber");
        String cellNumber = "";
        boolean expResult = false;
        boolean result = Loginproject1.checkCellPhoneNumber(cellNumber);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registerUser method, of class Loginproject1.
     */
    @org.junit.jupiter.api.Test
    public void testRegisterUser() {
        System.out.println("registerUser");
        String firstName = "";
        String lastName = "";
        String username = "";
        String password = "";
        String cellNumber = "";
        Loginproject1 instance = new Loginproject1();
        String expResult = "";
        String result = instance.registerUser(firstName, lastName, username, password, cellNumber);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of loginUser method, of class Loginproject1.
     */
    @org.junit.jupiter.api.Test
    public void testLoginUser() {
        System.out.println("loginUser");
        String username = "";
        String password = "";
        Loginproject1 instance = new Loginproject1();
        boolean expResult = false;
        boolean result = instance.loginUser(username, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of returnLoginStatus method, of class Loginproject1.
     */
    @org.junit.jupiter.api.Test
    public void testReturnLoginStatus() {
        System.out.println("returnLoginStatus");
        boolean loginSuccess = false;
        Loginproject1 instance = new Loginproject1();
        String expResult = "";
        String result = instance.returnLoginStatus(loginSuccess);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFirstName method, of class Loginproject1.
     */
    @org.junit.jupiter.api.Test
    public void testGetFirstName() {
        System.out.println("getFirstName");
        Loginproject1 instance = new Loginproject1();
        String expResult = "";
        String result = instance.getFirstName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLastName method, of class Loginproject1.
     */
    @org.junit.jupiter.api.Test
    public void testGetLastName() {
        System.out.println("getLastName");
        Loginproject1 instance = new Loginproject1();
        String expResult = "";
        String result = instance.getLastName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsername method, of class Loginproject1.
     */
    @org.junit.jupiter.api.Test
    public void testGetUsername() {
        System.out.println("getUsername");
        Loginproject1 instance = new Loginproject1();
        String expResult = "";
        String result = instance.getUsername();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPassword method, of class Loginproject1.
     */
    @org.junit.jupiter.api.Test
    public void testGetPassword() {
        System.out.println("getPassword");
        Loginproject1 instance = new Loginproject1();
        String expResult = "";
        String result = instance.getPassword();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCellNumber method, of class Loginproject1.
     */
    @org.junit.jupiter.api.Test
    public void testGetCellNumber() {
        System.out.println("getCellNumber");
        Loginproject1 instance = new Loginproject1();
        String expResult = "";
        String result = instance.getCellNumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
