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
public class GetAllTeamsByLeagueIdServiceTest {
    
 


    /**
     * Test of execute method, of class GetAllTeamsByLeagueIdService.
     * Show that that the method return null if input is not allowed (below 1)
     */
    @Test
    public void testExecute_ErrorHandlingTest() {
        System.out.println("execute_ErrorHandling");
        int id = 0;
        Broker broker = getMockedBrokerFactoryWithBrokersSetup(); 
        DbConn conn = mock(DbConn.class); 
        GetAllTeamsByLeagueIdService service = new GetAllTeamsByLeagueIdService();
        service.init(conn, broker);
        assertNull(service.execute(id));
        verify(broker.getTeamBroker(),times(0))
                .findAllSQL("SELECT * FROM teams WHERE league_id = ?","0");
    }
    /**
     * Test of execute method, of class GetAllTeamsByLeagueIdService.
     * Making sure it calls expected methods with expected input.
     */
    @Test
    public void executeBehaviourTest() {
        System.out.println("executeBehaviour");
        int id = 1;
        Broker broker = getMockedBrokerFactoryWithBrokersSetup(); 
        DbConn conn = mock(DbConn.class); 
        GetAllTeamsByLeagueIdService service = new GetAllTeamsByLeagueIdService();
        service.init(conn, broker);
        assertNotNull(service.execute(id));
        verify(broker.getTeamBroker(),times(1))
                .findAllSQL("SELECT * FROM teams WHERE league_id = ?","1");
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
        List <Team> teams = new ArrayList<>();
        teams.add(team);
        when(teamBroker.findAllSQL("SELECT * FROM teams WHERE league_id = ?","1")).thenReturn(teams); 
        return broker; 
    } 
}
