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
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import org.mockito.verification.VerificationMode;

/**
 *
 * @author David Sjöblom
 */
public class GetAllSportsServiceTest {
 
    /**
     * Test of execute method, of class GetAllSportsService.
     */
    @Test
    public void testExecute() {
        System.out.println("execute");
        Broker broker = getMockedBrokerFactoryWithBrokersSetup(); 
        DbConn conn = mock(DbConn.class); 
        GetAllSportsService service = new GetAllSportsService();
        service.init(conn, broker);
        service.execute();
        verify(broker.getSportBroker(),times(1))
                
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
        Sport sport = new Sport();
        List <Sport> sports = new ArrayList<>();
        sports.add(sport);
        when(sportBroker.findAll()).thenReturn(sports); 
        return broker; 
    } 

    private Object verify(SportBroker sportBroker, VerificationMode times) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
