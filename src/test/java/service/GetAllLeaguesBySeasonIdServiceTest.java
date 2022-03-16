/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package service;

import Broker.Broker;
import db.DbConn;
import java.util.List;
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
public class GetAllLeaguesBySeasonIdServiceTest {
    
    public GetAllLeaguesBySeasonIdServiceTest() {
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
     * Test of init method, of class GetAllLeaguesBySeasonIdService.
     */
    @Test
    public void testInit() {
        System.out.println("init");
        DbConn dbConn = null;
        Broker broker = null;
        GetAllLeaguesBySeasonIdService instance = new GetAllLeaguesBySeasonIdService();
        instance.init(dbConn, broker);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of execute method, of class GetAllLeaguesBySeasonIdService.
     */
    @Test
    public void testExecute() {
        System.out.println("execute");
        int id = 0;
        GetAllLeaguesBySeasonIdService instance = new GetAllLeaguesBySeasonIdService();
        List expResult = null;
        List result = instance.execute(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
