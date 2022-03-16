/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package service;

import Broker.Broker;
import Broker.SportBroker;
import Broker.TeamBroker;
import db.DbConn;
import domain.Sport;
import domain.Team;
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

/**
 *
 * @author Dator
 */
public class GetTeamByIdServiceTest {
    
    public GetTeamByIdServiceTest() {
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
     * Test of init method, of class GetTeamByIdService.
     */
    @Test
    public void testInit() {
        System.out.println("init");
        DbConn dbConn = null;
        Broker broker = null;
        GetTeamByIdService instance = new GetTeamByIdService();
        instance.init(dbConn, broker);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of execute method, of class GetTeamByIdService.
     */
    @Test
    public void testExecute() {
        System.out.println("execute");
        Broker broker = getMockedBrokerFactoryWithBrokersSetup(); 
        DbConn conn = mock(DbConn.class); 
        GetTeamByIdService service = new GetTeamByIdService();
        service.init(conn, broker);
        service.execute(1);
        verify(broker,times(1)).getTeamBroker();
    }
    
    
    
    
      private Broker getMockedBrokerFactory() { 
        TeamBroker teamBroker = mock(TeamBroker.class); 
        Broker broker = mock(Broker.class); 
        when(broker.getTeamBroker()).thenReturn(teamBroker); 
        return broker; 
    } 
     
    private Broker getMockedBrokerFactoryWithBrokersSetup() { 
        Broker broker = getMockedBrokerFactory(); 
        Team team = mock(Team.class); 
        TeamBroker teamBroker =  broker.getTeamBroker(); 
        when(teamBroker.findById(1)).thenReturn(team); 
       // when(teamBroker.findById(0)).thenReturn(null); 
        when(teamBroker.create()).thenReturn(team); 
        return broker; 
    } 
}
