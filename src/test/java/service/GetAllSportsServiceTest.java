/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package service;

import Broker.Broker;
import Broker.SportBroker;
import db.DbConn;
import domain.Sport;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 *
 * @author David Sjöblom
 */
public class GetAllSportsServiceTest {
 
    /**
     * Test of execute method, of class GetAllSportsService.
     * Checking if expected function is called.
     * 
     */
    @Test
    public void testExecuteBehaviourTest() {
        System.out.println("execute_Behaviour");
        Broker broker = getMockedBrokerFactoryWithBrokersSetup(); 
        DbConn conn = mock(DbConn.class); 
        GetAllSportsService service = new GetAllSportsService();
        service.init(broker);
        service.execute();
        verify(broker.getSportBroker(),times(1)).findAll();
                
    }
    /**
     * Test of execute method, of class GetAllSportsService.
     * Checking if something is returned from the method call.
     */
    @Test
    public void testExecute_IsSomethingReturned() {
        System.out.println("execute_IsSomethingReturned");
        Broker broker = getMockedBrokerFactoryWithBrokersSetup(); 
        DbConn conn = mock(DbConn.class); 
        GetAllSportsService service = new GetAllSportsService();
        service.init(broker);
        assertNotNull(service.execute());     
    }
    
    
    
    private Broker getMockedBrokerFactory() { 
        SportBroker sportBroker = mock(SportBroker.class); 
        Broker broker = mock(Broker.class); 
        when(broker.getSportBroker()).thenReturn(sportBroker); 
        return broker; 
    } 
    private Broker getMockedBrokerFactoryWithBrokersSetup() { 
        Broker broker = getMockedBrokerFactory();
        SportBroker sportBroker =  broker.getSportBroker();
        Sport sport = mock(Sport.class);
        List <Sport> sports = new ArrayList<>();
        sports.add(sport);
        when(sportBroker.findAll()).thenReturn(sports); 
        return broker; 
    } 
}
