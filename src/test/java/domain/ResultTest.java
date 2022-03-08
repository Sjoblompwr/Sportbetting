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
import records.ResultRecord;

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
    public void testGetId() {
        System.out.println("getId");
        ResultRecord resultRecordMock = mock(ResultRecord.class);
        Result instance = new Result(resultRecordMock);
        when(resultRecordMock.getString("id")).thenReturn("1");
        instance.getId();
        verify(resultRecordMock,times(1)).getString("id");

    }

    /**
     * Test of getResultMatchID method, of class Result.
     */
    @Test
    public void testGetMatchId() {
        System.out.println("getMatchID");
        ResultRecord resultRecordMock = mock(ResultRecord.class);
        Result instance = new Result(resultRecordMock);
        when(resultRecordMock.getString("match_id")).thenReturn("1");
        instance.getMatchId();
        verify(resultRecordMock,times(1)).getString("match_id");
    }

    /**
     * Test of getResultTeamOneScore method, of class Result.
     */
    @Test
    public void testGetTeamOneScore() {
        System.out.println("getTeamOneScore");
        ResultRecord resultRecordMock = mock(ResultRecord.class);
        Result instance = new Result(resultRecordMock);
        when(resultRecordMock.getString("team_one_score")).thenReturn("1");
        instance.getTeamOneScore();
        verify(resultRecordMock,times(1)).getString("team_one_score");
    }

    /**
     * Test of getResultTeamTwoScore method, of class Result.
     */
    @Test
    public void testGetTeamTwoScore() {
        System.out.println("getTeamTwoScore");
         ResultRecord resultRecordMock = mock(ResultRecord.class);
        Result instance = new Result(resultRecordMock);
        when(resultRecordMock.getString("team_two_score")).thenReturn("1");
        instance.getTeamTwoScore();
        verify(resultRecordMock,times(1)).getString("team_two_score");
    }



    /**
     * Test of setMatchId method, of class Result.
     */
    @Test
    public void testSetMatchId() {
        System.out.println("setMatchId");
        ResultRecord resultRecordMock = mock(ResultRecord.class);
        Result instance = new Result(resultRecordMock);
        instance.setMatchId(1);
        verify(resultRecordMock,times(1)).set("match_id",1);
    }

    /**
     * Test of setTeamOneScore method, of class Result.
     */
    @Test
    public void testSetTeamOneScore() {
        System.out.println("setTeamOneScore");
        ResultRecord resultRecordMock = mock(ResultRecord.class);
        Result instance = new Result(resultRecordMock);
        instance.setTeamOneScore(1);
        verify(resultRecordMock,times(1)).set("team_one_score",1);
    }

    /**
     * Test of setTeamTwoScore method, of class Result.
     */
    @Test
    public void testSetTeamTwoScore() {
        System.out.println("setTeamTwoScore");
        ResultRecord resultRecordMock = mock(ResultRecord.class);
        Result instance = new Result(resultRecordMock);
        instance.setTeamTwoScore(1);
        verify(resultRecordMock,times(1)).set("team_two_score",1);
    }
//
//    /**
//     * Test of insert method, of class Result.
//     */
//    @Test
//    public void testInsert() throws Exception {
//        System.out.println("insert");
//        Result instance = new Result();
//        boolean expResult = false;
//        boolean result = instance.insert();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of findAll method, of class Result.
//     */
//    @Test
//    public void testFindAll() {
//        System.out.println("findAll");
//        List<Result> expResult = null;
//        List<Result> result = Result.findAll();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of findById method, of class Result.
//     */
//    @Test
//    public void testFindById() {
//        System.out.println("findById");
//        int x = 0;
//        Result expResult = null;
//        Result result = Result.findById(x);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

}
