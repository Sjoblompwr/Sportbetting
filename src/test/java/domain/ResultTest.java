/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Dator
 */
public class ResultTest {
    
    public ResultTest() {
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
     * Test of getResultID method, of class Result.
     */
    @Test
    public void testGetResultID() {
        System.out.println("getResultID");
        Result instance = new Result();
        int expResult = 0;
        int result = instance.getResultID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getResultMatchID method, of class Result.
     */
    @Test
    public void testGetResultMatchID() {
        System.out.println("getResultMatchID");
        Result instance = new Result();
        int expResult = 0;
        int result = instance.getResultMatchID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getResultTeamOneScore method, of class Result.
     */
    @Test
    public void testGetResultTeamOneScore() {
        System.out.println("getResultTeamOneScore");
        Result instance = new Result();
        int expResult = 0;
        int result = instance.getResultTeamOneScore();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getResultTeamTwoScore method, of class Result.
     */
    @Test
    public void testGetResultTeamTwoScore() {
        System.out.println("getResultTeamTwoScore");
        Result instance = new Result();
        int expResult = 0;
        int result = instance.getResultTeamTwoScore();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
