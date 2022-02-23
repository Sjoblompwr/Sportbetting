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
    public void testGetLeagueID() {
        LeagueRecord leagueRecordMock = mock(LeagueRecord.class);
          when(leagueRecordMock.getString("id")).thenReturn("1"); // the thenReturn is the "database" where we control the input for testing purposes
        League instance = new League(leagueRecordMock);
        int expResult = 1;
     int result  =instance.getLeagueID();
        assertEquals(expResult, result);
        verify(leagueRecordMock,times(1)).getString("id");
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getLeagueName method, of class League.
     */
    @Test
    public void testGetLeagueName() {
        System.out.println("getLeagueName");
        League instance = new League();
        String expResult = "";
        String result = instance.getLeagueName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSeasonId method, of class League.
     */
    @Test
    public void testGetSeasonId() {
        System.out.println("getSeasonId");
        League instance = new League();
        int expResult = 0;
        int result = instance.getSeasonId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
