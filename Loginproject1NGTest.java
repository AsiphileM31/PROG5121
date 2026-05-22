/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package my.com.loginproject1;

import static org.testng.Assert.*;

/**
 *
 * @author Student
 */
public class Loginproject1NGTest {
    
    public Loginproject1NGTest() {
    }

    @org.testng.annotations.BeforeClass
    public static void setUpClass() throws Exception {
    }

    @org.testng.annotations.AfterClass
    public static void tearDownClass() throws Exception {
    }

    @org.testng.annotations.BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @org.testng.annotations.AfterMethod
    public void tearDownMethod() throws Exception {
    }

    /**
     * Test of returnLoginStatus method, of class Loginproject1.
     */
    @org.testng.annotations.Test
    public void testReturnLoginStatus() {
        System.out.println("returnLoginStatus");
        boolean loginSuccess = false;
        Loginproject1 instance = new Loginproject1();
        String expResult = "";
        String result = instance.returnLoginStatus(loginSuccess);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsername method, of class Loginproject1.
     */
    @org.testng.annotations.Test
    public void testGetUsername() {
        System.out.println("getUsername");
        Loginproject1 instance = new Loginproject1();
        String expResult = "";
        String result = instance.getUsername();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPassword method, of class Loginproject1.
     */
    @org.testng.annotations.Test
    public void testGetPassword() {
        System.out.println("getPassword");
        Loginproject1 instance = new Loginproject1();
        String expResult = "";
        String result = instance.getPassword();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
