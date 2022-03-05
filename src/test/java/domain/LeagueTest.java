/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package domain;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import records.LeagueRecord;

/**
 *
 * @author Dator
 */
public class LeagueTest {

    public LeagueTest() {
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
     * Test of getLeagueID method, of class League.
     */
    @Test
    public void testGetId() {
        LeagueRecord leagueRecordMock = mock(LeagueRecord.class);
        when(leagueRecordMock.getString("id")).thenReturn("1"); // the thenReturn is the "database" where we control the input for testing purposes
        League instance = new League(leagueRecordMock);
        int expResult = 1;
        int result = instance.getId();
        assertEquals(expResult, result);
        verify(leagueRecordMock, times(1)).getString("id");
    }

    /**
     * Test of getLeagueName method, of class League.
     * Might be able to fix a behaviour test, altho the sending of the id 
     * requires db access unless we rewrite the method call.
     */
    @Test
    public void testSetName() {
        LeagueRecord leagueRecordMock = mock(LeagueRecord.class);
        League instance = new League(leagueRecordMock);

        try {
            instance.setName("Knatte"); 
            verify(leagueRecordMock,times(1)).set("name","Knatte");
        } catch (ExceptionClass ex) {
            System.out.println("Behaviour test fail for setName");
        }

        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of getSeasonId method, of class League.
     */
    @Test
    public void testGetSeasonId() {
//        System.out.println("getSeasonId");
//        League instance = new League();
//        int expResult = 0;
//        int result = instance.getSeasonId();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

}
