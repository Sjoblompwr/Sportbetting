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
import records.PlayerRecord;

/**
 *
 * @author Dator
 */
public class PlayerTest {

    public PlayerTest() {
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
     * Test of getId method, of class Player.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        PlayerRecord playerRecordMock = mock(PlayerRecord.class);
        Player instance = new Player(playerRecordMock);
        when(playerRecordMock.getString("id")).thenReturn("1");
        instance.getId();
        verify(playerRecordMock,times(1)).getString("id");
    }

    /**
     * Test of getName method, of class Player.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        PlayerRecord playerRecordMock = mock(PlayerRecord.class);
        Player instance = new Player(playerRecordMock);
        when(playerRecordMock.getString("name")).thenReturn("1");
        instance.getName();
        verify(playerRecordMock,times(1)).getString("name");
    }
    /**
     * Test of getTeamId method, of class Player.
     */
    @Test
    public void testGetTeamId() {
        System.out.println("getTeamId");
        PlayerRecord playerRecordMock = mock(PlayerRecord.class);
        Player instance = new Player(playerRecordMock);
        when(playerRecordMock.getString("team_id")).thenReturn("1");
        instance.getTeamId();
        verify(playerRecordMock,times(1)).getString("team_id");
    }



    /**
     * Test of setTeamId method, of class Player.
     */
    @Test
    public void testSetTeamId() {
        System.out.println("setTeamId");
        PlayerRecord playerRecordMock = mock(PlayerRecord.class);
        Player instance = new Player(playerRecordMock);
        instance.setTeamId(1);
        verify(playerRecordMock,times(1)).set("team_id",1);
    }

//    /**
//     * Test of insert method, of class Player.
//     */
//    @Test
//    public void testInsert() throws Exception {
//        System.out.println("insert");
//        Player instance = new Player();
//        boolean expResult = false;
//        boolean result = instance.insert();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of findAll method, of class Player.
//     */
//    @Test
//    public void testFindAll() {
//        System.out.println("findAll");
//        List<Player> expResult = null;
//        List<Player> result = Player.findAll();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of findById method, of class Player.
//     */
//    @Test
//    public void testFindById() {
//        System.out.println("findById");
//        int x = 0;
//        Player expResult = null;
//        Player result = Player.findById(x);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }




}
