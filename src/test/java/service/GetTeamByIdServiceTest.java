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
    
    /**
     * Test of execute method, of class GetTeamByIdService.
     */
    @Test
    public void testExecute() {
        System.out.println("execute behaviour");
        Broker broker = getMockedBrokerFactoryWithBrokersSetup(); 
        DbConn conn = mock(DbConn.class); 
        GetTeamByIdService service = new GetTeamByIdService();
        service.init(conn, broker);
        assertNotNull(service.execute(1));
        verify(broker.getTeamBroker(),times(1)).findById(1);
    }
    @Test
    public void executeErrorHandlingTest(){
        System.out.println("Error handling execute()");
        Broker broker = getMockedBrokerFactoryWithBrokersSetup(); 
        DbConn conn = mock(DbConn.class); 
        GetTeamByIdService service = new GetTeamByIdService();
        service.init(conn, broker);
        Team team = service.execute(0);
        //Excpecting zero interaction since service.execute(0) is instantly stopped.
        verify(broker.getTeamBroker(),times(0)).findById(0);
        assertEquals(team,null);
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
        when(teamBroker.findById(0)).thenReturn(null); 
        return broker; 
    } 
}
