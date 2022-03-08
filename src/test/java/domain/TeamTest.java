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
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import records.TeamRecord;

/**
 *
 * @author Dator
 */
public class TeamTest {

    public TeamTest() {
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
     * Test of getTeamID method, of class Team.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        TeamRecord teamRecordMock = mock(TeamRecord.class);
        Team instance = new Team(teamRecordMock);
        when(teamRecordMock.getString("id")).thenReturn("1");
        instance.getId();
        verify(teamRecordMock,times(1)).getString("id");
    }

    /**
     * Test of getName method, of class Team.
     */
    @Test
    public void testGetName() {
        System.out.println("getTeamName");
        TeamRecord teamRecordMock = mock(TeamRecord.class);
        Team instance = new Team(teamRecordMock);
        when(teamRecordMock.getString("name")).thenReturn("1");
        instance.getName();
        verify(teamRecordMock,times(1)).getString("name");
    }





//    /**
//     * Test of insert method, of class Team.
//     */
//    @Test
//    public void testInsert() {
//        System.out.println("insert");
//        Team instance = new Team();
//        boolean expResult = false;
//        boolean result = instance.insert();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of findAll method, of class Team.
//     */
//    @Test
//    public void testFindAll() {
//        System.out.println("findAll");
//        List<Team> expResult = null;
//        List<Team> result = Team.findAll();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of findById method, of class Team.
//     */
//    @Test
//    public void testFindById() {
//        System.out.println("findById");
//        int x = 0;
//        Team expResult = null;
//        Team result = Team.findById(x);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    

}
