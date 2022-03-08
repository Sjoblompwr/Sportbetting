/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package domain;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import records.MatchRecord;

/**
 *
 * @author Dator
 */
public class MatchTest {
    
    public MatchTest() {
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
     * Test of getId method, of class Match.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        MatchRecord matchRecordMock = mock(MatchRecord.class);
        Match instance = new Match(matchRecordMock);
        when(matchRecordMock.getString("id")).thenReturn("1");
        instance.getId();
        verify(matchRecordMock,times(1)).getString("id");
    }

    /**
     * Test of getLeagueId method, of class Match.
     */
    @Test
    public void testGetLeagueId() {
        System.out.println("getLeagueId");
        MatchRecord matchRecordMock = mock(MatchRecord.class);
        Match instance = new Match(matchRecordMock);
        when(matchRecordMock.getString("league_id")).thenReturn("1");
        instance.getLeagueId();
        verify(matchRecordMock,times(1)).getString("league_id");
    }

    /**
     * Test of getMatchOneId method, of class Match.
     */
    @Test
    public void testGetTeamOneId() {
        System.out.println("getTeamOneId");
        MatchRecord matchRecordMock = mock(MatchRecord.class);
        Match instance = new Match(matchRecordMock);
        when(matchRecordMock.getString("team_one_id")).thenReturn("1");
        instance.getTeamOneId();
        verify(matchRecordMock,times(1)).getString("team_one_id");
    }

    /**
     * Test of getMatchTwoId method, of class Match.
     */
    @Test
    public void testGetTeamTwoId() {
        System.out.println("getTeamTwoId");
        MatchRecord matchRecordMock = mock(MatchRecord.class);
        Match instance = new Match(matchRecordMock);
        when(matchRecordMock.getString("team_two_id")).thenReturn("1");
        instance.getTeamTwoId();
        verify(matchRecordMock,times(1)).getString("team_two_id");
    }

    /**
     * Test of setLeagueId method, of class Match.
     */
    @Test
    public void testSetLeagueId() {
        System.out.println("setLeagueId");
        MatchRecord matchRecordMock = mock(MatchRecord.class);
        Match instance = new Match(matchRecordMock);
        instance.setLeagueId(1);
        verify(matchRecordMock,times(1)).set("league_id",1);
    }

    /**
     * Test of setMatchOneId method, of class Match.
     */
    @Test
    public void testSetTeamOneId() {
        System.out.println("setTeamOneId");
        MatchRecord matchRecordMock = mock(MatchRecord.class);
        Match instance = new Match(matchRecordMock);
        instance.setTeamOneId(1);
        verify(matchRecordMock,times(1)).set("team_one_id",1);
    }

    /**
     * Test of setMatchTwoId method, of class Match.
     */
    @Test
    public void testSetTeamTwoId() {
        System.out.println("setTeamTwoId");
        MatchRecord matchRecordMock = mock(MatchRecord.class);
        Match instance = new Match(matchRecordMock);
        instance.setTeamTwoId(1);
        verify(matchRecordMock,times(1)).set("team_two_id",1);
    }

//    /**
//     * Test of insert method, of class Match.
//     */
//    @Test
//    public void testInsert() {
//        System.out.println("insert");   
//        MatchRecord matchRecordMock = mock(MatchRecord.class);
//        Match instance = new Match(matchRecordMock);
//        boolean expResult = false;
//        boolean result = instance.insert();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of findAll method, of class Match.
//     */
//    @Test
//    public void testFindAll() {
//        System.out.println("findAll");
//               MatchRecord matchRecordMock = mock(MatchRecord.class);
//        Match instance = new Match(matchRecordMock);
//        List<Match> expResult = null;
//        List<Match> result = Match.findAll();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of findById method, of class Match.
//     */
//    @Test
//    public void testFindById() {
//        System.out.println("findById");
//               MatchRecord matchRecordMock = mock(MatchRecord.class);
//        Match instance = new Match(matchRecordMock);
//        int id = 0;
//        Match expResult = null;
//        Match result = Match.findById(id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
