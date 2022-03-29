/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package service;

import Broker.Broker;
import Broker.TeamBroker;
import db.DbConn;
import domain.ExceptionClass;
import domain.Team;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class GetTeamByIdServiceTest {
    
    /**
     * Test of execute method, of class GetTeamByIdService.
     * checking if the correct method is called.
     */
    @Test
    public void testExecute_behaviour() {
        System.out.println("execute_behaviour");
        int id = 1;
        Broker broker = getMockedBrokerFactoryWithBrokersSetup(); 
        GetTeamByIdService service = null;
        try {
            service = new GetTeamByIdService(id);
        } catch (ExceptionClass ex) {
            System.out.println(ex);
        }
        ServiceRunner serviceRunner = new ServiceRunner(service);
        serviceRunner.execute();
        verify(broker.getTeamBroker(),times(1)).findById(1);
    }
    /**
     * Test of execute method, of class GetTeamByIdService.
     * Checking if method return null when input is invalid.
     */
    @Test
    public void testExecute_ErrorHandlingTest(){
        System.out.println("Error handling execute()");
        int id = 0;
        Broker broker = getMockedBrokerFactoryWithBrokersSetup(); 
        DbConn conn = mock(DbConn.class); 
        GetTeamByIdService service = null;
        try {
            service = new GetTeamByIdService(id);
        } catch (ExceptionClass ex) {
            System.out.println(ex);
        }
        ServiceRunner serviceRunner = new ServiceRunner(service);
        serviceRunner.execute();
        assertNull(serviceRunner.execute());
        verify(broker.getTeamBroker(),times(0)).findById(0);
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
