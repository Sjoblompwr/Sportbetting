/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package service;

import Broker.Broker;
import Broker.TeamBroker;
import db.DbConn;
import domain.Team;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 *
 * @author David Sjöblom
 */
public class GetAllTeamsBySportIdServiceTest {
    /**
     * Testing error handling, if input is invalid.
     */
    @Test
    public void testExecute_ErrorHandlingTest(){
        System.out.println("Error handling execute()");
        Broker broker = getMockedBrokerFactoryWithBrokersSetup(); 
        DbConn conn = mock(DbConn.class); 
        GetAllTeamsBySportIdService service = new GetAllTeamsBySportIdService();
        service.init(conn, broker);
        List<Team> team = service.execute(0);
        //Excpecting zero interaction since service.execute(0) is instantly stopped.
        assertEquals(team,null);
    }
    /**
     * test execute behaviour
     */
    @Test
    public void testExecute_Behaviour(){
        System.out.println("execute_behaviour");
        Broker broker = getMockedBrokerFactoryWithBrokersSetup(); 
        DbConn conn = mock(DbConn.class); 
        GetAllTeamsBySportIdService service = new GetAllTeamsBySportIdService();
        service.init(conn, broker);
        assertNotNull(service.execute(1));
        //Excpecting zero interaction since service.execute(0) is instantly stopped.
        verify(broker.getTeamBroker(),times(1)).findAll();
    }

    
      private Broker getMockedBrokerFactory() { 
        TeamBroker teamBroker = mock(TeamBroker.class); 
        Broker broker = mock(Broker.class); 
        when(broker.getTeamBroker()).thenReturn(teamBroker); 
        return broker; 
    } 
     
    private Broker getMockedBrokerFactoryWithBrokersSetup() { 
        Broker broker = getMockedBrokerFactory(); 
        Team team = new Team();
        List<Team> teams = new ArrayList<>();
        teams.add(team);
        when(broker.getTeamBroker().findAll()).thenReturn(teams);
        return broker; 
    } 
}
